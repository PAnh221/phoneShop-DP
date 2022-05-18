package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import Entity.*;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class OrderDetailDAO {
    private final EntityManager em;

    public OrderDetailDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public List<Orrderdetail> getAllOrderDetail(String id) {
        int order_id=Integer.parseInt(id);
        Query query = em.createQuery("SELECT p FROM Orrderdetail p WHERE p.orderId.id = ?1");
        query.setParameter(1,order_id);
        List<Orrderdetail> list = query.getResultList();
        return list;
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
