package services.front_end_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Search_View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.front_end_services.enums.SEARCH_FIELDS;
import utils.DB_Names_Holder;

public class Search_View_Services {
	
	Connection con;
	
	public Search_View_Services() {
		con=Data_Src_Mgr.get_Serv_Con();
	}
	
	public ObservableList<Search_View> getEntities(Search_View user_input) {
		
		List<String> conditions=getConditions(user_input);

		return retrieve(conditions);
			
	}
	
	
	// check if something got selected or not.
	
	private List<String> getConditions(Search_View user_input) {
		
		List<String> conditionsList= new ArrayList<>();
		
		if (!user_input.getCustType().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.Customer_TYPE, user_input.getCustType()));
			
		if (user_input.getAge()!=null && !user_input.getAge().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.AGE, user_input.getAge()));
			
		if (!user_input.getState().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.STATE, user_input.getState()));
		
		if (!user_input.getCreditBureau().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.CREDIT_BUREAU, user_input.getCreditBureau()));
		
		if (!user_input.getPep().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.PEP, user_input.getPep()));

		if (user_input.getZipCode()!=null && !user_input.getZipCode().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.ZIP_CODE, user_input.getZipCode()));

		if (!user_input.getOnlineBanking().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.ONLINE_BANKING, user_input.getOnlineBanking()));

		if (!user_input.getForeignIndicator().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.FOREIGN_IND, user_input.getForeignIndicator()));

		if (!user_input.getSpecialUse().equals("Any"))
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.SPECIAL_USE, user_input.getSpecialUse()));

		
		//this one is a little different I am adding a % at the end because instead of the equal sign =
		//we put the LIKE SQL Operator 
		if (user_input.getName()!=null && !user_input.getName().isBlank())		
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.NAME,"%"+ user_input.getName() + "%"));
		
		if (user_input.getCreditHigh()!=null && !user_input.getCreditHigh().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.CREDIT_RANGE_H, user_input.getCreditHigh()));
		
		if (user_input.getCreditLow()!=null && !user_input.getCreditLow().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.CREDIT_RANGE_L, user_input.getCreditLow()));
		
		if (user_input.getCity()!=null && !user_input.getCity().isBlank())
			conditionsList.add(get_conditions_as_sql_stmts(SEARCH_FIELDS.CITY, user_input.getCity()));
		
		return conditionsList;
		
	}

	protected static String get_conditions_as_sql_stmts(SEARCH_FIELDS field, String value) {
	 	String sql_stmt= field.getVal() + "\'"+value+ "\'"; //these single quotes are important.
	return sql_stmt;
	}
	
	public ObservableList<Search_View> retrieve (List<String> conditions_list) {
		
		
		String query= String.format("select MAX(cus.[TYPECUST]) AS TYPECUST, year (GETDATE()) - year(MAX(ci.[DOB])) As Age " /*age*/
				+ ", MAX(cus.[STATE1]) AS STATE1, MAX(ci.[Bureau]) AS Bureau, MAX(ci.[PEP]) AS PEP"
				+ ", MAX(cus.[ZIP1]) AS ZIP1, MAX(ci.[OnlineBanking]) OnlineBanking, MAX(ci.[ForeignInd]) AS ForeignInd"
				+ ", MAX(ci.[SpecUse]) AS SpecUse, cus.[NAMFULL], MAX(ci.[CreditScore]) AS CreditScore"
				+ ", MAX(cus.[CITY1]) AS CITY1, MAX(cus.CIF) AS CIF, MAX(cus.NUMTAXID) AS NUMTAXID "
				+ ", MAX(cu.[NUMBANK]) AS NUMBANK, MAX(cu.[TYPEACCT]) AS TYPEACCT, MAX(cu.[NUMACCT]) AS NUMACCT "
				+ ", MAX(ci.MortgageAccounts) AS MortgageAccounts, MAX(ci.BankruptcyRecords) AS BankruptcyRecords "
				+ " from %s.ConsumerInfo AS ci JOIN %s.HS_CUST AS cus "
				+ " ON  ci.CIF=cus.CIF "
				+ " JOIN %s.HS_CUAC as cu ON cus.CIF = cu.CIF "
				, DB_Names_Holder.getCi_db_name(), DB_Names_Holder.getHs_db_name(), 
				 DB_Names_Holder.getHs_db_name());
		ResultSet rs=null;
		
		ObservableList<Search_View> entities_to_return = FXCollections.observableArrayList();
		
		if (!conditions_list.isEmpty()) {
			StringBuilder str_builder= new StringBuilder(query);
			
			str_builder.append(" WHERE ");
			
		  for (int i=0; i< conditions_list.size();i++)
			  str_builder.append(conditions_list.get(i) +  " AND ");
		  
		  query=str_builder.toString();
		
		  query=query.substring(0,query.lastIndexOf("AND"));
		}
		
		query+= " GROUP BY cus.NAMFULL";
		
		try (PreparedStatement ps= con.prepareStatement(query)){
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
			entities_to_return.add(Search_View.extractFromResultSet(rs));
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return entities_to_return;
	}

}
