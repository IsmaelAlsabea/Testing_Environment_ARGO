package entities.consumer_info_entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ConsumerInfo {
	

	private int 		ID;
	private String 		Bureau;
	private String 		CustomerType;
	private String 		CreditScore;
	private String 		Name;
	private String 		FirstName;
	private String 		MiddleName;
	private String 		LastName;
	private String 		Suffix;
	private String 		ForeignInd;
	private String 		Citizenship;
	private String 		TaxIdNumber;
	private Date 		DOB;
	private BigDecimal 		YearEstablished;
	private String 		TaxIdType;
	private String 		AddressLine1;
	private String 		AddressLine2;
	private String 		City;
	private String 		State;
	private String 		ZIPCode;
	private String 		PhoneNumber;
	private String 		EmailAddress;
	private String 		SpecUse;
	private String 		SpecUseNotes;
	private String 		BankRelationship;
	private String 		BankExecutive;
	private String 		CIF;
	private String 		PEP;
	private String 		ConsumerID;
	private String 		QDFormID;
	private String 		PEPOfficerName;
	private String 		PEPPosition;
	private String 		PEPRelationship;
	private String 		PEPRelatedEmployee;
	private String 		PEPCountryOfCitizenship;
	private String 		PEPDualCitizenship;
	private String 		PEPEmployment;
	private String 		PEPIncomeSource;
	private String 		PEPIncomeOtherSource;
	private String 		NAICS;
	private String 		SICCODE;
	private String 		OnlineBanking;
	private String 		PerfTestOMNI;
	private Timestamp 	updt_tmstmp;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBureau() {
		return Bureau;
	}
	public void setBureau(String bureau) {
		Bureau = bureau;
	}
	public String getCustomerType() {
		return CustomerType;
	}
	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}
	public String getCreditScore() {
		return CreditScore;
	}
	public void setCreditScore(String creditScore) {
		CreditScore = creditScore;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSuffix() {
		return Suffix;
	}
	public void setSuffix(String suffix) {
		Suffix = suffix;
	}
	public String getForeignInd() {
		return ForeignInd;
	}
	public void setForeignInd(String foreignInd) {
		ForeignInd = foreignInd;
	}
	public String getCitizenship() {
		return Citizenship;
	}
	public void setCitizenship(String citizenship) {
		Citizenship = citizenship;
	}
	public String getTaxIdNumber() {
		return TaxIdNumber;
	}
	public void setTaxIdNumber(String taxIdNumber) {
		TaxIdNumber = taxIdNumber;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public BigDecimal getYearEstablished() {
		return YearEstablished;
	}
	public void setYearEstablished(BigDecimal yearEstablished) {
		YearEstablished = yearEstablished;
	}
	public String getTaxIdType() {
		return TaxIdType;
	}
	public void setTaxIdType(String taxIdType) {
		TaxIdType = taxIdType;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZIPCode() {
		return ZIPCode;
	}
	public void setZIPCode(String zIPCode) {
		ZIPCode = zIPCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getSpecUse() {
		return SpecUse;
	}
	public void setSpecUse(String specUse) {
		SpecUse = specUse;
	}
	public String getSpecUseNotes() {
		return SpecUseNotes;
	}
	public void setSpecUseNotes(String specUseNotes) {
		SpecUseNotes = specUseNotes;
	}
	public String getBankRelationship() {
		return BankRelationship;
	}
	public void setBankRelationship(String bankRelationship) {
		BankRelationship = bankRelationship;
	}
	public String getBankExecutive() {
		return BankExecutive;
	}
	public void setBankExecutive(String bankExecutive) {
		BankExecutive = bankExecutive;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getPEP() {
		return PEP;
	}
	public void setPEP(String pEP) {
		PEP = pEP;
	}
	public String getConsumerID() {
		return ConsumerID;
	}
	public void setConsumerID(String consumerID) {
		ConsumerID = consumerID;
	}
	public String getQDFormID() {
		return QDFormID;
	}
	public void setQDFormID(String qDFormID) {
		QDFormID = qDFormID;
	}
	public String getPEPOfficerName() {
		return PEPOfficerName;
	}
	public void setPEPOfficerName(String pEPOfficerName) {
		PEPOfficerName = pEPOfficerName;
	}
	public String getPEPPosition() {
		return PEPPosition;
	}
	public void setPEPPosition(String pEPPosition) {
		PEPPosition = pEPPosition;
	}
	public String getPEPRelationship() {
		return PEPRelationship;
	}
	public void setPEPRelationship(String pEPRelationship) {
		PEPRelationship = pEPRelationship;
	}
	public String getPEPRelatedEmployee() {
		return PEPRelatedEmployee;
	}
	public void setPEPRelatedEmployee(String pEPRelatedEmployee) {
		PEPRelatedEmployee = pEPRelatedEmployee;
	}
	public String getPEPCountryOfCitizenship() {
		return PEPCountryOfCitizenship;
	}
	public void setPEPCountryOfCitizenship(String pEPCountryOfCitizenship) {
		PEPCountryOfCitizenship = pEPCountryOfCitizenship;
	}
	public String getPEPDualCitizenship() {
		return PEPDualCitizenship;
	}
	public void setPEPDualCitizenship(String pEPDualCitizenship) {
		PEPDualCitizenship = pEPDualCitizenship;
	}
	public String getPEPEmployment() {
		return PEPEmployment;
	}
	public void setPEPEmployment(String pEPEmployment) {
		PEPEmployment = pEPEmployment;
	}
	public String getPEPIncomeSource() {
		return PEPIncomeSource;
	}
	public void setPEPIncomeSource(String pEPIncomeSource) {
		PEPIncomeSource = pEPIncomeSource;
	}
	public String getPEPIncomeOtherSource() {
		return PEPIncomeOtherSource;
	}
	public void setPEPIncomeOtherSource(String pEPIncomeOtherSource) {
		PEPIncomeOtherSource = pEPIncomeOtherSource;
	}
	public String getNAICS() {
		return NAICS;
	}
	public void setNAICS(String nAICS) {
		NAICS = nAICS;
	}
	public String getSICCODE() {
		return SICCODE;
	}
	public void setSICCODE(String sICCODE) {
		SICCODE = sICCODE;
	}
	public String getOnlineBanking() {
		return OnlineBanking;
	}
	public void setOnlineBanking(String onlineBanking) {
		OnlineBanking = onlineBanking;
	}
	public String getPerfTestOMNI() {
		return PerfTestOMNI;
	}
	public void setPerfTestOMNI(String perfTestOMNI) {
		PerfTestOMNI = perfTestOMNI;
	}
	public Timestamp getUpdt_tmstmp() {
		return updt_tmstmp;
	}
	public void setUpdt_tmstmp(Timestamp updt_tmstmp) {
		this.updt_tmstmp = updt_tmstmp;
	}
	
	
	

}
