package hs_services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hs_entities.HS_ACCT_NOTE;
import hs_services.HS_ACCT_NOTE_Services;
import utils.DAOException;

public class HS_ACCT_NOTE_Services_Impl implements HS_ACCT_NOTE_Services {

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_NOTE_Services_Impl(EntityManager em) {
		this.em = em;
	}

	public void create(HS_ACCT_NOTE acct) throws DAOException {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(acct);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void update(HS_ACCT_NOTE acct) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(String REGIONID, String TYPEACCT, String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub

	}

	public List<HS_ACCT_NOTE> retrieveByREGIONID(String REGIONID) throws DAOException {
		return em.createQuery("SELECT g FROM HS_ACCT_NOTE g WHERE REGIONID = :r", HS_ACCT_NOTE.class)
				.setParameter("r", REGIONID).getResultList();
	}

	public List<HS_ACCT_NOTE> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
		return em.createQuery("SELECT g FROM HS_ACCT_NOTE g WHERE TYPEACCT = :r", HS_ACCT_NOTE.class)
				.setParameter("r", TYPEACCT).getResultList();
	}

	public List<HS_ACCT_NOTE> retrieveByNUMACCT(String NUMACCT) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_NOTE g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
