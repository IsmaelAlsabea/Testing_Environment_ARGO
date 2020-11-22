package services.front_end_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Person_View;
import utils.DB_Names_Holder;

public class Person_View_Services {
	
	Connection con;
	
	public Person_View_Services() {
		con=Data_Src_Mgr.get_Serv_Con();
	}
	
	
public Person_View retrieve (String cif) {
		
		//numtaxid is the ssn.
		//I join.
	
		//	String city, state, zipCode, specUse, SpecUseNotes;		
	
		String query= String.format("select ci.[FIRSTNAME], ci.[LASTNAME], ci.[Bureau], ci.[DOB] " 
				+ ", cus.[NUMTAXID], ci.[CreditScore], ci.[ForeignInd], ci.[PEP] "
				+ ", ci.[OnlineBanking], cus.[PHONE1], ci.[EMAILADDRESS], cus.[STREET1A] "
				+ ", cus.[CIF], cus.[TYPECUST], cus.[City1], cus.[State1], cus.[Zip1] "
				+ ",  ci.[specUse], ci.[SpecUseNotes] "
				+ ", cu.[NUMBANK], cu.[TYPEACCT], cu.[NUMACCT] "
				+ " from %s.ConsumerInfo AS ci JOIN %s.HS_CUST AS cus "
				+ " ON  ci.CIF=cus.CIF "
				+ " JOIN %s.HS_CUAC as cu ON cus.CIF = cu.CIF "
				+ " WHERE cus.[CIF] = ? ;"
				, DB_Names_Holder.getCi_db_name(), DB_Names_Holder.getHs_db_name()
				,  DB_Names_Holder.getHs_db_name());
		
		ResultSet rs=null;
		
		Person_View entity_to_return = null;
		
		try (PreparedStatement ps= con.prepareStatement(query)){
			
			ps.setString(1, cif);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			entity_to_return=Person_View.extractFromResultSet(rs);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return entity_to_return;
	}
	
	
	
	
}
