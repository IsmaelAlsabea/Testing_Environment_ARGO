package hs_entities.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class HS_ACCT_CUAC_ID implements Serializable{


	private static final long serialVersionUID = 1L;
	private String CUSTBANK;
	private String TYPECUST;
	private String CIF;
	private String NUMBANK;
	private String TYPEACCT;
	private String NUMACCT;
	
	public HS_ACCT_CUAC_ID() {
		
	}
	
	public HS_ACCT_CUAC_ID(String cUSTBANK, String tYPECUST,
			String cIF, String nUMBANK, String tYPEACCT, String nUMACCT) {

		CUSTBANK 	= cUSTBANK;
		TYPECUST 	= tYPECUST;
		CIF 		= cIF;
		NUMBANK 	= nUMBANK;
		TYPEACCT 	= tYPEACCT;
		NUMACCT 	= nUMACCT;
	}
	
	@Override
	public boolean equals(Object obj) {
		  if (obj == this) return true;
         if (!(obj instanceof HS_ACCT_CUAC_ID)) return false;
         HS_ACCT_CUAC_ID pk = (HS_ACCT_CUAC_ID) obj;
         return pk.CUSTBANK.equals(this.CUSTBANK) && pk.TYPECUST.equals(this.TYPECUST) &&
        		 pk.CIF.equals(this.CIF) && pk.NUMBANK.equals(this.NUMBANK) &&
        		 pk.TYPEACCT.equals(this.TYPEACCT) && pk.NUMACCT.equals(this.NUMACCT);
	}
	
	
	@Override
	  public int hashCode() {
	      return Objects.hash(CUSTBANK, TYPECUST, CIF, NUMBANK, TYPEACCT, NUMACCT);
	  }
	
}
