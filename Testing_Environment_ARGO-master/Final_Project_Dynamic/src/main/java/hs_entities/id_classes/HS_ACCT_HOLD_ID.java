package hs_entities.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class HS_ACCT_HOLD_ID implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String 	NUMBANK;
	private String 	TYPEACCT;
	private String 	NUMACCT;
	private String 	IDHOLD;
	
	
	public HS_ACCT_HOLD_ID() {}
	
	public HS_ACCT_HOLD_ID(String nUMBANK, String tYPEACCT, 
			String nUMACCT, String iDHOLD) {

		NUMBANK = nUMBANK;
		TYPEACCT = tYPEACCT;
		NUMACCT = nUMACCT;
		IDHOLD = iDHOLD;
	}
	
	@Override
	public boolean equals(Object obj) {
		  if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_HOLD_ID)) return false;
         HS_ACCT_HOLD_ID pk = (HS_ACCT_HOLD_ID) obj;
         return pk.NUMBANK.equals(this.NUMBANK) && pk.TYPEACCT.equals(this.TYPEACCT) &&
        		 pk.NUMACCT.equals(this.NUMACCT) && pk.IDHOLD.equals(this.IDHOLD);
	}
	
	@Override
	  public int hashCode() {
	      return Objects.hash(NUMBANK, TYPEACCT, NUMACCT, IDHOLD);
	  }

}
