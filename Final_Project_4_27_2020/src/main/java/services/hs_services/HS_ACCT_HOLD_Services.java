package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_ACCT_HOLD;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_ACCT_HOLD_Services {

	private Connection con;
	private String hs_db_name;
	
	public HS_ACCT_HOLD_Services(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void create(HS_ACCT_HOLD acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert

			String sql = String.format("insert into %s.HS_ACCT_HOLD "
					+ "(NUMBANK, TYPEACCT, NUMACCT, IDHOLD, OFFID, HOLDTXT, AMTHOLD, DATEEXPR, DATEADDED, NUMBRNCH, OPERID, DESCCODE, DATEDEP, RSNHOLD) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getNUMBANK());
			myStmt.setString(2, acct.getTYPEACCT());
			myStmt.setString(3, acct.getNUMACCT());
			myStmt.setString(4, acct.getIDHOLD());
			myStmt.setString(5, acct.getOFFID());
			myStmt.setString(6, acct.getHOLDTXT());
			myStmt.setString(7, acct.getAMTHOLD());
			myStmt.setTimestamp(8, acct.getDATEEXPR());
			myStmt.setTimestamp(9, acct.getDATEADDED());
			myStmt.setString(10, acct.getNUMBRNCH());
			myStmt.setString(11, acct.getOPERID());
			myStmt.setString(12, acct.getDESCCODE());
			myStmt.setString(13, acct.getDATEDEP());
			myStmt.setString(14, acct.getRSNHOLD());

			// execute sql insert
			myStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(HS_ACCT_HOLD acct) throws DAOException {

		try {

			delete(acct.getNUMBANK(), acct.getTYPEACCT(), acct.getNUMACCT(), acct.getIDHOLD());

			create(acct);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, String IDHOLD)
			throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format(
					"delete from %s.HS_ACCT_HOLD where NUMBANK=? AND TYPEACCT=? AND NUMACCT=? AND IDHOLD=? ",
					hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, NUMBANK);
			myStmt.setString(2, TYPEACCT);
			myStmt.setString(3, NUMACCT);
			myStmt.setString(4, IDHOLD);

			// execute sql statement
			myStmt.executeUpdate();

			// commit change

			// con.commit();

			// troubleshooting
			System.out.println("Record deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}