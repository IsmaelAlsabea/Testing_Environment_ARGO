package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_CUST;
import services_1.HS_ACCT_CUST_Services;
import utils.DAOException;

public class HS_ACCT_CUST_Services_Impl implements HS_ACCT_CUST_Services 
{

	@PersistenceContext
	private EntityManager em;
	
	
	public HS_ACCT_CUST_Services_Impl(EntityManager em) 
	{
		super();
		this.em = em;
	}

	public void create(HS_ACCT_CUST acct) throws DAOException 
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


	public void update(HS_ACCT_CUST acct) throws DAOException 
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

	public void delete(String NUMBANK, String TYPECUST, String CIF) throws DAOException 
	{
		try
		{
			em.getTransaction().begin();

			Query q = em
						.createQuery("Delete from HS_ACCT_CUST as g where g.NUMBANK = :nb and g.TYPECUST =:tcust " + "AND g.CIF =: cif")
						.setParameter("nb", NUMBANK)
						.setParameter("tcust", TYPECUST)
						.setParameter("cif", CIF);

						q.executeUpdate();
						em.getTransaction().commit();				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public List<HS_ACCT_CUST> retrieveByTYPECUST(String TYPECUST) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE TYPECUST = :r",HS_ACCT_CUST.class)
				 .setParameter("r", TYPECUST).getResultList();
		
	}

	public List<HS_ACCT_CUST> retrieveByCIF(String CIF) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE CIF = :r",HS_ACCT_CUST.class)
				 .setParameter("r", CIF).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByNAMFULL(String NAMFULL) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE NAMFULL = :r",HS_ACCT_CUST.class)
				 .setParameter("r", NAMFULL).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByNUMTAXID(String NUMTAXID) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE NUMTAXID = :r",HS_ACCT_CUST.class)
				 .setParameter("r", NUMTAXID).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByCITY1(String CITY1) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE CITY1 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", CITY1).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByCITY2(String CITY2) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE CITY2 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", CITY2).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByCITY3(String CITY3) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE CITY3 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", CITY3).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByCITY4(String CITY4) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE CITY4 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", CITY4).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveBySTATE1(String STATE1) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE STATE1 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", STATE1).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveBySTATE2(String STATE2) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE STATE2 = :r",HS_ACCT_CUST.class)
		.setParameter("r", STATE2).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveBySTATE3(String STATE3) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE STATE3 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", STATE3).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveBySTATE4(String STATE4) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE STATE4 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", STATE4).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByZIP1(String ZIP1) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE ZIP1 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", ZIP1).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByZIP2(String ZIP2) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE ZIP2 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", ZIP2).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByZIP3(String ZIP3) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE ZIP3 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", ZIP3).getResultList();
	}

	public List<HS_ACCT_CUST> retrieveByZIP4(String ZIP4) throws DAOException 
	{
		return em.createQuery("Select g from HS_ACCT_CUST g WHERE ZIP4 = :r",HS_ACCT_CUST.class)
				 .setParameter("r", ZIP4).getResultList();
	}
	
	public Long count() throws DAOException 
	{
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_CUST g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

}
