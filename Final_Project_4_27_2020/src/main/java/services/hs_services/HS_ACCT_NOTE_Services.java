package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_ACCT_NOTE;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_ACCT_NOTE_Services  {

	private Connection con;
	private String hs_db_name;

	public HS_ACCT_NOTE_Services(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void create(HS_ACCT_NOTE acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert

			String sql = String.format(
					"insert into %s.HS_ACCT_NOTE " + "(REGIONID, TYPEACCT, NUMACCT, DATECRTD, ACTNOTE, OPERID, IDNOTE) "
							+ "values (?, ?, ?, ?, ?, ?, ?)",
					hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getREGIONID());
			myStmt.setString(2, acct.getTYPEACCT());
			myStmt.setString(3, acct.getNUMACCT());
			myStmt.setTimestamp(4, acct.getDATECRTD());
			myStmt.setString(5, acct.getACTNOTE());
			myStmt.setString(6, acct.getOPERID());
			myStmt.setString(7, acct.getIDNOTE());

			// execute sql insert
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// if CIF stays same but name changes, its good. but if name remains the same
	// and cif changes, it creates a new one
	public void update(HS_ACCT_NOTE acct) throws DAOException {
		try {

			delete(acct.getREGIONID(), acct.getTYPEACCT(), acct.getNUMACCT());

			create(acct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String REGIONID, String TYPEACCT, String NUMACCT) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_ACCT_NOTE where REGIONID=? AND TYPEACCT=? AND NUMACCT=? ",
					hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, REGIONID);
			myStmt.setString(2, TYPEACCT);
			myStmt.setString(3, NUMACCT);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}