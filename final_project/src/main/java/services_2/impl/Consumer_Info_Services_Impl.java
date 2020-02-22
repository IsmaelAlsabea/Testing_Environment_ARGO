package services_2.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities_2.ConsumerInfo;
import services_2.Consumer_Info_Services;
import utils.DAOException;

public class Consumer_Info_Services_Impl implements Consumer_Info_Services{

	@PersistenceContext
	private EntityManager em;
	
	
	public Consumer_Info_Services_Impl(EntityManager em) {
		super();
		this.em = em;
	}

	public List<ConsumerInfo> retrieve(int ID) {	
		return em.createQuery("select gp from ConsumerInfo gp where ID = :p ",
                    		ConsumerInfo.class).setParameter("p", ID).getResultList();
	}

	public List<ConsumerInfo> retrieveByCustomerType(String CustomerType) throws DAOException {
		return em.createQuery("SELECT g FROM ConsumerInfo g WHERE CustomerType = :ct", ConsumerInfo.class)
				.setParameter("ct", CustomerType).getResultList();
	}

	public List<ConsumerInfo> retrieveByLastName(String LastName) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByTaxIdNumber(String TaxIdNumber) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByCity(String City) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByState(String State) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByZIPCode(String ZIPCode) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveBySpecUse(String SpecUse) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByCIF(String CIF) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByPEP(String PEP) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ConsumerInfo> retrieveByConsumerID(String ConsumerID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() throws DAOException {
		// TODO Auto-generated method stub
		TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM ConsumerInfo g", Long.class);
    	Long size=(Long) q.getSingleResult();
    	return size;
	}

	
	
}
