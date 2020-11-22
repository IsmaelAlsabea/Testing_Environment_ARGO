package services.front_end_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data_source_mgr_pac.Data_Src_Mgr;
import entities.front_end_entities.Acct_View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DB_Names_Holder;

public class Acct_View_Services {

	Connection con;
	
	public Acct_View_Services () {
		con=Data_Src_Mgr.get_Serv_Con();
	}
	
	
	public ObservableList<Acct_View> retrieve(String numtaxid) {
		
		// I join.
		String query = String.format("select act.NUMBANK, act.TYPEACCT, act.NUMACCT, act.PRODCODE "
				+ ", act.NUMBRNCH, act.AMTCURBL, act.ACTTITLE1, act.STATUS2, act.LASTDATE "
				+ ", act.DATEOPEN, act.DATECLSE, act.REASONCL, act.DATEBEG, act.DATEEND "
				+ ", cu.CIF, cu.TYPECUST, act.NUMTAXID "			//this is just to define one 
				+ " FROM %s.HS_ACCT AS act JOIN %s.HS_CUAC AS cu ON cu.NUMACCT = act.NUMACCT "
				+ " WHERE act.NUMTAXID = ? ;"
				, DB_Names_Holder.getHs_db_name(), DB_Names_Holder.getHs_db_name());
		ResultSet rs = null;

		ObservableList<Acct_View> entities_to_return = FXCollections.observableArrayList();

		try (PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setString(1, numtaxid);

			rs = ps.executeQuery();

			while (rs.next()) {
				entities_to_return.add(Acct_View.extractFromResultSet(rs));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entities_to_return;
	}

}
