package entities_1;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entities_1.id_classes.HS_ACCT_CUST_ID;

@Entity @Table
@IdClass(HS_ACCT_CUST_ID.class)
public class HS_ACCT_CUST {

	@Id private String  NUMBANK;
	@Id private String  TYPECUST;
	@Id private String  	CIF;
	
	private String  	NAMFULL;
	private String  	NUMTAXID;
	private String  	NUMBRNCH;
	private Timestamp  	LASTDATE;
	private Timestamp  	DATEOPEN;
	private String 		PHONETYP1;
	private String 		PHONETYP2;
	private String 		PHONETYP3;
	private String 		PHONETYP4;
	private String 		PHONE1;
	private String 		PHONE2;
	private String 		PHONE3;
	private String 		PHONE4;
	private String 		PHONEEXT1;
	private String 		PHONEEXT2;
	private String 		PHONEEXT3;
	private String 		PHONEEXT4;
	private String 		OPERID;
	private String 		ADDRTYP1;
	private String 		ADDRTYP2;
	private String 		ADDRTYP3;
	private String 		ADDRTYP4;
	private String 		FLGFORGN1;
	private String 		FLGFORGN2;
	private String 		FLGFORGN3;
	private String 		FLGFORGN4;
	private String 		STREET1A;
	private String 		STREET1B;
	private String 		STREET1C;
	private String 		STREET1D;
	private String 		STREET2A;
	private String 		STREET2B;
	private String 		STREET2C;
	private String 		STREET2D;
	private String 		CITY1;
	private String 		CITY2;
	private String 		CITY3;
	private String 		CITY4;
	private String 		STATE1;
	private String 		STATE2;
	private String 		STATE3;
	private String 		STATE4;
	private String 		ZIP1;
	private String 		ZIP2;
	private String 		ZIP3;
	private String 		ZIP4;
	private Timestamp 	DATEBEG1;
	private Timestamp 	DATEBEG2;
	private Timestamp 	DATEBEG3;
	private Timestamp 	DATEBEG4;
	private Timestamp 	DATEEND1;
	private Timestamp 	DATEEND2;
	private Timestamp 	DATEEND3;
	private Timestamp 	DATEEND4;
	private String 		XML_BLOB;
	
	
	public HS_ACCT_CUST() {}
	
	
	public HS_ACCT_CUST(String nUMBANK, String tYPECUST, String cIF, String nAMFULL, String nUMTAXID, String nUMBRNCH,
			Timestamp lASTDATE, Timestamp dATEOPEN, String pHONETYP1, String pHONETYP2, String pHONETYP3,
			String pHONETYP4, String pHONE1, String pHONE2, String pHONE3, String pHONE4, String pHONEEXT1,
			String pHONEEXT2, String pHONEEXT3, String pHONEEXT4, String oPERID, String aDDRTYP1, String aDDRTYP2,
			String aDDRTYP3, String aDDRTYP4, String fLGFORGN1, String fLGFORGN2, String fLGFORGN3, String fLGFORGN4,
			String sTREET1A, String sTREET1B, String sTREET1C, String sTREET1D, String sTREET2A, String sTREET2B,
			String sTREET2C, String sTREET2D, String cITY1, String cITY2, String cITY3, String cITY4, String sTATE1,
			String sTATE2, String sTATE3, String sTATE4, String zIP1, String zIP2, String zIP3, String zIP4,
			Timestamp dATEBEG1, Timestamp dATEBEG2, Timestamp dATEBEG3, Timestamp dATEBEG4, Timestamp dATEEND1,
			Timestamp dATEEND2, Timestamp dATEEND3, Timestamp dATEEND4, String xML_BLOB) {
		super();
		NUMBANK = nUMBANK;
		TYPECUST = tYPECUST;
		CIF = cIF;
		NAMFULL = nAMFULL;
		NUMTAXID = nUMTAXID;
		NUMBRNCH = nUMBRNCH;
		LASTDATE = lASTDATE;
		DATEOPEN = dATEOPEN;
		PHONETYP1 = pHONETYP1;
		PHONETYP2 = pHONETYP2;
		PHONETYP3 = pHONETYP3;
		PHONETYP4 = pHONETYP4;
		PHONE1 = pHONE1;
		PHONE2 = pHONE2;
		PHONE3 = pHONE3;
		PHONE4 = pHONE4;
		PHONEEXT1 = pHONEEXT1;
		PHONEEXT2 = pHONEEXT2;
		PHONEEXT3 = pHONEEXT3;
		PHONEEXT4 = pHONEEXT4;
		OPERID = oPERID;
		ADDRTYP1 = aDDRTYP1;
		ADDRTYP2 = aDDRTYP2;
		ADDRTYP3 = aDDRTYP3;
		ADDRTYP4 = aDDRTYP4;
		FLGFORGN1 = fLGFORGN1;
		FLGFORGN2 = fLGFORGN2;
		FLGFORGN3 = fLGFORGN3;
		FLGFORGN4 = fLGFORGN4;
		STREET1A = sTREET1A;
		STREET1B = sTREET1B;
		STREET1C = sTREET1C;
		STREET1D = sTREET1D;
		STREET2A = sTREET2A;
		STREET2B = sTREET2B;
		STREET2C = sTREET2C;
		STREET2D = sTREET2D;
		CITY1 = cITY1;
		CITY2 = cITY2;
		CITY3 = cITY3;
		CITY4 = cITY4;
		STATE1 = sTATE1;
		STATE2 = sTATE2;
		STATE3 = sTATE3;
		STATE4 = sTATE4;
		ZIP1 = zIP1;
		ZIP2 = zIP2;
		ZIP3 = zIP3;
		ZIP4 = zIP4;
		DATEBEG1 = dATEBEG1;
		DATEBEG2 = dATEBEG2;
		DATEBEG3 = dATEBEG3;
		DATEBEG4 = dATEBEG4;
		DATEEND1 = dATEEND1;
		DATEEND2 = dATEEND2;
		DATEEND3 = dATEEND3;
		DATEEND4 = dATEEND4;
		XML_BLOB = xML_BLOB;
	}


	public String getNUMBANK() {
		return NUMBANK;
	}
	public void setNUMBANK(String nUMBANK) {
		NUMBANK = nUMBANK;
	}
	public String getTYPECUST() {
		return TYPECUST;
	}
	public void setTYPECUST(String tYPECUST) {
		TYPECUST = tYPECUST;
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getNAMFULL() {
		return NAMFULL;
	}
	public void setNAMFULL(String nAMFULL) {
		NAMFULL = nAMFULL;
	}
	public String getNUMTAXID() {
		return NUMTAXID;
	}
	public void setNUMTAXID(String nUMTAXID) {
		NUMTAXID = nUMTAXID;
	}
	public String getNUMBRNCH() {
		return NUMBRNCH;
	}
	public void setNUMBRNCH(String nUMBRNCH) {
		NUMBRNCH = nUMBRNCH;
	}
	public Timestamp getLASTDATE() {
		return LASTDATE;
	}
	public void setLASTDATE(Timestamp lASTDATE) {
		LASTDATE = lASTDATE;
	}
	public Timestamp getDATEOPEN() {
		return DATEOPEN;
	}
	public void setDATEOPEN(Timestamp dATEOPEN) {
		DATEOPEN = dATEOPEN;
	}
	public String getPHONETYP1() {
		return PHONETYP1;
	}
	public void setPHONETYP1(String pHONETYP1) {
		PHONETYP1 = pHONETYP1;
	}
	public String getPHONETYP2() {
		return PHONETYP2;
	}
	public void setPHONETYP2(String pHONETYP2) {
		PHONETYP2 = pHONETYP2;
	}
	public String getPHONETYP3() {
		return PHONETYP3;
	}
	public void setPHONETYP3(String pHONETYP3) {
		PHONETYP3 = pHONETYP3;
	}
	public String getPHONETYP4() {
		return PHONETYP4;
	}
	public void setPHONETYP4(String pHONETYP4) {
		PHONETYP4 = pHONETYP4;
	}
	public String getPHONE1() {
		return PHONE1;
	}
	public void setPHONE1(String pHONE1) {
		PHONE1 = pHONE1;
	}
	public String getPHONE2() {
		return PHONE2;
	}
	public void setPHONE2(String pHONE2) {
		PHONE2 = pHONE2;
	}
	public String getPHONE3() {
		return PHONE3;
	}
	public void setPHONE3(String pHONE3) {
		PHONE3 = pHONE3;
	}
	public String getPHONE4() {
		return PHONE4;
	}
	public void setPHONE4(String pHONE4) {
		PHONE4 = pHONE4;
	}
	public String getPHONEEXT1() {
		return PHONEEXT1;
	}
	public void setPHONEEXT1(String pHONEEXT1) {
		PHONEEXT1 = pHONEEXT1;
	}
	public String getPHONEEXT2() {
		return PHONEEXT2;
	}
	public void setPHONEEXT2(String pHONEEXT2) {
		PHONEEXT2 = pHONEEXT2;
	}
	public String getPHONEEXT3() {
		return PHONEEXT3;
	}
	public void setPHONEEXT3(String pHONEEXT3) {
		PHONEEXT3 = pHONEEXT3;
	}
	public String getPHONEEXT4() {
		return PHONEEXT4;
	}
	public void setPHONEEXT4(String pHONEEXT4) {
		PHONEEXT4 = pHONEEXT4;
	}
	public String getOPERID() {
		return OPERID;
	}
	public void setOPERID(String oPERID) {
		OPERID = oPERID;
	}
	public String getADDRTYP1() {
		return ADDRTYP1;
	}
	public void setADDRTYP1(String aDDRTYP1) {
		ADDRTYP1 = aDDRTYP1;
	}
	public String getADDRTYP2() {
		return ADDRTYP2;
	}
	public void setADDRTYP2(String aDDRTYP2) {
		ADDRTYP2 = aDDRTYP2;
	}
	public String getADDRTYP3() {
		return ADDRTYP3;
	}
	public void setADDRTYP3(String aDDRTYP3) {
		ADDRTYP3 = aDDRTYP3;
	}
	public String getADDRTYP4() {
		return ADDRTYP4;
	}
	public void setADDRTYP4(String aDDRTYP4) {
		ADDRTYP4 = aDDRTYP4;
	}
	public String getFLGFORGN1() {
		return FLGFORGN1;
	}
	public void setFLGFORGN1(String fLGFORGN1) {
		FLGFORGN1 = fLGFORGN1;
	}
	public String getFLGFORGN2() {
		return FLGFORGN2;
	}
	public void setFLGFORGN2(String fLGFORGN2) {
		FLGFORGN2 = fLGFORGN2;
	}
	public String getFLGFORGN3() {
		return FLGFORGN3;
	}
	public void setFLGFORGN3(String fLGFORGN3) {
		FLGFORGN3 = fLGFORGN3;
	}
	public String getFLGFORGN4() {
		return FLGFORGN4;
	}
	public void setFLGFORGN4(String fLGFORGN4) {
		FLGFORGN4 = fLGFORGN4;
	}
	public String getSTREET1A() {
		return STREET1A;
	}
	public void setSTREET1A(String sTREET1A) {
		STREET1A = sTREET1A;
	}
	public String getSTREET1B() {
		return STREET1B;
	}
	public void setSTREET1B(String sTREET1B) {
		STREET1B = sTREET1B;
	}
	public String getSTREET1C() {
		return STREET1C;
	}
	public void setSTREET1C(String sTREET1C) {
		STREET1C = sTREET1C;
	}
	public String getSTREET1D() {
		return STREET1D;
	}
	public void setSTREET1D(String sTREET1D) {
		STREET1D = sTREET1D;
	}
	public String getSTREET2A() {
		return STREET2A;
	}
	public void setSTREET2A(String sTREET2A) {
		STREET2A = sTREET2A;
	}
	public String getSTREET2B() {
		return STREET2B;
	}
	public void setSTREET2B(String sTREET2B) {
		STREET2B = sTREET2B;
	}
	public String getSTREET2C() {
		return STREET2C;
	}
	public void setSTREET2C(String sTREET2C) {
		STREET2C = sTREET2C;
	}
	public String getSTREET2D() {
		return STREET2D;
	}
	public void setSTREET2D(String sTREET2D) {
		STREET2D = sTREET2D;
	}
	public String getCITY1() {
		return CITY1;
	}
	public void setCITY1(String cITY1) {
		CITY1 = cITY1;
	}
	public String getCITY2() {
		return CITY2;
	}
	public void setCITY2(String cITY2) {
		CITY2 = cITY2;
	}
	public String getCITY3() {
		return CITY3;
	}
	public void setCITY3(String cITY3) {
		CITY3 = cITY3;
	}
	public String getCITY4() {
		return CITY4;
	}
	public void setCITY4(String cITY4) {
		CITY4 = cITY4;
	}
	public String getSTATE1() {
		return STATE1;
	}
	public void setSTATE1(String sTATE1) {
		STATE1 = sTATE1;
	}
	public String getSTATE2() {
		return STATE2;
	}
	public void setSTATE2(String sTATE2) {
		STATE2 = sTATE2;
	}
	public String getSTATE3() {
		return STATE3;
	}
	public void setSTATE3(String sTATE3) {
		STATE3 = sTATE3;
	}
	public String getSTATE4() {
		return STATE4;
	}
	public void setSTATE4(String sTATE4) {
		STATE4 = sTATE4;
	}
	public String getZIP1() {
		return ZIP1;
	}
	public void setZIP1(String zIP1) {
		ZIP1 = zIP1;
	}
	public String getZIP2() {
		return ZIP2;
	}
	public void setZIP2(String zIP2) {
		ZIP2 = zIP2;
	}
	public String getZIP3() {
		return ZIP3;
	}
	public void setZIP3(String zIP3) {
		ZIP3 = zIP3;
	}
	public String getZIP4() {
		return ZIP4;
	}
	public void setZIP4(String zIP4) {
		ZIP4 = zIP4;
	}
	public Timestamp getDATEBEG1() {
		return DATEBEG1;
	}
	public void setDATEBEG1(Timestamp dATEBEG1) {
		DATEBEG1 = dATEBEG1;
	}
	public Timestamp getDATEBEG2() {
		return DATEBEG2;
	}
	public void setDATEBEG2(Timestamp dATEBEG2) {
		DATEBEG2 = dATEBEG2;
	}
	public Timestamp getDATEBEG3() {
		return DATEBEG3;
	}
	public void setDATEBEG3(Timestamp dATEBEG3) {
		DATEBEG3 = dATEBEG3;
	}
	public Timestamp getDATEBEG4() {
		return DATEBEG4;
	}
	public void setDATEBEG4(Timestamp dATEBEG4) {
		DATEBEG4 = dATEBEG4;
	}
	public Timestamp getDATEEND1() {
		return DATEEND1;
	}
	public void setDATEEND1(Timestamp dATEEND1) {
		DATEEND1 = dATEEND1;
	}
	public Timestamp getDATEEND2() {
		return DATEEND2;
	}
	public void setDATEEND2(Timestamp dATEEND2) {
		DATEEND2 = dATEEND2;
	}
	public Timestamp getDATEEND3() {
		return DATEEND3;
	}
	public void setDATEEND3(Timestamp dATEEND3) {
		DATEEND3 = dATEEND3;
	}
	public Timestamp getDATEEND4() {
		return DATEEND4;
	}
	public void setDATEEND4(Timestamp dATEEND4) {
		DATEEND4 = dATEEND4;
	}
	public String getXML_BLOB() {
		return XML_BLOB;
	}
	public void setXML_BLOB(String xML_BLOB) {
		XML_BLOB = xML_BLOB;
	}

}
