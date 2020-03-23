package hs_entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import hs_entities.id_classes.HS_ACCT_CUAC_ID;

@Entity 
@IdClass(HS_ACCT_CUAC_ID.class)
public class HS_CUAC {

	@Id private String CUSTBANK;
	@Id private String TYPECUST;
	@Id private String CIF;
	@Id private String NUMBANK;
	@Id private String TYPEACCT;
	@Id private String NUMACCT;
	
	private String RELATION;
	private String CODEOWNR;
	private String STATE2;
	private String RELATN4;

	
	public HS_CUAC() {}


	public String getCUSTBANK() {
		return CUSTBANK;
	}
	public void setCUSTBANK(String cUSTBANK) {
		CUSTBANK = cUSTBANK;
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
	public String getRELATION() {
		return RELATION;
	}
	public void setRELATION(String rELATION) {
		RELATION = rELATION;
	}
	public String getCODEOWNR() {
		return CODEOWNR;
	}
	public void setCODEOWNR(String cODEOWNR) {
		CODEOWNR = cODEOWNR;
	}
	public String getSTATE2() {
		return STATE2;
	}
	public void setSTATE2(String sTATE2) {
		STATE2 = sTATE2;
	}
	public String getRELATN4() {
		return RELATN4;
	}
	public void setRELATN4(String rELATN4) {
		RELATN4 = rELATN4;
	}
}
