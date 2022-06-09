/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Template;

import Entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admins
 */
public class UpdateProduct extends ExecuteQuery { 
    private final EntityManager em;
    private Product product;
    
    // Tạo constructor UpdateProduct giá trị truyền vào là Product
    public UpdateProduct (EntityManagerFactory emf, Product product)
    {
        em = emf.createEntityManager();
	this.product = product;
    }

    @Override
    void begin() {
        em.getTransaction().begin();
    }
 
    @Override
    void query() {
        em.merge(product);
    }
 
    @Override
    void commit() {
        em.getTransaction().commit();
    }
}
