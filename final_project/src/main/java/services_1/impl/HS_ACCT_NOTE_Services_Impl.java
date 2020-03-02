package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_NOTE;
import services_1.HS_ACCT_NOTE_Services;
import utils.DAOException;

public class HS_ACCT_NOTE_Services_Impl implements HS_ACCT_NOTE_Services 
{

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_NOTE_Services_Impl(EntityManager em) 
	{   
		//should super(); be here?
		this.em = em;
	}

	public void create(HS_ACCT_NOTE acct) throws DAOException 
	{
		EntityTransaction et = em.getTransaction();
		try 
		{
			et.begin();
			em.persist(acct);
			et.commit();
		} catch (Exception e) 
		{
			et.rollback();
		}
	}

	public void update(HS_ACCT_NOTE acct) throws DAOException 
	{
		try
		{
			em.getTransaction().begin();
			em.merge(acct);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void delete(String REGIONID, String TYPEACCT, String NUMACCT) throws DAOException 
	{
		try
		{
			em.getTransaction().begin();
			Query q = em
					  .createQuery("DELETE FROM HS_ACCT_NOTE AS g WHERE g.REGIONID =: rid AND g.TYPEACCT = :tacct "
					   + "AND g.NUMACCT = :nacct")
					   .setParameter("rid", REGIONID)
					   .setParameter("tacct", TYPEACCT)
					   .setParameter("nacct", NUMACCT);

					  q.executeUpdate();
					  em.getTransaction().commit();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public List<HS_ACCT_NOTE> retrieveByREGIONID(String REGIONID) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_NOTE g WHERE REGIONID = :r", HS_ACCT_NOTE.class)
				.setParameter("r", REGIONID).getResultList();
	}

	public List<HS_ACCT_NOTE> retrieveByTYPEACCT(String TYPEACCT) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_NOTE g WHERE TYPEACCT = :r", HS_ACCT_NOTE.class)
				.setParameter("r", TYPEACCT).getResultList();
	}

	public List<HS_ACCT_NOTE> retrieveByNUMACCT(String NUMACCT) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_NOTE g WHERE NUMACCT = :r", HS_ACCT_NOTE.class)
				.setParameter("r", NUMACCT).getResultList();
	}

	public Long count() throws DAOException 
	{
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_NOTE g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
