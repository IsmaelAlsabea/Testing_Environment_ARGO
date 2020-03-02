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
    
    /*
        Default constructor
    */

    public HS_ACCT_CUAC_Services_Impl(EntityManager em) {
            super();
            this.em = em;
    }

    /*
        Create HS_ACCT_CUAC Account
    */

    public void create(HS_ACCT_CUAC acct) throws DAOException {

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
        Update HS_ACCT_CUAC Account
    */

    public void update(HS_ACCT_CUAC acct) throws DAOException {
            
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
        Delete HS_ACCT_CUAC Account
    */

    public void delete(String CUSTBANK, String TYPECUST, String CIF, 
                       String NUMBANK, String TYPEACCT, String NUMACCT)
                       throws DAOException {
      
        try {
            em.getTransaction().begin();

            Query q = em
                        .createQuery("DELETE FROM HS_ACCT_CUAC AS g WHERE "
                                   + "g.CUSTBANK = :cb "
                                   + "AND g.TYPECUST = :tc "
                                   + "AND g.CIF = :cif "
                                   + "AND g.NUMBANK = :nb "
                                   + "AND g.TYPEACCT = :tacct "
                                   + "AND g.NUMACCT= :nacct")
                        .setParameter("cb", CUSTBANK)
                        .setParameter("tc", TYPECUST)
                        .setParameter("cif", CIF)          
                        .setParameter("nb", NUMBANK)
                        .setParameter("tacct", TYPEACCT)
                        .setParameter("nacct", NUMACCT);

             q.executeUpdate();
             em.getTransaction().commit();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    /*
        Retrieve HS_ACCT_CUAC Accounts
    */

    public List<HS_ACCT_CUAC> retrieveByTYPECUST(String TYPECUST) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_CUAC g "
                            + "WHERE TYPECUST = :r", HS_ACCT_CUAC.class)
                            .setParameter("r", TYPECUST).getResultList();
    }

    public List<HS_ACCT_CUAC> retrieveByCIF(String CIF) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_CUAC g "
                            + "WHERE CIF = :r", HS_ACCT_CUAC.class)
                            .setParameter("r", CIF).getResultList();
    }

    public List<HS_ACCT_CUAC> retrieveByTYPEACCT(String TYPEACCT) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_CUAC g "
                            + "WHERE TYPEACCT = :r", HS_ACCT_CUAC.class)
                            .setParameter("r", TYPEACCT).getResultList();
    }

    public List<HS_ACCT_CUAC> retrieveByNUMACCT(String NUMACCT) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_CUAC g "
                            + "WHERE NUMACCT = :r", HS_ACCT_CUAC.class)
                            .setParameter("r", NUMACCT).getResultList();
    }

    public List<HS_ACCT_CUAC> retrieveBySTATE2(String STATE2) throws DAOException {
            
        return em.createQuery("SELECT g FROM HS_ACCT_CUAC g "
                            + "WHERE STATE2 = :r", HS_ACCT_CUAC.class)
                            .setParameter("r", STATE2).getResultList();
    }
    
    /*
        Count HS_ACCT_CUAC Accounts
    */

    public Long count() throws DAOException {
        TypedQuery <Long> q = em.createQuery("SELECT COUNT (g) FROM HS_ACCT_CUAC g", Long.class);
        Long size=(Long) q.getSingleResult();
        return size;
    }

}
