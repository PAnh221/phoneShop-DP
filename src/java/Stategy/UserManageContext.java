/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stategy;

import Entity.User;

/**
 *
 * @author Admins
 */
public class UserManageContext {
    private UserManageStrategy userManageStrategy;
    
    public void setStrategy(UserManageStrategy userManageStrategy) {
        this.userManageStrategy = userManageStrategy;
    }
    
    public void execute(User user) {
        userManageStrategy.execute(user);
    }
    
}
