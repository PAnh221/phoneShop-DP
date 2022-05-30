package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import Entity.*;
import javax.persistence.EntityTransaction;

public class CartDAO {
    private EntityManager em;
    
    private static CartDAO instance;
    
    public static CartDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new CartDAO(emf);
        }
        return instance;
    }

    public CartDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    public boolean check(String pid,int userid){
        int ppid = Integer.parseInt(pid);
        Query query = em.createQuery("select p from Cart p where p.userId.id = ?1 and p.productId.id = ?2");
        query.setParameter(1,userid);
        query.setParameter(2,ppid); 
        List<User> list = query.getResultList();
        return !list.isEmpty();
    }
    public void addToCart(Cart cart){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(cart);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    public void deleteCart(int userid){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            Query query = em.createQuery("delete from Cart p where p.userId.id = ?1");
            query.setParameter(1,userid);
            query.executeUpdate();
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    public void deleteProductToCart(String pid,int userid){
        int ppid = Integer.parseInt(pid);
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            Query query = em.createQuery("delete from Cart p where p.userId.id = ?1 and p.productId.id = ?2");
            query.setParameter(1,userid);
            query.setParameter(2,ppid);
            query.executeUpdate();
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    
    public void updateProductToCart(Cart cart){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.merge(cart);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    
    public List<Cart> findFromCart(String pid,int userid){
        int ppid = Integer.parseInt(pid);
        Query query = em.createQuery("select p from Cart p where p.userId.id = ?1 and p.productId.id = ?2");
        query.setParameter(1,userid);
        query.setParameter(2,ppid);
        List<Cart> list = query.getResultList();
        return list;
    }
    public List<Cart> getFromCart(int userid){
        Query query = em.createQuery("select p from Cart p where p.userId.id = ?1");
        query.setParameter(1,userid);
        List<Cart> list = query.getResultList();
        return list;
    }
    
    public boolean checkProductExistInCart(String id){
        int idProduct = Integer.parseInt(id);
        Query query = em.createQuery("select p from Cart p where p.productId.id = ?1");
        query.setParameter(1,idProduct);
        List<Product> list = query.getResultList();
        return !list.isEmpty();
    }
    
    public boolean checkUserExistInCart(String id){
        int idUser = Integer.parseInt(id);
        Query query = em.createQuery("select p from Cart p where p.userId.id = ?1");
        query.setParameter(1,idUser);
        List<Product> list = query.getResultList();
        return !list.isEmpty();
    }
    
    public void close() {
        em.close();
    }
}
