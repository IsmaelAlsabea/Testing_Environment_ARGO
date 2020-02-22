package entities_1.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class HS_ACCT_ID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String 	NUMBANK;
	private String 	TYPEACCT;
	private String 	NUMACCT;
	
	
	public HS_ACCT_ID() {}
	
	public HS_ACCT_ID(String NUMBANK,String TYPEACCT,String NUMACCT) {
		
		this.NUMBANK=NUMBANK;
		this.TYPEACCT=TYPEACCT;
		this.NUMACCT=NUMACCT;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_ID)) return false;
         HS_ACCT_ID pk = (HS_ACCT_ID) obj;
         return pk.NUMBANK.equals(this.NUMBANK) && pk.TYPEACCT.equals(this.TYPEACCT) &&
        		 pk.NUMACCT.equals(this.NUMACCT) ;
	}
	
	@Override
	  public int hashCode() {
	      return Objects.hash(NUMBANK, TYPEACCT, NUMACCT);
	  }
	
}
