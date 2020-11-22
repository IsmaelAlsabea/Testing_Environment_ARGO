package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.Business_View;
import entities.front_end_entities.Person_View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DAOException;
import utils.DB_Names_Holder;

public class HS_CUST_Services {

	private  Connection con;
	private  String hs_db_name;

	public HS_CUST_Services(Connection con) {
		super();
		hs_db_name = DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void update_from_person( Person_View newVals) {

		String query = String.format("UPDATE %s.HS_CUST SET NUMTAXID = ?, PHONE1 = ?, STREET1A= ? " + ", FLGFORGN1= ? "
				+ " WHERE NUMBANK=? AND TYPECUST=? AND CIF =? ", hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getNumtaxid()); // SSN in person view
			ps.setString(2, newVals.getTelephone()); // Telephone in person view
			ps.setString(3, newVals.getStreet_1()); // Address in person view
			ps.setString(4, newVals.getForeignInd());

			ps.setString(5, newVals.getNumBank()); // Primary key for CUST
			ps.setString(6, newVals.getCustType()); // Primary key for CUST
			ps.setString(7, newVals.getCif()); // Primary key for CUST

			System.out.println("number of rows updated for update_from_person in cust: " + ps.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update_from_person_extended( Person_View newVals) {

		String query = String.format("UPDATE %s.HS_CUST SET NUMTAXID = ?, PHONE1 = ?, STREET1A= ? "
				+ ", FLGFORGN1= ?, CITY1=?, STATE1=? , ZIP1= ? " + " WHERE NUMBANK=? AND TYPECUST=? AND CIF =? ",
				hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getNumtaxid()); // SSN in person view
			ps.setString(2, newVals.getTelephone()); // Telephone in person view
			ps.setString(3, newVals.getStreet_1()); // Address in person view
			ps.setString(4, newVals.getForeignInd());

			// String city, state, zipCode, specUse, specUseNotes;
			ps.setString(5, newVals.getCity());
			ps.setString(6, newVals.getState());
			ps.setString(7, newVals.getZipCode());

			ps.setString(8, newVals.getNumBank()); // Primary key for CUST
			ps.setString(9, newVals.getCustType()); // Primary key for CUST
			ps.setString(10, newVals.getCif()); // Primary key for CUST

			System.out.println("number of rows updated for update_from_person_extended in cust: " + ps.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update_from_business(Business_View newVals) {

		String query = String
				.format("UPDATE %s.HS_CUST SET NAMFULL=?, NUMTAXID=?, PHONE1=?, STREET1A=?, CITY1=?, STATE1=?, ZIP1=? "
						+ " WHERE NUMBANK=? AND TYPECUST=? AND CIF =? ;", hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getFullName()); // set NAMFULL as Company Name in business view

			ps.setString(2, newVals.getNumtaxid()); // set NUMTAXID as Tax ID in business view

			ps.setString(3, newVals.getTelephone()); // set PHONE1 as Telephone in business view
			ps.setString(4, newVals.getStreet_1()); // set STREET1 as Address in business view
			ps.setString(5, newVals.getCity()); // set CITY1 as City in business view
			ps.setString(6, newVals.getState()); // set STATE1 as State in business view
			ps.setString(7, newVals.getZipCode()); // set ZIP1 as ZipCode in business

			ps.setString(8, newVals.getNumBank()); // Primary key for CUST
			ps.setString(9, newVals.getCustType()); // Primary key for CUST
			ps.setString(10, newVals.getCif()); // Primary key for CUST

			System.out.println("number of rows updated for update_from_business in cust: " + ps.executeUpdate());

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void update_from_account( Acct_View newVals) {

		String query = String.format(
				"UPDATE %s.HS_CUST " + " SET NAMFULL=?, NUMBRNCH=? " + " WHERE NUMBANK=? AND TYPECUST=? AND CIF =? ",
				hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getFullName()); // set NAMFULL as Customer Name in account view
			ps.setString(2, newVals.getBranch()); // set NUMBRNCH as Branch in account view

			ps.setString(3, newVals.getNumBank()); // Primary key for CUST
			ps.setString(4, newVals.getCustType()); // Primary key for CUST
			ps.setString(5, newVals.getCif()); // Primary key for CUST

			System.out.println("number of rows updated for update_from_account in cust: " + ps.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String NUMBANK, String TYPECUST, String CIF) throws DAOException {
		PreparedStatement myStmt = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_CUST where NUMBANK=? AND TYPECUST=? AND CIF =? ", hs_db_name);

			// prepare statement
			myStmt = con.prepareStatement(sql);

			// set params
			myStmt.setString(1, NUMBANK);
			myStmt.setString(2, TYPECUST);
			myStmt.setString(3, CIF);

			// execute sql statement
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * Return a list of all unique states.
	 */
	
		

}
