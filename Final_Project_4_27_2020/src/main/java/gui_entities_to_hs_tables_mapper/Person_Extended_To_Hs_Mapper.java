package gui_entities_to_hs_tables_mapper;

import java.sql.Connection;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Person_View;
import services.hs_services.HS_ACCT_Services;
import services.hs_services.HS_CUAC_Services;
import services.hs_services.HS_CUST_Services;

public class Person_Extended_To_Hs_Mapper {

	private static Person_Extended_To_Hs_Mapper mapper;
	private Connection con;

	private Person_Extended_To_Hs_Mapper() {
		con = Data_Src_Mgr.get_Serv_Con();
	}

	public static Person_Extended_To_Hs_Mapper getInstance() {
		if (mapper == null)
			mapper = new Person_Extended_To_Hs_Mapper();
		return mapper;
	}

	public void map_update(Person_View newVals) {
		
		mapToHsCust(newVals);
		mapToHsAcct(newVals);
	}

	private void mapToHsCust(Person_View newVals) {

		HS_CUST_Services services = new HS_CUST_Services(con);
		services.update_from_person_extended(newVals);
	}

	private void mapToHsAcct(Person_View newVals) {

		HS_ACCT_Services services = new HS_ACCT_Services(con);
		services.update_from_person_extended(newVals);
	}

}
