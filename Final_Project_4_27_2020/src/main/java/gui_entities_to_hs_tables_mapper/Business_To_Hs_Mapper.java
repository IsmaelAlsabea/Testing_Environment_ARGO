package gui_entities_to_hs_tables_mapper;

import java.sql.Connection;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Business_View;
import entities.front_end_entities.Person_View;
import services.hs_services.HS_ACCT_Services;
import services.hs_services.HS_CUAC_Services;
import services.hs_services.HS_CUST_Services;

public class Business_To_Hs_Mapper {

	private static Business_To_Hs_Mapper mapper;
	private Connection con;

	private Business_To_Hs_Mapper() {

		con = Data_Src_Mgr.get_Serv_Con();
	}

	public static Business_To_Hs_Mapper getInstance() {
		if (mapper == null)
			mapper = new Business_To_Hs_Mapper();
		return mapper;
	}

	public void map_update(Business_View newVals) {

		mapToHsCust(newVals);
		mapToHsAcct(newVals);
	}

	private void mapToHsCust(Business_View newVals) {
		HS_CUST_Services serv = new HS_CUST_Services(con);
		serv.update_from_business(newVals);
	}

	private void mapToHsAcct(Business_View newVals) {

		HS_ACCT_Services services = new HS_ACCT_Services(con);
		services.update_from_business(newVals);
	}

}
