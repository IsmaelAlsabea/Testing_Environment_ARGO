package entities.front_end_entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person_View  extends Viewable{

	String firstName, lastName, creditBureau;
	Date dob;
	String creditScore, foreignInd, pep, onlineBanking, telephone;
	String email, street_1;
	String city, state, zipCode, specUse, specUseNotes;





	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditBureau() {
		return creditBureau;
	}

	public void setCreditBureau(String creditBureau) {
		this.creditBureau = creditBureau;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public String getForeignInd() {
		return foreignInd;
	}

	public void setForeignInd(String foreignInd) {
		this.foreignInd = foreignInd;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getOnlineBanking() {
		return onlineBanking;
	}

	public void setOnlineBanking(String onlineBanking) {
		this.onlineBanking = onlineBanking;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet_1() {
		return street_1;
	}

	public void setStreet_1(String street_1) {
		this.street_1 = street_1;
	}

	
	//*****************************VIEW MORE
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSpecUse() {
		return specUse;
	}

	public void setSpecUse(String specUse) {
		this.specUse = specUse;
	}

	public String getSpecUseNotes() {
		return specUseNotes;
	}

	public void setSpecUseNotes(String specUseNotes) {
		this.specUseNotes = specUseNotes;
	}
	
	public static Person_View extractFromResultSet(ResultSet rs) {

		Person_View record = new Person_View();

		try {
			
			record.extractKeysFromRs(rs);
			
			record.firstName = rs.getString("firstName");
			record.lastName = rs.getString("lastName");
			record.creditBureau = rs.getString("Bureau");
			record.dob = rs.getDate("DOB");
			record.creditScore = rs.getString("CreditScore");
			record.foreignInd = rs.getString("ForeignInd");
			record.pep = rs.getString("PEP");
			record.onlineBanking = rs.getString("OnlineBanking");
			record.telephone = rs.getString("PHONE1");
			record.email = rs.getString("EmailAddress");
			record.street_1 = rs.getString("street1A");
			
	//	String city, state, zipCode, specUse, SpecUseNotes;		
			record.city = rs.getString("City1");
			record.state = rs.getString("State1");
			record.zipCode = rs.getString("ZIP1");
			record.specUse = rs.getString("SpecUse");
			record.specUseNotes= rs.getString("SpecUseNotes");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return record;
	}

	
}
