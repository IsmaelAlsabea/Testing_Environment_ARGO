package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.hs_entities.HS_ACCT_STOP;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_ACCT_STOP_Services  {

	private Connection con;
	private String hs_db_name;
	
	public HS_ACCT_STOP_Services(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void create(HS_ACCT_STOP acct) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql for insert

			String sql = String.format("insert into %s.HS_ACCT_STOP "
					+ "(NUMBANK, TYPEACCT, NUMACCT, IDSTOP, NUMBEG, NUMEND, AMTCHECK, DATEEXPR, DATECRTD, OPERID, NAMPAYTO, STOPREAS, REGIONID, DATECHK, OFFID) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", hs_db_name);

			myStmt = con.prepareStatement(sql);

			// set the param values for the account
			myStmt.setString(1, acct.getNUMBANK());
			myStmt.setString(2, acct.getTYPEACCT());
			myStmt.setString(3, acct.getNUMACCT());
			myStmt.setString(4, acct.getIDSTOP());
			myStmt.setString(5, acct.getNUMBEG());
			myStmt.setString(6, acct.getNUMEND());
			myStmt.setString(7, acct.getAMTCHECK());
			myStmt.setTimestamp(8, acct.getDATEEXPR());
			myStmt.setTimestamp(9, acct.getDATECRTD());
			myStmt.setString(10, acct.getOPERID());
			myStmt.setString(11, acct.getNAMPAYTO());
			myStmt.setString(12, acct.getSTOPREAS());
			myStmt.setString(13, acct.getREGIONID());
			myStmt.setTimestamp(14, acct.getDATECHK());
			myStmt.setString(15, acct.getOFFID());

			// execute sql insert
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(HS_ACCT_STOP acct) throws DAOException {

		try {
			delete(acct.getNUMBANK(), acct.getTYPEACCT(), acct.getNUMACCT(), acct.getIDSTOP());

			create(acct);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, String IDSTOP) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format(
					"delete from %s.HS_ACCT_STOP where NUMBANK=? AND TYPEACCT=? " + "AND NUMACCT=? AND IDSTOP=? ",
					hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, NUMBANK);
			myStmt.setString(2, TYPEACCT);
			myStmt.setString(3, NUMACCT);
			myStmt.setString(4, IDSTOP);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}