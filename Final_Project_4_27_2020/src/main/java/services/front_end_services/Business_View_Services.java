package services.front_end_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Business_View;
import utils.DB_Names_Holder;

public class Business_View_Services {

	
	Connection con;
	
	public Business_View_Services () {
		con=Data_Src_Mgr.get_Serv_Con();
	}
	
	
public Business_View retrieve(String cif) {
	
	String query= String.format("select cus.[NAMFULL], ci.[yearEstablished] " 
			+ ", cus.[NUMTAXID], cus.[PHONE1], ci.[EMAILADDRESS], cus.[STREET1A] "
			+ ", cus.[CITY1], cus.[STATE1], cus.[ZIP1], cus.[CIF], cus.[TYPECUST] "
			+ ", cu.[NUMBANK], cu.[TYPEACCT], cu.[NUMACCT] "
			+ " from %s.ConsumerInfo AS ci JOIN %s.HS_CUST AS cus "
			+ " ON  ci.CIF=cus.CIF "
			+ " JOIN %s.HS_CUAC as cu ON cus.CIF = cu.CIF "
			+ " WHERE cus.[CIF] = ? ;"
			, DB_Names_Holder.getCi_db_name(), DB_Names_Holder.getHs_db_name()
			,  DB_Names_Holder.getHs_db_name());
	
	ResultSet rs=null;
	
	Business_View entity_to_return = null;
	
	try (PreparedStatement ps= con.prepareStatement(query)){
		
		ps.setString(1, cif);
		
		rs = ps.executeQuery();
		
		rs.next();

		entity_to_return=Business_View.extractFromResultSet(rs);
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	return entity_to_return;
}
	
	
}
