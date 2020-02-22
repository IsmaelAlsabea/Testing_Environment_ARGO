package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_STOP;
import services_1.HS_ACCT_STOP_Services;
import utils.DAOException;

public class HS_ACCT_STOP_Services_Impl implements HS_ACCT_STOP_Services {

	@PersistenceContext
	private EntityManager em;

	public HS_ACCT_STOP_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(HS_ACCT_STOP acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public List<HS_ACCT_STOP> retrieve(String NUMBANK, String TYPEACCT, String NUMACCT, String IDSTOP)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(HS_ACCT_STOP acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, String IDSTOP) throws DAOException {
		// TODO Auto-generated method stub

	}

	public List<HS_ACCT_STOP> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_STOP> retrieveByNUMACCT(String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_STOP> retrieveByIDSTOP(String IDSTOP) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_STOP> retrieveByREGIONID(String REGIONID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		// TODO Auto-generated method stub
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_STOP g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
