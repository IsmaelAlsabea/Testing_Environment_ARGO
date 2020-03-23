package hs_services;

import java.util.List;

import hs_entities.HS_CUST;
import utils.DAOException;

public interface HS_ACCT_CUST_Services {

	
	/*
	 * @Id private String  NUMBANK;
	@Id private String  TYPECUST;
	@Id private String  	CIF;
	
	private String  	NAMFULL;
	private String  	NUMTAXID;



	private String 		CITY1;
	private String 		CITY2;
	private String 		CITY3;
	private String 		CITY4;
	private String 		STATE1;
	private String 		STATE2;
	private String 		STATE3;
	private String 		STATE4;
	private String 		ZIP1;
	private String 		ZIP2;
	private String 		ZIP3;
	private String 		ZIP4;
	 * */
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	 */
	
    void create(HS_CUST acct) throws DAOException;


    void update(HS_CUST acct) throws DAOException;

    void delete(String NUMBANK,  String TYPECUST,String CIF) throws DAOException;

    List<HS_CUST> retrieveByTYPECUST(String TYPECUST) throws DAOException;  //char 3  //customer type
    
    List<HS_CUST> retrieveByCIF(String CIF) throws DAOException;	//char 20 
    
    List<HS_CUST> retrieveByNAMFULL(String NAMFULL) throws DAOException;	//char 40 
    
    List<HS_CUST> retrieveByNUMTAXID(String NUMTAXID) throws DAOException;  //char 9  //tax id
    
    List<HS_CUST> retrieveByCITY1(String CITY1) throws DAOException; //char 25  
    
    List<HS_CUST> retrieveByCITY2(String CITY2) throws DAOException; //char 25  
    
    List<HS_CUST> retrieveByCITY3(String CITY3) throws DAOException; //char 25  
    
    List<HS_CUST> retrieveByCITY4(String CITY4) throws DAOException; //char 25  
    
    List<HS_CUST> retrieveBySTATE1(String STATE1) throws DAOException; //char 2  
    
    List<HS_CUST> retrieveBySTATE2(String STATE2) throws DAOException; //char 2  
    
    List<HS_CUST> retrieveBySTATE3(String STATE3) throws DAOException; //char 2  
    
    List<HS_CUST> retrieveBySTATE4(String STATE4) throws DAOException; //char 2  
    
    List<HS_CUST> retrieveByZIP1(String ZIP1) throws DAOException; //varchar 9  
    
    List<HS_CUST> retrieveByZIP2(String ZIP2) throws DAOException; //varchar 9  
    
    List<HS_CUST> retrieveByZIP3(String ZIP3) throws DAOException; //varchar 9  
    
    List<HS_CUST> retrieveByZIP4(String ZIP4) throws DAOException; //varchar 9  

}
