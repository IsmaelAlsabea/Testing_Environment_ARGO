package entities_1.id_classes;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class HS_ACCT_NOTE_ID implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String 	REGIONID;
	private String 	TYPEACCT;
	private String 	NUMACCT;
	private Timestamp 	DATECRTD;

	public HS_ACCT_NOTE_ID() {}
	
	public HS_ACCT_NOTE_ID(String rEGIONID, String tYPEACCT, 
			String nUMACCT, Timestamp dATECRTD) {

		REGIONID = rEGIONID;
		TYPEACCT = tYPEACCT;
		NUMACCT = nUMACCT;
		DATECRTD = dATECRTD;
	}
	@Override
	public boolean equals(Object obj) {
		  if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_NOTE_ID)) return false;
         HS_ACCT_NOTE_ID pk = (HS_ACCT_NOTE_ID) obj;
         return pk.REGIONID.equals(this.REGIONID) && pk.TYPEACCT.equals(this.TYPEACCT) &&
        		 pk.NUMACCT.equals(this.NUMACCT) && pk.DATECRTD.equals(this.DATECRTD);
	}
	
	@Override
	  public int hashCode() {
	      return Objects.hash(REGIONID, TYPEACCT, NUMACCT, DATECRTD);
	  }
	
}
