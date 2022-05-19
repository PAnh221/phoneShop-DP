package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import Entity.*;
import javax.persistence.EntityTransaction;

public class BrandDAO {
    private EntityManager em;
    public BrandDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public List<Brand> getAllBrand() {
        Query query = em.createQuery("SELECT p FROM Brand p");
        List<Brand> list = query.getResultList();
        return list;
    }
    
    public Brand searchById(String id) {
        int bid=Integer.parseInt(id);
        return em.find(Brand.class, bid);
    }
    
    public void addNewBrand(Brand brand){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(brand);
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    
    public void updateBrand(Brand brand) {
        em.getTransaction().begin();
        em.merge(brand);
        em.getTransaction().commit();
    }

    
    public void deleteBrand(String id){
        int bid = Integer.parseInt(id);
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            Query query = em.createQuery("delete from Brand p where p.id = ?1");
            query.setParameter(1,bid);
            query.executeUpdate();
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
     
    public boolean checkExistBrand(String name){
        Query query = em.createQuery("select p from Brand p where p.name = ?1");
        query.setParameter(1,name);
        List<Brand> list = query.getResultList();
        return !list.isEmpty();
    }
    
    public void close() {
        em.close();
    }
    
}
