package utils;

import java.sql.Timestamp;

import entities_1.HS_ACCT;
import entities_1.HS_ACCT_CUAC;
import entities_1.HS_ACCT_CUST;
import entities_1.HS_ACCT_HOLD;
import entities_1.HS_ACCT_NOTE;
import entities_1.HS_ACCT_STOP;


//Singleton
public class HS_Builder_Impl implements HS_Builder {
	
	
	private static HS_Builder_Impl hs_builder;
	
	private HS_Builder_Impl() {} 
	  
	public static HS_Builder_Impl getInstance() 
    { 
        if (hs_builder==null) 
        	hs_builder = new HS_Builder_Impl(); 
        return hs_builder; 
    } 

	public HS_ACCT build_HS_ACCT(String nUMBANK, String tYPEACCT, String nUMACCT, String pRODCODE, String nUMTAXID,
			String aCTTITLE1, String aCTTITLE2, String aCTTITLE3, String aCTTITLE4, String nUMBRNCH, String sTATUS2,
			Timestamp lASTDATE, Timestamp dATEOPEN, Timestamp dATECLSE, String rEASONCL, String cOMMENT1,
			String cOMMENT2, String aMTCURBL, String nUMSIGN, String tAXIDTYP, String aLIENNUM, String fLGFORGN1,
			String fLGFORGN2, String sTREET1A, String sTREET1B, String sTREET2A, String sTREET2B, String cITY1,
			String cITY2, String sTATE1, String sTATE2, String zIP1, String zIP2, Timestamp dATEBEG, Timestamp dATEEND,
			String xML_BLOB, Timestamp cOMMENTDATE1, Timestamp cOMMENTDATE2, String oPERID) {
		
		HS_ACCT acct = new HS_ACCT();
	
		acct.setNUMBANK(nUMBANK);
		
		acct. setTYPEACCT( tYPEACCT);
		
		acct.setNUMACCT( nUMACCT); 
	
		acct.setPRODCODE(pRODCODE);
		
		acct. setNUMTAXID( nUMTAXID);
		
		acct.setACTTITLE1( aCTTITLE1);
		acct.setACTTITLE2( aCTTITLE2);
		acct.setACTTITLE3( aCTTITLE3);
		acct.setACTTITLE4( aCTTITLE4);
		acct.setNUMBRNCH( nUMBRNCH);
		
		acct.setSTATUS2( sTATUS2);
		acct.setLASTDATE( lASTDATE);
		
		acct.setDATEOPEN( dATEOPEN);
		
		acct.setDATECLSE( dATECLSE);
		
		acct.setREASONCL( rEASONCL);
		
		acct.setCOMMENT1( cOMMENT1);
		acct.setCOMMENT2( cOMMENT2);
		
		acct.setAMTCURBL( aMTCURBL);
		acct.setNUMSIGN( nUMSIGN);
		
		acct.setTAXIDTYP( tAXIDTYP);
		
		acct.setALIENNUM( aLIENNUM);
		
		acct.setFLGFORGN1( fLGFORGN1);
		
		acct.setFLGFORGN2( fLGFORGN2);
		
		acct.setSTREET1A( sTREET1A);
		
		acct.setSTREET1B( sTREET1B);
		
		acct.setSTREET2A( sTREET2A);
		
		acct.setSTREET2B( sTREET2B);
		
		acct.setCITY1( cITY1);
		
		acct.setCITY2( cITY2);
		acct. setSTATE1( sTATE1);
		
		acct.setSTATE2( sTATE2);
		acct.setZIP1( zIP1);
		
		acct.setZIP2( zIP2);
		acct.setDATEBEG( dATEBEG);
		
		acct.setDATEEND( dATEEND);
		
		acct.setXML_BLOB( xML_BLOB);
		
		acct.setCOMMENTDATE1( cOMMENTDATE1);
		
		acct.setCOMMENTDATE2( cOMMENTDATE2);
		
		acct.setOPERID( oPERID);
		
		return acct;
	}

	public HS_ACCT_STOP build_HS_ACCT_STOP(String nUMBANK, String tYPEACCT, String nUMACCT, String iDSTOP,
			String nUMBEG, String nUMEND, String aMTCHECK, Timestamp dATEEXPR, Timestamp dATECRTD, String oPERID,
			String nAMPAYTO, String sTOPREAS, String rEGIONID, Timestamp dATECHK, String oFFID) {
		// TODO Auto-generated method stub
		return null;
	}

	public HS_ACCT_NOTE build_HS_ACCT_NOTE(String rEGIONID, String tYPEACCT, String nUMACCT, Timestamp dATECRTD,
			String aCTNOTE, String oPERID, String iDNOTE) {
		
		HS_ACCT_NOTE acNote= new HS_ACCT_NOTE();
		
		acNote.setREGIONID(rEGIONID);
		acNote.setTYPEACCT(tYPEACCT);
		acNote.setNUMACCT(nUMACCT);
		acNote.setDATECRTD(dATECRTD);
		acNote.setACTNOTE(aCTNOTE);
		acNote.setOPERID(oPERID);
		acNote.setIDNOTE(iDNOTE);
		
		return acNote;
	}

	public HS_ACCT_HOLD build_HS_ACCT_HOLD(String nUMBANK, String tYPEACCT, String nUMACCT, String iDHOLD, String oFFID,
			String hOLDTXT, String aMTHOLD, Timestamp dATEEXPR, Timestamp dATEADDED, String nUMBRNCH, String oPERID,
			String dESCCODE, String dATEDEP, String rSNHOLD) {
		
                HS_ACCT_HOLD acHold = new HS_ACCT_HOLD();
                
                acHold.setNUMBANK(nUMBANK);
                acHold.setTYPEACCT(tYPEACCT);
                acHold.setNUMACCT(nUMACCT);
                acHold.setIDHOLD(iDHOLD);
                acHold.setOFFID(oFFID);
                acHold.setHOLDTXT(hOLDTXT);
                acHold.setAMTHOLD(aMTHOLD);
                acHold.setDATEEXPR(dATEEXPR);
                acHold.setDATEADDED(dATEADDED);
                acHold.setNUMBRNCH(nUMBRNCH);
                acHold.setOPERID(oPERID);
                acHold.setDESCCODE(dESCCODE);
                acHold.setDATEDEP(dATEDEP);
                acHold.setRSNHOLD(rSNHOLD);
                
		return acHold;
	}

	public HS_ACCT_CUST build_HS_ACCT_CUST(String nUMBANK, String tYPECUST, String cIF, String nAMFULL, String nUMTAXID,
			String nUMBRNCH, Timestamp lASTDATE, Timestamp dATEOPEN, String pHONETYP1, String pHONETYP2,
			String pHONETYP3, String pHONETYP4, String pHONE1, String pHONE2, String pHONE3, String pHONE4,
			String pHONEEXT1, String pHONEEXT2, String pHONEEXT3, String pHONEEXT4, String oPERID, String aDDRTYP1,
			String aDDRTYP2, String aDDRTYP3, String aDDRTYP4, String fLGFORGN1, String fLGFORGN2, String fLGFORGN3,
			String fLGFORGN4, String sTREET1A, String sTREET1B, String sTREET1C, String sTREET1D, String sTREET2A,
			String sTREET2B, String sTREET2C, String sTREET2D, String cITY1, String cITY2, String cITY3, String cITY4,
			String sTATE1, String sTATE2, String sTATE3, String sTATE4, String zIP1, String zIP2, String zIP3,
			String zIP4, Timestamp dATEBEG1, Timestamp dATEBEG2, Timestamp dATEBEG3, Timestamp dATEBEG4,
			Timestamp dATEEND1, Timestamp dATEEND2, Timestamp dATEEND3, Timestamp dATEEND4, String xML_BLOB) {
		// TODO Auto-generated method stub
		return null;
	}

	public HS_ACCT_CUAC build_HS_ACCT_CUAC(String cUSTBANK, String tYPECUST, String cIF, String nUMBANK,
			String tYPEACCT, String nUMACCT, String rELATION, String cODEOWNR, String sTATE2, String rELATN4) {
		
                HS_ACCT_CUAC acCuac = new HS_ACCT_CUAC();
                
                acCuac.setCUSTBANK(cUSTBANK);
                acCuac.setTYPECUST(tYPECUST);
                acCuac.setCIF(cIF);
                acCuac.setNUMBANK(nUMBANK);
                acCuac.setTYPEACCT(tYPEACCT);
                acCuac.setNUMACCT(nUMACCT);
                acCuac.setRELATION(rELATION);
                acCuac.setCODEOWNR(cODEOWNR);
                acCuac.setSTATE2(sTATE2);
                acCuac.setRELATN4(rELATN4);
                
		return acCuac;
	}

}
