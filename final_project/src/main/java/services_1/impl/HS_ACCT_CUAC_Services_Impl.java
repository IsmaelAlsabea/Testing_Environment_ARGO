package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_CUAC;
import services_1.HS_ACCT_CUAC_Services;
import utils.DAOException;

public class HS_ACCT_CUAC_Services_Impl implements HS_ACCT_CUAC_Services{

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_CUAC_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(HS_ACCT_CUAC acct) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public void update(HS_ACCT_CUAC acct) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public void delete(String CUSTBANK, String TYPECUST, String CIF, String NUMBANK, String TYPEACCT, String NUMACCT)
			throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public List<HS_ACCT_CUAC> retrieveByTYPECUST(String TYPECUST) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUAC> retrieveByCIF(String CIF) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUAC> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUAC> retrieveByNUMACCT(String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUAC> retrieveBySTATE2(String STATE2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_CUAC g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
