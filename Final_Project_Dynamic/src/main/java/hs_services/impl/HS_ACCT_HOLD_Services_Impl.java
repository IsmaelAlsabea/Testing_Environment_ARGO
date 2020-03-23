package hs_services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hs_entities.HS_ACCT_HOLD;
import hs_services.HS_ACCT_HOLD_Services;
import utils.DAOException;

public class HS_ACCT_HOLD_Services_Impl implements HS_ACCT_HOLD_Services {

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_HOLD_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(HS_ACCT_HOLD acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void update(HS_ACCT_HOLD acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, String IDHOLD) throws DAOException {
		// TODO Auto-generated method stub

	}

	public List<HS_ACCT_HOLD> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_HOLD> retrieveByNUMACCT(String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_HOLD> retrieveByIDHOLD(String IDHOLD) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_HOLD g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
