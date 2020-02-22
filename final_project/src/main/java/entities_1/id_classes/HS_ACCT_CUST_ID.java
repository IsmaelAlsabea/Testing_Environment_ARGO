package entities_1.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class HS_ACCT_CUST_ID implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  NUMBANK;
	private String  TYPECUST;
	private String  CIF;
	
	
	public HS_ACCT_CUST_ID() {}
	
	public HS_ACCT_CUST_ID(String nUMBANK, String tYPECUST, String cIF) {
		NUMBANK = nUMBANK;
		TYPECUST = tYPECUST;
		CIF = cIF;
	}
	
	@Override
	public boolean equals(Object obj) {
		  if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_CUST_ID)) return false;
         HS_ACCT_CUST_ID pk = (HS_ACCT_CUST_ID) obj;
         return pk.NUMBANK.equals(this.NUMBANK) && pk.TYPECUST.equals(this.TYPECUST) &&
        		 pk.CIF.equals(this.CIF);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(NUMBANK, TYPECUST, CIF);
	}
	
}
