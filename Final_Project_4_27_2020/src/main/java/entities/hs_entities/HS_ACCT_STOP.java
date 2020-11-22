package entities.hs_entities;

import java.sql.Timestamp;


public class HS_ACCT_STOP {

	private String 		NUMBANK;
	private String 		TYPEACCT;
	private String 		NUMACCT;
	private String 		IDSTOP;
	
	private String 		NUMBEG;
	private String 		NUMEND;
	private String 		AMTCHECK;
	private Timestamp 	DATEEXPR;
	private Timestamp 	DATECRTD;
	private String 		OPERID;
	private String 		NAMPAYTO;
	private String 		STOPREAS;
	private String 		REGIONID;
	private Timestamp 	DATECHK;
	private String 		OFFID;
	
	public HS_ACCT_STOP() {}
	
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
	public String getIDSTOP() {
		return IDSTOP;
	}
	public void setIDSTOP(String iDSTOP) {
		IDSTOP = iDSTOP;
	}
	public String getNUMBEG() {
		return NUMBEG;
	}
	public void setNUMBEG(String nUMBEG) {
		NUMBEG = nUMBEG;
	}
	public String getNUMEND() {
		return NUMEND;
	}
	public void setNUMEND(String nUMEND) {
		NUMEND = nUMEND;
	}
	public String getAMTCHECK() {
		return AMTCHECK;
	}
	public void setAMTCHECK(String aMTCHECK) {
		AMTCHECK = aMTCHECK;
	}
	public Timestamp getDATEEXPR() {
		return DATEEXPR;
	}
	public void setDATEEXPR(Timestamp dATEEXPR) {
		DATEEXPR = dATEEXPR;
	}
	public Timestamp getDATECRTD() {
		return DATECRTD;
	}
	public void setDATECRTD(Timestamp dATECRTD) {
		DATECRTD = dATECRTD;
	}
	public String getOPERID() {
		return OPERID;
	}
	public void setOPERID(String oPERID) {
		OPERID = oPERID;
	}
	public String getNAMPAYTO() {
		return NAMPAYTO;
	}
	public void setNAMPAYTO(String nAMPAYTO) {
		NAMPAYTO = nAMPAYTO;
	}
	public String getSTOPREAS() {
		return STOPREAS;
	}
	public void setSTOPREAS(String sTOPREAS) {
		STOPREAS = sTOPREAS;
	}
	public String getREGIONID() {
		return REGIONID;
	}
	public void setREGIONID(String rEGIONID) {
		REGIONID = rEGIONID;
	}
	public Timestamp getDATECHK() {
		return DATECHK;
	}
	public void setDATECHK(Timestamp dATECHK) {
		DATECHK = dATECHK;
	}
	public String getOFFID() {
		return OFFID;
	}
	public void setOFFID(String oFFID) {
		OFFID = oFFID;
	}

}
