package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_STOP;
import services_1.HS_ACCT_STOP_Services;
import utils.DAOException;

public class HS_ACCT_STOP_Services_Impl implements HS_ACCT_STOP_Services {

	@PersistenceContext
	private EntityManager em;

	public HS_ACCT_STOP_Services_Impl(EntityManager em) 
	{
		super();
		this.em = em;
	}

	public void create(HS_ACCT_STOP acct) throws DAOException 
	{
		EntityTransaction et = em.getTransaction();
		try
		{
			et.begin();
			em.persist(acct);
			et.commit();
		}
		catch(Exception ex)
		{
			et.rollback();
		}

	}

	
	public void update(HS_ACCT_STOP acct) throws DAOException 
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

	public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, String IDSTOP) throws DAOException 
	{
		try
		{
			em.getTransaction().begin();

			Query q = em
					  .createQuery("DELETE FROM HS_ACCT_STOP as g.NUMBANK = :nb AND g.TYPEACCT =: tacct " 
					  + "AND g.NUMACCT =: nacct AND g.IDSTOP =: istop")
					  .setParameter("nb", NUMBANK)
					  .setParameter("tacct", TYPEACCT)
					  .setParameter("nacct", NUMACCT)
					  .setParameter("istop", IDSTOP);

					  q.executeUpdate();
					  em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public List<HS_ACCT_STOP> retrieve(String NUMBANK, String TYPEACCT, String NUMACCT, String IDSTOP) throws DAOException
    {
		return em.createQuery("SELECT FROM HS_ACCT_STOP as g.NUMBANK = :nb AND g.TYPEACCT =: tacct " 
		+ "AND g.NUMACCT =: nacct AND g.IDSTOP =: istop",HS_ACCT_STOP.class)
		.setParameter("nb", NUMBANK)
		.setParameter("tacct", TYPEACCT)
		.setParameter("nacct", NUMACCT)
		.setParameter("istop", IDSTOP).getResultList();
	}


	public List<HS_ACCT_STOP> retrieveByTYPEACCT(String TYPEACCT) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_STOP g WHERE TYPEACCT = :r", HS_ACCT_STOP.class)
				.setParameter("r", TYPEACCT).getResultList();
	}

	public List<HS_ACCT_STOP> retrieveByNUMACCT(String NUMACCT) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_STOP g WHERE NUMACCT = :r", HS_ACCT_STOP.class)
				.setParameter("r", NUMACCT).getResultList();
	}

	public List<HS_ACCT_STOP> retrieveByIDSTOP(String IDSTOP) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_STOP g WHERE IDSTOP = :r", HS_ACCT_STOP.class)
				.setParameter("r", IDSTOP).getResultList();
	}

	public List<HS_ACCT_STOP> retrieveByREGIONID(String REGIONID) throws DAOException 
	{
		return em.createQuery("SELECT g FROM HS_ACCT_STOP g WHERE REGIONID = :r", HS_ACCT_STOP.class)
				.setParameter("r", REGIONID).getResultList();
	}

	public Long count() throws DAOException 
	{
		// TODO Auto-generated method stub
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_STOP g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
