package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import Entity.*;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class OrderDetailDAO {
    private final EntityManager em;

    public OrderDetailDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public void addToOrderDetail(Orrderdetail detail){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(detail);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
   
    
    public void close() {
        em.close();
    }
}
