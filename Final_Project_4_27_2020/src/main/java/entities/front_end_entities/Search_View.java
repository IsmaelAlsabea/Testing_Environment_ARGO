package entities.front_end_entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Search_View extends Viewable {

	private String  name, city, state, creditBureau, pep, foreignIndicator, specialUse;
	private String age, zipCode;
	private String creditHigh, creditLow, creditScore;
	private String onlineBanking;
	private String mortgageAccts, bankruptcyRecords;

//	private String custType;
//
//	public String getCustType() {
//		return custType;
//	}
//
//	public void setCustType(String custType) {
//		this.custType = custType;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getCreditBureau() {
		return creditBureau;
	}

	public void setCreditBureau(String creditBureau) {
		this.creditBureau = creditBureau;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	public String getForeignIndicator() {
		return foreignIndicator;
	}

	public void setForeignIndicator(String foreignIndicator) {
		this.foreignIndicator = foreignIndicator;
	}

	public String getSpecialUse() {
		return specialUse;
	}

	public void setSpecialUse(String specialUse) {
		this.specialUse = specialUse;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCreditHigh() {
		return creditHigh;
	}

	public void setCreditHigh(String creditHigh) {
		this.creditHigh = creditHigh;
	}

	public String getCreditLow() {
		return creditLow;
	}

	public void setCreditLow(String creditLow) {
		this.creditLow = creditLow;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public String getOnlineBanking() {
		return onlineBanking;
	}

	public void setOnlineBanking(String onlineBanking) {
		this.onlineBanking = onlineBanking;
	}

	public String getMortgageAccts() {
		return mortgageAccts;
	}

	public void setMortgageAccts(String mortgageAccts) {
		this.mortgageAccts = mortgageAccts;
	}

	public String getBankruptcyRecords() {
		return bankruptcyRecords;
	}

	public void setBankruptcyRecords(String bankruptcyRecords) {
		this.bankruptcyRecords = bankruptcyRecords;
	}

	public static Search_View extractFromResultSet(ResultSet rs) {

		Search_View record = new Search_View();
		try {

			//put it in a viewble extract from rs.
			record.extractKeysFromRs(rs);
			
			//record.custType = this.custType; //redundant but it is part of the 
			
			
			record.age = rs.getString("Age");
			record.state = rs.getString("State1");
			record.creditBureau = rs.getString("Bureau");
			record.pep = rs.getString("PEP");
			record.zipCode = rs.getString("ZIP1");
			record.onlineBanking = rs.getString("OnlineBanking");
			record.foreignIndicator = rs.getString("ForeignInd");
			record.specialUse = rs.getString("SpecUse");
			record.name = rs.getString("NamFULL");
			record.creditScore = rs.getString("CreditScore");
			record.city = rs.getString("City1");
			record.mortgageAccts = rs.getString("MortgageAccounts");
			record.bankruptcyRecords = rs.getString("BankruptcyRecords");
			
			
			
//			record.setCif( rs.getString("CIF")) ;
//			record.setNumtaxid(rs.getString("NUMTAXID"));
//			record.setCustType(rs.getString("TYPECUST"));

			// entities_to_return.add(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return record;
	}

}
