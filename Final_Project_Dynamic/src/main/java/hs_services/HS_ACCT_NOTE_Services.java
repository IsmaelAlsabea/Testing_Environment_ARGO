package hs_services;

import java.util.List;

import hs_entities.HS_ACCT_NOTE;
import utils.DAOException;

public interface HS_ACCT_NOTE_Services {

	
	/*
	 * @Id private String 		REGIONID;
	@Id private String 		TYPEACCT;
	@Id private String 		NUMACCT;
	@Id private Timestamp 	DATECRTD;
	
	 */
	
	 	void create(HS_ACCT_NOTE acct) throws DAOException;

	    void update(HS_ACCT_NOTE acct) throws DAOException;

	    void delete(String REGIONID,  String TYPEACCT,String NUMACCT) throws DAOException;

	    List<HS_ACCT_NOTE> retrieveByREGIONID(String REGIONID) throws DAOException; //char 4

	    List<HS_ACCT_NOTE> retrieveByTYPEACCT(String TYPEACCT) throws DAOException; //char 3
	    
	    List<HS_ACCT_NOTE> retrieveByNUMACCT(String NUMACCT) throws DAOException; //char 19
	    
	    Long count() throws DAOException;
}
