package entities_1;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entities_1.id_classes.HS_ACCT_STOP_ID;

@Entity @Table
@IdClass(HS_ACCT_STOP_ID.class)
public class HS_ACCT_STOP {

	@Id private String 		NUMBANK;
	@Id private String 		TYPEACCT;
	@Id private String 		NUMACCT;
	@Id private String 		IDSTOP;
	
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
	
	
	public HS_ACCT_STOP(String nUMBANK, String tYPEACCT, String nUMACCT, String iDSTOP, String nUMBEG, String nUMEND,
			String aMTCHECK, Timestamp dATEEXPR, Timestamp dATECRTD, String oPERID, String nAMPAYTO, String sTOPREAS,
			String rEGIONID, Timestamp dATECHK, String oFFID) {
		super();
		NUMBANK = nUMBANK;
		TYPEACCT = tYPEACCT;
		NUMACCT = nUMACCT;
		IDSTOP = iDSTOP;
		NUMBEG = nUMBEG;
		NUMEND = nUMEND;
		AMTCHECK = aMTCHECK;
		DATEEXPR = dATEEXPR;
		DATECRTD = dATECRTD;
		OPERID = oPERID;
		NAMPAYTO = nAMPAYTO;
		STOPREAS = sTOPREAS;
		REGIONID = rEGIONID;
		DATECHK = dATECHK;
		OFFID = oFFID;
	}


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
