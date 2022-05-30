package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import Entity.*;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class OrderDetailDAO {
    private final EntityManager em;

    private static OrderDetailDAO instance;
    
    public static OrderDetailDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new OrderDetailDAO(emf);
        }
        return instance;
    }
    
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
    
    public boolean checkProductExistInOrderDetail(String id){
        int idProduct = Integer.parseInt(id);
        Query query = em.createQuery("select p from Orrderdetail p where p.productId.id = ?1 and p.orderId.status like ?2");
        query.setParameter(1,idProduct);
        query.setParameter(2,"%"+"Chua thanh toan"+"%");
        List<Product> list = query.getResultList();
        return !list.isEmpty();
    }
   
    public void deleteOrderDetail(int orderid){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            Query query = em.createQuery("delete from Orrderdetail p where p.orderId.id = ?1");
            query.setParameter(1,orderid);
            query.executeUpdate();
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    
    public void close() {
        em.close();
    }
}
