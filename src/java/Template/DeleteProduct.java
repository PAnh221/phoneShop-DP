/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Template;

import Entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Admins
 */
public class DeleteProduct extends ExecuteQuery { 
    private final EntityManager em;
    private int proId;
    
    public DeleteProduct (EntityManagerFactory emf, String proId)
    {
        em = emf.createEntityManager();
	this.proId = Integer.parseInt(proId);
    }

    @Override
    void begin() {
        em.getTransaction().begin();
    }
 
    @Override
    void query() {
        Query query = em.createQuery("delete from Product p where p.id = ?1");
        query.setParameter(1, proId);
        query.executeUpdate();
    }
 
    @Override
    void commit() {
        em.getTransaction().commit();
    }
}
