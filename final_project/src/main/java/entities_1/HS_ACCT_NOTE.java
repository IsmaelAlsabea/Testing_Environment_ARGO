package entities_1;

import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entities_1.id_classes.HS_ACCT_NOTE_ID;


@Entity @Table
@IdClass(HS_ACCT_NOTE_ID.class)
public class HS_ACCT_NOTE {
	
	@Id private String 		REGIONID;
	@Id private String 		TYPEACCT;
	@Id private String 		NUMACCT;
	@Id private Timestamp 	DATECRTD;
	
	private String 		ACTNOTE;
	private String 		OPERID;
	private String 		IDNOTE;
	
	
	public HS_ACCT_NOTE() {}
	

	public String getREGIONID() {
		return REGIONID;
	}
	public void setREGIONID(String rEGIONID) {
		
		/*
		Scanner scan= new Scanner(System.in);
		int choice=-1;
		
			while (true) {
				if (rEGIONID.length() > 4) {
				System.out.println("the regionID you entered is more than 4 characters, and the table column you're "
						+ "inserting into, accepts at most an entry composed of 4 characters, so do you want to trim"
						+ "the entry, so you insert it into the table, or do you want to rewrite it?"
						+ "\n if you want to trim it enter 1, if you want to re-enter the Region_ID enter 2");
				
				choice = readAnInt(scan, "Please input either 1 or 2", 1, 2);
				if (choice == 1)
					rEGIONID= rEGIONID.substring(0,4);
				else if (choice == 2)
					rEGIONID=readALineFromKeyboard(scan);
			}
				//else if region id is less than 4, break;
				break;
		}
		*/
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
