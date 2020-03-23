package hs_entities.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class HS_ACCT_STOP_ID implements Serializable{


	private static final long serialVersionUID = 1L;
	private String 	NUMBANK;
	private String 	TYPEACCT;
	private String 	NUMACCT;
	private String 	IDSTOP;
	
	public HS_ACCT_STOP_ID() {}
	
	public HS_ACCT_STOP_ID(String nUMBANK, String tYPEACCT, 
			String nUMACCT, String iDSTOP) {

		NUMBANK = nUMBANK;
		TYPEACCT = tYPEACCT;
		NUMACCT = nUMACCT;
		IDSTOP = iDSTOP;
	}
	
	@Override
	public boolean equals(Object obj) {
		  if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_STOP_ID)) return false;
         HS_ACCT_STOP_ID pk = (HS_ACCT_STOP_ID) obj;
         return pk.NUMBANK.equals(this.NUMBANK) && pk.TYPEACCT.equals(this.TYPEACCT) &&
        		 pk.NUMACCT.equals(this.NUMACCT) && pk.IDSTOP.equals(this.IDSTOP);
	}
	
	
	@Override
	  public int hashCode() {
	      return Objects.hash(NUMBANK, TYPEACCT, NUMACCT, IDSTOP);
	  }
}
