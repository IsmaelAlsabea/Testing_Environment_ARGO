package entities.front_end_entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Acct_View extends Viewable{

	//these commented fields are in Viewable, so there is no need to define them here.
//	private String numBank;
//	private String typeAcct;
//	private String numAcct;
	
	
	
	private String prodCode;
	private String branch;
	private String amtCurBl;
	
	
	//****************VIEW This Account fields************
	
	private String fullName, status, reasonClosed;
	private Date lastDate, dateOpen, dateClosed,  beginDate, endDate;
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAmtCurBl() {
		return amtCurBl;
	}
	public void setAmtCurBl(String amtCurBl) {
		this.amtCurBl = amtCurBl;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getReasonClosed() {
		return reasonClosed;
	}
	public void setReasonClosed(String reasonClosed) {
		this.reasonClosed = reasonClosed;
	}
	
	
	
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Date getDateOpen() {
		return dateOpen;
	}
	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}
	public Date getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public static Acct_View extractFromResultSet(ResultSet rs) {
		
		Acct_View record = new Acct_View();
		
		try {
			
			record.extractKeysFromRs(rs);

			record.prodCode= rs.getString("PRODCODE");
			record.branch= rs.getString("NUMBRNCH");
			record.amtCurBl= rs.getString("AMTCURBL");
			record.fullName = rs.getString("ACTTITLE1");
			record.status = rs.getString("STATUS2");
			record.lastDate = rs.getDate("LASTDATE");
			record.dateOpen = rs.getDate("DATEOPEN");
			record.dateClosed = rs.getDate("DATECLSE");
			record.reasonClosed = rs.getString("REASONCL");
			record.beginDate = rs.getDate("DATEBEG");
			record.endDate = rs.getDate("DATEEND");

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return record;
		
	}

}
