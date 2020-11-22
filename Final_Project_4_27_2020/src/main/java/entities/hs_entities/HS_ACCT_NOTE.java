package entities.hs_entities;

import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;


public class HS_ACCT_NOTE {
	
	private String 		REGIONID;
	private String 		TYPEACCT;
	private String 		NUMACCT;
	private Timestamp 	DATECRTD;
	
	private String 		ACTNOTE;
	private String 		OPERID;
	private String 		IDNOTE;
	
	
	public HS_ACCT_NOTE() {}
	

	public String getREGIONID() {
		return REGIONID;
	}
	public void setREGIONID(String rEGIONID) {
		
	
		REGIONID = rEGIONID;
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
	public Timestamp getDATECRTD() {
		return DATECRTD;
	}
	public void setDATECRTD(Timestamp dATECRTD) {
		DATECRTD = dATECRTD;
	}
	public String getACTNOTE() {
		return ACTNOTE;
	}
	public void setACTNOTE(String aCTNOTE) {
		ACTNOTE = aCTNOTE;
	}
	public String getOPERID() {
		return OPERID;
	}
	public void setOPERID(String oPERID) {
		OPERID = oPERID;
	}
	public String getIDNOTE() {
		return IDNOTE;
	}
	public void setIDNOTE(String iDNOTE) {
		IDNOTE = iDNOTE;
	}
	
	//constraint is 
	protected int readAnInt(Scanner reader,String errorMessage, int lowConstraint, int highConstraint) {
		int x = -1;
		
		while (true) {
			try {
			x = reader.nextInt();
			if (x != -1 && x >= lowConstraint && x <= highConstraint)
				break;
			} catch(InputMismatchException e){
				System.out.println(errorMessage);
				reader.nextLine();
			} catch (Exception e) {
				e.toString();
				System.out.println("Unhandled problem");
			}
		}
		return x;
	}
	
	
	protected String readALineFromKeyboard(Scanner reader) {
		String str = "";
		
		while (true) {
			str = reader.nextLine();
			if (!str.equals(""))
				break;
		}
		return str;
	}
	
}
