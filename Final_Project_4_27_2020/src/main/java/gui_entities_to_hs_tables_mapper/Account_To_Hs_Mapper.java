package gui_entities_to_hs_tables_mapper;

import java.sql.Connection;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Acct_View;
import services.hs_services.HS_ACCT_Services;
import services.hs_services.HS_CUAC_Services;
import services.hs_services.HS_CUST_Services;
import utils.DAOException;

public class Account_To_Hs_Mapper {

	private Connection con;

	private static Account_To_Hs_Mapper mapper;

	private Account_To_Hs_Mapper() {

		con = Data_Src_Mgr.get_Serv_Con();
	}

	public static Account_To_Hs_Mapper getInstance() {
		if (mapper == null)
			mapper = new Account_To_Hs_Mapper();
		return mapper;
	}

	public void map_update( Acct_View newVals) {

		mapToHsCust( newVals);
		mapToHsAcct(newVals);
		mapToHsCuac(newVals);
	}

	private void mapToHsCust( Acct_View newVals) {

		HS_CUST_Services services = new HS_CUST_Services(con);
		services.update_from_account(newVals);

	}

	private void mapToHsAcct(Acct_View newVals) {

		HS_ACCT_Services services = new HS_ACCT_Services(con);
		services.update_from_account( newVals);
	}

	private void mapToHsCuac( Acct_View newVals) {

		HS_CUAC_Services services = new HS_CUAC_Services(con);
		services.update_from_account( newVals);
	}

	
	
	public void map_delete(Acct_View view) {
		HS_ACCT_Services services = new HS_ACCT_Services(con);
		try {
			services.delete(view.getNumBank(), view.getTypeAcct(), view.getNumAcct());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
