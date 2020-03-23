package hs_services;

import java.util.List;

import hs_entities.HS_CUAC;
import utils.DAOException;

public interface HS_ACCT_CUAC_Services {
/*
 * @Id private String CUSTBANK;
	@Id private String TYPECUST;
	@Id private String CIF;
	@Id private String NUMBANK;
	@Id private String TYPEACCT;
	@Id private String NUMACCT;
	private String STATE2;

 * */
	
	
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	 */
	
 	void create(HS_CUAC acct) throws DAOException;
  

    void update(HS_CUAC acct) throws DAOException;

    void delete(String CUSTBANK,  String TYPECUST,String CIF, 
    		String NUMBANK, String TYPEACCT, String NUMACCT) throws DAOException;
    
    List<HS_CUAC> retrieveByTYPECUST(String TYPECUST) throws DAOException; //char 3
    
    List<HS_CUAC> retrieveByCIF(String CIF) throws DAOException; //char 20
    
    List<HS_CUAC> retrieveByTYPEACCT(String TYPEACCT) throws DAOException; //char 3
    
    List<HS_CUAC> retrieveByNUMACCT(String NUMACCT) throws DAOException; //char 19
    
    List<HS_CUAC> retrieveBySTATE2(String STATE2) throws DAOException; //char 2
    
    Long count() throws DAOException;
	
	
	
}
