package entities.front_end_entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Business_View  extends Viewable{

	private String fullName;
	private String yearEstablished; // it is in consumer_info
	//private String taxId; // numtaxid
	private String telephone;
	private String email;
	private String street_1;
	private String city;
	private String state;
	private String zipCode;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(String yearEstablished) {
		this.yearEstablished = yearEstablished;
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


	public static Business_View extractFromResultSet(ResultSet rs) {
		Business_View record = new Business_View();

		try {
			record.extractKeysFromRs(rs);
			
			record.fullName = rs.getString("NAMFULL");
			record.yearEstablished = rs.getString("yearEstablished");
			record.telephone = rs.getString("PHONE1");
			record.email = rs.getString("EmailAddress");
			record.street_1 = rs.getString("street1A");
			record.city = rs.getString("CITY1");
			record.state = rs.getString("STATE1");
			
			record.zipCode = rs.getString("Zip1");

			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ISSSUE IS HERE");
		} 

		return record;
	}


}
