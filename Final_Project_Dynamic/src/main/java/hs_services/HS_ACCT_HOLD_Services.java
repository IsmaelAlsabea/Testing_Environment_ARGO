package hs_services;

import java.util.List;

import hs_entities.HS_ACCT_HOLD;
import utils.DAOException;

public interface HS_ACCT_HOLD_Services {

	/* 
	@Id private String 		NUMBANK;  //no		char 3
	@Id private String 		TYPEACCT;  //yes	 //char 3
	@Id private String 		NUMACCT;  //yes		char 19
	@Id private String 		IDHOLD; //yes		char 20 

	 */
	/*
	i.	Customer Type (drop down built on the records in the database)
	ii.	State (drop down built on the records in the database)
	iii.	Zip Code
	iv.	Tax ID Number
	v.	Last Name
	 */
	
	
    void create(HS_ACCT_HOLD acct) throws DAOException;

    void update(HS_ACCT_HOLD acct) throws DAOException;

    void delete(String NUMBANK,  String TYPEACCT,String NUMACCT, String IDHOLD) throws DAOException;

    List<HS_ACCT_HOLD> retrieveByTYPEACCT(String TYPEACCT) throws DAOException;  //char 3  //customer type
    
    List<HS_ACCT_HOLD> retrieveByNUMACCT(String NUMACCT) throws DAOException;	//char 19  //account numbers
    
    List<HS_ACCT_HOLD> retrieveByIDHOLD(String IDHOLD) throws DAOException;  //char 20 
    
    Long count() throws DAOException;
	
}
