package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_CUST;
import services_1.HS_ACCT_CUST_Services;
import utils.DAOException;

public class HS_ACCT_CUST_Services_Impl implements HS_ACCT_CUST_Services {

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_CUST_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(HS_ACCT_CUST acct) throws DAOException {
		// TODO Auto-generated method stub

	}


	public void update(HS_ACCT_CUST acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(String NUMBANK, String TYPECUST, String CIF) throws DAOException {
		// TODO Auto-generated method stub

	}

	public List<HS_ACCT_CUST> retrieveByTYPECUST(String TYPECUST) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByCIF(String CIF) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByNAMFULL(String NAMFULL) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByNUMTAXID(String NUMTAXID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByCITY1(String CITY1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByCITY2(String CITY2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByCITY3(String CITY3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByCITY4(String CITY4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveBySTATE1(String STATE1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveBySTATE2(String STATE2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveBySTATE3(String STATE3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveBySTATE4(String STATE4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByZIP1(String ZIP1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByZIP2(String ZIP2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByZIP3(String ZIP3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT_CUST> retrieveByZIP4(String ZIP4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Long count() throws DAOException {
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_CUST g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
