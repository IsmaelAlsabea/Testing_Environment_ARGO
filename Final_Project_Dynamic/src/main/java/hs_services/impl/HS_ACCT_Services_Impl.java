package hs_services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import hs_entities.HS_ACCT;
import hs_services.HS_ACCT_Services;
import utils.DAOException;

public class HS_ACCT_Services_Impl implements HS_ACCT_Services {

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public void create(HS_ACCT acct) throws DAOException {
		// TODO Auto-generated method stub
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(acct);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void update(HS_ACCT acct) throws DAOException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(acct);
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT) throws DAOException {
		try {
			em.getTransaction().begin();
			
			Query q = em
					.createQuery("DELETE FROM HS_ACCT AS g WHERE g.NUMBANK = :nb AND g.TYPEACCT = :tacct "
							+ "AND g.NUMACCT= :nacct")
			.setParameter("nb", NUMBANK).setParameter("tacct", TYPEACCT)
			.setParameter("nacct", NUMACCT);
			
			 q.executeUpdate();
			 em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public List<HS_ACCT> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
		return em.createQuery("SELECT g FROM HS_ACCT g WHERE TYPEACCT = :r", HS_ACCT.class)
				.setParameter("r", TYPEACCT).getResultList();
	}

	
	public List<HS_ACCT> retrieveByNUMACCT(String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByNUMTAXID(String NUMTAXID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByACTTITLE1(String ACTTITLE1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByACTTITLE2(String ACTTITLE2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByACTTITLE3(String ACTTITLE3) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByACTTITLE4(String ACTTITLE4) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByCITY1(String CITY1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByCITY2(String CITY2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveBySTATE1(String STATE1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveBySTATE2(String STATE2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByZIP1(String ZIP1) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HS_ACCT> retrieveByZIP2(String ZIP2) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		// TODO Auto-generated method stub
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;

	}

}