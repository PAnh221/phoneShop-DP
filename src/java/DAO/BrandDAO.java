package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import Entity.*;

public class BrandDAO {
    private EntityManager em;
    public BrandDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public Brand searchById(String id) {
        return em.find(Brand.class, id);
    }
    
    public void updateProduct(Brand brand) {
        em.getTransaction().begin();
        em.merge(brand);
        em.getTransaction().commit();
    }

    public void removeProduct(Brand brand) {
        em.getTransaction().begin();
        em.remove(brand);
        em.getTransaction().commit();
    }
    
    public List<Brand> getAll() {
        Query query = em.createQuery("SELECT p FROM Brand p");
        List<Brand> list = query.getResultList();
        return list;
    }
    
    public void close() {
        em.close();
    }
    
}
