package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.front_end_entities.Acct_View;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_CUAC_Services {

	private Connection con;
	private String hs_db_name;

	public HS_CUAC_Services(Connection con) {
		super();
		hs_db_name=DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void update_from_account( Acct_View newVals) 
	{
	
		String query = String.format("UPDATE %s.HS_CUAC "
				+ " SET NUMACCT=?, TYPEACCT=? "
				+ " WHERE CUSTBANK=? AND TYPECUST=? AND CIF =? AND NUMBANK=? AND TYPEACCT=? AND NUMACCT=? ", hs_db_name);
		
		try (PreparedStatement ps= con.prepareStatement(query)){
			
			ps.setString(1, newVals.getNumAcct());   // set NUMACCT as Account Number in account view
			ps.setString(2, newVals.getTypeAcct());  // set TYPEACCT as Account Type in account view
			
			
			ps.setString(3, newVals.getNumBank());  // Primary key for CUST
			ps.setString(4, newVals.getCustType()); // Primary key for CUST
			ps.setString(5, newVals.getCif());		// Primary key for CUST
			ps.setString(6, newVals.getNumBank());  // Primary key for CUST
			ps.setString(7, newVals.getTypeAcct()); // Primary key for CUST
			ps.setString(8, newVals.getNumAcct());  // Primary key for CUST
			

			System.out.println("number of rows updated for update cuac from account view: " + ps.executeUpdate());
			
			//System.out.println(newVals.getNumtaxid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public void delete(String CUSTBANK, String TYPECUST, String CIF, String NUMBANK, String TYPEACCT, String NUMACCT)
			throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_CUAC where CUSTBANK=? AND TYPECUST=? AND CIF=? AND "
					+ "NUMBANK=? AND TYPEACCT=? AND NUMACCT=? ", hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, CUSTBANK);
			myStmt.setString(2, TYPECUST);
			myStmt.setString(3, CIF);
			myStmt.setString(4, NUMBANK);
			myStmt.setString(5, TYPEACCT);
			myStmt.setString(6, NUMACCT);

			// execute sql statement
			System.out.println("number of rows updated in cuac delete: " + myStmt.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
