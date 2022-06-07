/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stategy;

import DAO.UserDAO;
import Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Admins
 */
public class ConcreteStrategyDeleteUser implements UserManageStrategy{
    private EntityManager em;
    private EntityManagerFactory emf;

    @Override
    public void execute(User user) {
        emf = Persistence.createEntityManagerFactory("Phone_webPU");
        em = emf.createEntityManager();
        
        // Singleton
        UserDAO userDao = UserDAO.getInstance(emf);
        userDao.deleteUser(user.getId().toString());
    }
}
