package entities.hs_entities;

import java.sql.Timestamp;


public class HS_ACCT_HOLD {

	private String 		NUMBANK;
	private String 		TYPEACCT;
	private String 		NUMACCT;
	private String 		IDHOLD;
	
	private String 		OFFID;
	private String 		HOLDTXT;
	private String 		AMTHOLD;
	private Timestamp 	DATEEXPR;
	private Timestamp 	DATEADDED;
	private String 		NUMBRNCH;
	private String 		OPERID;
	private String 		DESCCODE;
	private String 		DATEDEP;
	private String 		RSNHOLD;
	
	
	public HS_ACCT_HOLD() {}
	
	
	public String getNUMBANK() {
		return NUMBANK;
	}
	public void setNUMBANK(String nUMBANK) {
		NUMBANK = nUMBANK;
	}
	public String getTYPEACCT() {
		return TYPEACCT;
	}
	public void setTYPEACCT(String tYPEACCT) {
		TYPEACCT = tYPEACCT;
	}
	public String getNUMACCT() {
		return NUMACCT;
	}
	public void setNUMACCT(String nUMACCT) {
		NUMACCT = nUMACCT;
	}
	public String getIDHOLD() {
		return IDHOLD;
	}
	public void setIDHOLD(String iDHOLD) {
		IDHOLD = iDHOLD;
	}
	public String getOFFID() {
		return OFFID;
	}
	public void setOFFID(String oFFID) {
		OFFID = oFFID;
	}
	public String getHOLDTXT() {
		return HOLDTXT;
	}
	public void setHOLDTXT(String hOLDTXT) {
		HOLDTXT = hOLDTXT;
	}
	public String getAMTHOLD() {
		return AMTHOLD;
	}
	public void setAMTHOLD(String aMTHOLD) {
		AMTHOLD = aMTHOLD;
	}
	public Timestamp getDATEEXPR() {
		return DATEEXPR;
	}
	public void setDATEEXPR(Timestamp dATEEXPR) {
		DATEEXPR = dATEEXPR;
	}
	public Timestamp getDATEADDED() {
		return DATEADDED;
	}
	public void setDATEADDED(Timestamp dATEADDED) {
		DATEADDED = dATEADDED;
	}
	public String getNUMBRNCH() {
		return NUMBRNCH;
	}
	public void setNUMBRNCH(String nUMBRNCH) {
		NUMBRNCH = nUMBRNCH;
	}
	public String getOPERID() {
		return OPERID;
	}
	public void setOPERID(String oPERID) {
		OPERID = oPERID;
	}
	public String getDESCCODE() {
		return DESCCODE;
	}
	public void setDESCCODE(String dESCCODE) {
		DESCCODE = dESCCODE;
	}
	public String getDATEDEP() {
		return DATEDEP;
	}
	public void setDATEDEP(String dATEDEP) {
		DATEDEP = dATEDEP;
	}
	public String getRSNHOLD() {
		return RSNHOLD;
	}
	public void setRSNHOLD(String rSNHOLD) {
		RSNHOLD = rSNHOLD;
	}

}
