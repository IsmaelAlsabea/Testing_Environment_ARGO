package services.hs_services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.front_end_entities.Acct_View;
import entities.front_end_entities.Business_View;
import entities.front_end_entities.Person_View;
import utils.DAOException;
import utils.DB_Names_Holder;
import utils.Date_Handler;

public class HS_ACCT_Services {

	private Connection con;
	private String hs_db_name;

	public HS_ACCT_Services(Connection con) {
		super();

		hs_db_name = DB_Names_Holder.getHs_db_name();
		this.con = con;
	}

	public void update_from_person(Person_View newVals) {

		String query = String.format("UPDATE %s.HS_ACCT " + " SET NUMTAXID=?, FLGFORGN1=?, STREET1A=? "
				+ " WHERE NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ", hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getNumtaxid()); // SSN in person view
			ps.setString(2, newVals.getForeignInd()); // Foreign Indicator in person view
			ps.setString(3, newVals.getStreet_1()); // Address in person view

			ps.setString(4, newVals.getNumBank()); // Primary key for ACCT
			ps.setString(5, newVals.getTypeAcct()); // Primary key for ACCT
			ps.setString(6, newVals.getNumAcct()); // Primary key for ACCT

			System.out.println("number of rows updated for update_from_person in acct: " + ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update_from_person_extended( Person_View newVals) {

		String query = String.format("UPDATE %s.HS_ACCT " + " SET NUMTAXID=?, FLGFORGN1=?, STREET1A=? "
				+ ", CITY1=?, STATE1=? , ZIP1= ? " + " WHERE NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ", hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getNumtaxid()); // SSN in person view
			ps.setString(2, newVals.getForeignInd()); // Foreign Indicator in person view
			ps.setString(3, newVals.getStreet_1()); // Address in person view

			ps.setString(4, newVals.getCity());
			ps.setString(5, newVals.getState());
			ps.setString(6, newVals.getZipCode());

			ps.setString(7, newVals.getNumBank()); // Primary key for ACCT
			ps.setString(8, newVals.getTypeAcct()); // Primary key for ACCT
			ps.setString(9, newVals.getNumAcct()); // Primary key for ACCT

			System.out
					.println("number of rows updated from update_from_person_Extended in acct:  " + ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update_from_business( Business_View newVals) {

		String query = String
				.format("UPDATE %s.HS_ACCT " + " SET ACTTITLE1=?, NUMTAXID=?, STREET1A=?, CITY1=?, STATE1=?, ZIP1=? "
						+ " WHERE NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ", hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getFullName()); // set ACTITLE1 as Company Name in business view
			ps.setString(2, newVals.getNumtaxid()); // set NUMTAXID as Tax ID in business view
			ps.setString(3, newVals.getStreet_1()); // set STREET1A as Address in business view
			ps.setString(4, newVals.getCity()); // set CITY1 as City in business view
			ps.setString(5, newVals.getState()); // set STATE1 as State in business view
			ps.setString(6, newVals.getZipCode()); // set ZIP1 as ZipCode in business view

			ps.setString(7, newVals.getNumBank()); // Primary key for ACCT
			ps.setString(8, newVals.getTypeAcct()); // Primary key for ACCT
			ps.setString(9, newVals.getNumAcct()); // Primary key for ACCT

			System.out.println("number of rows updated from update_from_business in acct: " + ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update_from_account( Acct_View newVals) {

		String query = String.format(
				"UPDATE %s.HS_ACCT " + " SET ACTTITLE1=?, NUMACCT=?, TYPEACCT=?, PRODCODE=?, STATUS2=?"
						+ ", AMTCURBL=?, NUMBRNCH=?, LASTDATE=?, DATEOPEN=?, DATECLSE=?"
						+ ", REASONCL=?, DATEBEG=?, DATEEND=? " + " WHERE NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ",
				hs_db_name);

		try (PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, newVals.getFullName()); // set ACTITLE1 as Customer Name in account view
			ps.setString(2, newVals.getNumAcct()); // set NUMACCT as Account Number in account view
			ps.setString(3, newVals.getTypeAcct()); // set TYPEACCT as Account Type in account view
			ps.setString(4, newVals.getProdCode()); // set PRODCODE as Product Code in account view
			ps.setString(5, newVals.getStatus()); // set STATUS2 as Account Status in account view
			ps.setString(6, newVals.getAmtCurBl()); // set AMTCURBL as Current Balance in account view
			ps.setString(7, newVals.getBranch()); // set NUMBRNCH as Branch in account view

			ps.setString(8, Date_Handler.date_to_string(newVals.getLastDate())); // set LASTDATE as Last Date in account
																					// view
			ps.setString(9, Date_Handler.date_to_string(newVals.getDateOpen())); // set DATEOPEN as Date Open in account
																					// view
			ps.setString(10, Date_Handler.date_to_string(newVals.getDateClosed())); // set DATECLSE as Date Closed in
																					// account view

			ps.setString(11, newVals.getReasonClosed()); // set REASONCL as Reason Closed in account view

			ps.setString(12, Date_Handler.date_to_string(newVals.getBeginDate())); // set DATEBEG as Begin Date in
																					// account view
			ps.setString(13, Date_Handler.date_to_string(newVals.getEndDate())); // set DATEEND as End Date in account
																					// view

			ps.setString(14, newVals.getNumBank()); // Primary key for ACCT
			ps.setString(15, newVals.getTypeAcct()); // Primary key for ACCT
			ps.setString(16, newVals.getNumAcct()); // Primary key for ACCT

			System.out.println("number of rows updated from update_from_account in acct: " + ps.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT) throws DAOException {
		PreparedStatement query = null;

		try {

			// create sql to delete HS_CUST acct

			String sql = String.format("delete from %s.HS_ACCT where NUMBANK=? AND TYPEACCT=? AND NUMACCT =? ",
					hs_db_name);

			// prepare statement
			query = con.prepareStatement(sql);

			// set params
			query.setString(1, NUMBANK);
			query.setString(2, TYPEACCT);
			query.setString(3, NUMACCT);

			// execute sql statement
			System.out.println("number of rows updated: " + query.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}