package entities.front_end_entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Viewable {

	private String numtaxid, cif, custType;
	
	private String numBank, typeAcct, numAcct;
	

	
//	//hs_acct
//	private String numBank, typeacct, numacct;
//	// hs_cust
//	private String numBank, typeCust, cif;
//	
//	// hs_cuac
//	private String custBank, typeCust, cif, numBank, typeAcct, numAcct;
	
	
	/*
	 * custBank is the same as numBank;
	 * typeCust is the same as custType;
	 * 
	 */

	public String getCustType() {
		return custType;
	}

	public void setCustType(String cust_type) {
		this.custType = cust_type;
	}

	public String getNumtaxid() {
		return numtaxid;
	}

	public void setNumtaxid(String numtaxid) {
		this.numtaxid = numtaxid;
	}

	public String getCif() {
		return cif;
	}

	

	public String getNumBank() {
		return numBank;
	}

	public void setNumBank(String numBank) {
		this.numBank = numBank;
	}

	public String getTypeAcct() {
		return typeAcct;
	}

	public void setTypeAcct(String typeAcct) {
		this.typeAcct = typeAcct;
	}

	public String getNumAcct() {
		return numAcct;
	}

	public void setNumAcct(String numAcct) {
		this.numAcct = numAcct;
	}
	

	
	protected void extractKeysFromRs(ResultSet rs) {
		
		try {
			
			this.custType= rs.getString("TYPECUST");
			this.cif= rs.getString("CIF");
			this.numtaxid=  rs.getString("NUMTAXID");
			
			this.numBank= rs.getString("NUMBANK");
			this.typeAcct = rs.getString ("TYPEACCT");
			this.numAcct = rs.getString("NUMACCT");
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void get_keys_from_old_instance(Viewable view) {
		this.custType=view .getCustType();
		this.cif= view.getCif();
		this.numtaxid=  view.getNumtaxid();
		
		this.numBank= view.getNumBank();
		this.typeAcct = view.getTypeAcct();
		this.numAcct = view.getNumAcct();
	}
	
	
}
