package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import Entity.*;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private EntityManager em;

    public UserDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    public List<User> searchByEmailandUsername(String email, String username) {
        Query query = em.createQuery("select p from User p where p.email = ?1 or p.username = ?2");
        query.setParameter(1,email);
        query.setParameter(2,username);
        List<User> list = query.getResultList();
        return list;
    }
    
    public User searchById(String id) {
        int userid=Integer.parseInt(id);
        return em.find(User.class, userid);
    }
    
    public List<User> getAllUser() {
        Query query = em.createQuery("SELECT p FROM User p");
        List<User> list = query.getResultList();
        return list;
    }
    
    public List<User> searchByUsername(String username) {
        Query query = em.createQuery("select p from User p where p.username = ?1");
        query.setParameter(1,username);
        List<User> list = query.getResultList();
        return list;
    }
   
    public List<User> login(String user,String password){
        Query query = em.createQuery("select p from User p where p.username= ?1 and p.password = ?2");
        query.setParameter(1,user);
        query.setParameter(2,password); 
        List<User> list = query.getResultList();
        return list;
    }
    public void addUser(User user){
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

    }
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteUser(String id) {
        int userid = Integer.parseInt(id);
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            Query query = em.createQuery("delete from User p where p.id = ?1");
            query.setParameter(1,userid);
            query.executeUpdate();
            trans.commit();
        }catch(Exception ex){
            trans.rollback();
        }
    }
    public boolean isValid(String password) {  
        //return true if and only if password:
        //1. have at least eight characters.
        //2. consists of only letters and digits.
        //3. must contain at least one digits.
        if (password.length() < 8) {   
            return false;  
        } else {      
            char c;  
            int count = 1;   
            for (int i = 0; i < password.length() - 1; i++) {  
                c = password.charAt(i);  
                if (!Character.isLetterOrDigit(c)) {          
                    return false;  
                } else if (Character.isDigit(c)) {  
                    count++;       
                }
                if (count < 1){     
                        return false;  
                    }
            }  
        }  
        return true;  
    }  
    public void close() {
        em.close();
    }
    
}
