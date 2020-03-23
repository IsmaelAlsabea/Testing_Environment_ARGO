package utils;

import java.sql.Timestamp;

import hs_entities.HS_ACCT;
import hs_entities.HS_ACCT_HOLD;
import hs_entities.HS_ACCT_NOTE;
import hs_entities.HS_ACCT_STOP;
import hs_entities.HS_CUAC;
import hs_entities.HS_CUST;

public interface HS_Builder {

	HS_ACCT build_HS_ACCT (String nUMBANK, String tYPEACCT, String nUMACCT, String pRODCODE, String nUMTAXID, String aCTTITLE1,
			String aCTTITLE2, String aCTTITLE3, String aCTTITLE4, String nUMBRNCH, String sTATUS2, Timestamp lASTDATE,
			Timestamp dATEOPEN, Timestamp dATECLSE, String rEASONCL, String cOMMENT1, String cOMMENT2, String aMTCURBL,
			String nUMSIGN, String tAXIDTYP, String aLIENNUM, String fLGFORGN1, String fLGFORGN2, String sTREET1A,
			String sTREET1B, String sTREET2A, String sTREET2B, String cITY1, String cITY2, String sTATE1, String sTATE2,
			String zIP1, String zIP2, Timestamp dATEBEG, Timestamp dATEEND, String xML_BLOB, Timestamp cOMMENTDATE1,
			Timestamp cOMMENTDATE2, String oPERID);
	
	HS_ACCT_STOP build_HS_ACCT_STOP (String nUMBANK, String tYPEACCT, String nUMACCT, String iDSTOP, String nUMBEG, String nUMEND,
			String aMTCHECK, Timestamp dATEEXPR, Timestamp dATECRTD, String oPERID, String nAMPAYTO, String sTOPREAS,
			String rEGIONID, Timestamp dATECHK, String oFFID);
	
	HS_ACCT_NOTE build_HS_ACCT_NOTE (String rEGIONID, String tYPEACCT, String nUMACCT, Timestamp dATECRTD, String aCTNOTE,
			String oPERID, String iDNOTE);
	
	HS_ACCT_HOLD build_HS_ACCT_HOLD (String nUMBANK, String tYPEACCT, String nUMACCT, String iDHOLD, String oFFID, String hOLDTXT,
			String aMTHOLD, Timestamp dATEEXPR, Timestamp dATEADDED, String nUMBRNCH, String oPERID, String dESCCODE,
			String dATEDEP, String rSNHOLD);
	
	HS_CUST build_HS_ACCT_CUST(String nUMBANK, String tYPECUST, String cIF, String nAMFULL, String nUMTAXID, String nUMBRNCH,
			Timestamp lASTDATE, Timestamp dATEOPEN, String pHONETYP1, String pHONETYP2, String pHONETYP3,
			String pHONETYP4, String pHONE1, String pHONE2, String pHONE3, String pHONE4, String pHONEEXT1,
			String pHONEEXT2, String pHONEEXT3, String pHONEEXT4, String oPERID, String aDDRTYP1, String aDDRTYP2,
			String aDDRTYP3, String aDDRTYP4, String fLGFORGN1, String fLGFORGN2, String fLGFORGN3, String fLGFORGN4,
			String sTREET1A, String sTREET1B, String sTREET1C, String sTREET1D, String sTREET2A, String sTREET2B,
			String sTREET2C, String sTREET2D, String cITY1, String cITY2, String cITY3, String cITY4, String sTATE1,
			String sTATE2, String sTATE3, String sTATE4, String zIP1, String zIP2, String zIP3, String zIP4,
			Timestamp dATEBEG1, Timestamp dATEBEG2, Timestamp dATEBEG3, Timestamp dATEBEG4, Timestamp dATEEND1,
			Timestamp dATEEND2, Timestamp dATEEND3, Timestamp dATEEND4, String xML_BLOB);
	
	HS_CUAC build_HS_ACCT_CUAC(String cUSTBANK, String tYPECUST, String cIF, String nUMBANK, String tYPEACCT, String nUMACCT,
			String rELATION, String cODEOWNR, String sTATE2, String rELATN4);
	
}
