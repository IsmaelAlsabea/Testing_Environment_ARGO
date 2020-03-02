package services_1.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities_1.HS_ACCT_HOLD;
import services_1.HS_ACCT_HOLD_Services;
import utils.DAOException;

public class HS_ACCT_HOLD_Services_Impl implements HS_ACCT_HOLD_Services {

    @PersistenceContext
    private EntityManager em;

    /*
        Default constructor
    */

    public HS_ACCT_HOLD_Services_Impl(EntityManager em) {
            super();
            this.em = em;
    }
    
    /*
        Create HS_ACCT_HOLD Account
    */

    public void create(HS_ACCT_HOLD acct) throws DAOException {
        
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(acct);
            et.commit();
        } 
        catch (Exception e) {
            et.rollback();
        }

    }
    
    /*
        Update HS_ACCT_HOLD Account
    */

    public void update(HS_ACCT_HOLD acct) throws DAOException {
        
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
    
    /*
        Delete HS_ACCT_HOLD Account
    */

    public void delete(String NUMBANK, String TYPEACCT, String NUMACCT, 
                       String IDHOLD) throws DAOException {
        
        try {
            em.getTransaction().begin();

            Query q = em
                        .createQuery("DELETE FROM HS_ACCT_HOLD AS g WHERE "
                                   + "g.NUMBANK = :nb "
                                   + "AND g.TYPEACCT = :tacct "
                                   + "AND g.NUMACCT = :nacct "
                                   + "AND g.IDHOLD = :idh")        
                        .setParameter("nb", NUMBANK)
                        .setParameter("tacct", TYPEACCT)
                        .setParameter("nacct", NUMACCT)
                        .setParameter("idh", IDHOLD);

             q.executeUpdate();
             em.getTransaction().commit();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }

    }
    
    /*
        Retrieve HS_ACCT_HOLD Accounts
    */

    public List<HS_ACCT_HOLD> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_HOLD g "
                            + "WHERE TYPEACCT = :r", HS_ACCT_HOLD.class)
                            .setParameter("r", TYPEACCT).getResultList();
    }

    public List<HS_ACCT_HOLD> retrieveByNUMACCT(String NUMACCT) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_HOLD g "
                            + "WHERE NUMACCT = :r", HS_ACCT_HOLD.class)
                            .setParameter("r", NUMACCT).getResultList();
    }

    public List<HS_ACCT_HOLD> retrieveByIDHOLD(String IDHOLD) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_HOLD g "
                            + "WHERE IDHOLD = :r", HS_ACCT_HOLD.class)
                            .setParameter("r", IDHOLD).getResultList();
    }
    
    /*
        Count HS_ACCT_HOLD Accounts
    */

    public Long count() throws DAOException {
        TypedQuery <Long> q= em.createQuery("SELECT COUNT (g) FROM HS_ACCT_HOLD g", Long.class);
        Long size=(Long) q.getSingleResult();
        return size;
    }
}
