package services_1;

import java.util.List;

import entities_1.HS_ACCT_STOP;
import utils.DAOException;

public interface HS_ACCT_STOP_Services {

	/*
	@Id private String 		NUMBANK;
	@Id private String 		TYPEACCT;
	@Id private String 		NUMACCT;
	@Id private String 		IDSTOP;

	private String 		REGIONID;

	 */
	
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	 */
	
 	void create(HS_ACCT_STOP acct) throws DAOException;

    void update(HS_ACCT_STOP acct) throws DAOException;

    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT, 
    		String IDSTOP) throws DAOException;

    List<HS_ACCT_STOP> retrieveByTYPEACCT(String TYPEACCT) throws DAOException; //char 3
    
    List<HS_ACCT_STOP> retrieveByNUMACCT(String NUMACCT) throws DAOException; //char 19
    
    List<HS_ACCT_STOP> retrieveByIDSTOP(String IDSTOP) throws DAOException; //char 20
    
    List<HS_ACCT_STOP> retrieveByREGIONID(String REGIONID) throws DAOException; //char 8
    
    Long count() throws DAOException;
	
}
