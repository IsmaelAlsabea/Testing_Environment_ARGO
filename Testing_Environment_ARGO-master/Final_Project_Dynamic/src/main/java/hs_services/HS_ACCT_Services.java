package hs_services;


import java.util.List;

import hs_entities.HS_ACCT;
import utils.DAOException;


public interface HS_ACCT_Services {
	/*
	 * 	private String 		CITY1;
	private String 		CITY2;
	private String 		STATE1;
	private String 		STATE2;
	 * */
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	 */
	
	    void create(HS_ACCT acct) throws DAOException;


	    void update(HS_ACCT acct) throws DAOException;

	    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT) throws DAOException;

	    List<HS_ACCT> retrieveByTYPEACCT(String TYPEACCT) throws DAOException;  //char 3  //customer type
	    
	    List<HS_ACCT> retrieveByNUMACCT(String NUMACCT) throws DAOException;	//char 19  //account numbers
	    
	    List<HS_ACCT> retrieveByNUMTAXID(String NUMTAXID) throws DAOException;  //char 9  //tax id
	    
	    List<HS_ACCT> retrieveByACTTITLE1(String ACTTITLE1) throws DAOException;  //char 40  //first name, last name
	    
	    List<HS_ACCT> retrieveByACTTITLE2(String ACTTITLE2) throws DAOException;  //char 40 
	    
	    List<HS_ACCT> retrieveByACTTITLE3(String ACTTITLE3) throws DAOException;  //char 40 
	    
	    List<HS_ACCT> retrieveByACTTITLE4(String ACTTITLE4) throws DAOException;  //char 40 
	    
	    List<HS_ACCT> retrieveByCITY1(String CITY1) throws DAOException; //char 25  
	    
	    List<HS_ACCT> retrieveByCITY2(String CITY2) throws DAOException; //char 25  
	    
	    List<HS_ACCT> retrieveBySTATE1(String STATE1) throws DAOException; //char 2  
	    
	    List<HS_ACCT> retrieveBySTATE2(String STATE2) throws DAOException; //char 2  
	    
	    List<HS_ACCT> retrieveByZIP1(String ZIP1) throws DAOException; //varchar 9  
	    
	    List<HS_ACCT> retrieveByZIP2(String ZIP2) throws DAOException; //varchar 9  

	    Long count() throws DAOException;

}
