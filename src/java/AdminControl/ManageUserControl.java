/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminControl;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import DAO.*;
import Entity.*;
import Stategy.ConcreteStrategyAddUser;
import Stategy.ConcreteStrategyDeleteUser;
import Stategy.ConcreteStrategyEditUser;
import Stategy.UserManageContext;
import java.util.Date;

@WebServlet(name = "ManageUserControl", urlPatterns = {"/manageuser"})
public class ManageUserControl extends HttpServlet {    
    private UserDAO userDao;
    private CartDAO cartDao;
    private OrdersDAO orderDao;
    
    private EntityManager em;
    private EntityManagerFactory emf;
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url="";
        String action = request.getParameter("action");
        String idUser = request.getParameter("userId");
        String name = request.getParameter("Name");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");
        String permission = request.getParameter("Permission");
        Date registerDate = new Date();

        emf=Persistence.createEntityManagerFactory("Phone_webPU");
        em = emf.createEntityManager();
        userDao = new UserDAO(emf);
        cartDao = new CartDAO(emf);
        orderDao = new OrdersDAO(emf);
        
        if(action.equals("")){
            action="show";
        }
        
        if(action.equals("show")){       
            List<User> listUser = new ArrayList<User>();
            listUser = userDao.getAllUser();
            request.setAttribute("listUser", listUser);
            url="/admin/user.jsp";
        }
        else if(action.equals("showadd")){
            url="/admin/insertuser.jsp";
        }
        else if(action.equals("add")){       
            List<User> listCustomer = new ArrayList<User>();
            listCustomer=userDao.searchByEmailandUsername(email,username);
            if(!listCustomer.isEmpty()){
                request.setAttribute("errorMessage", "This email" + email+" or Username "+username+" has been use!");
                url="/manageuser?action=showadd";
            }
            else if(!userDao.isValid(password)){
                request.setAttribute("errorMessage", "Password must contain at least one digits and have at least eight characters!");
                url="/manageuser?action=showadd";
            }
            else{
                int role =0;
                if(permission.equals("2")){
                    role =1;
                }
                
                User user = new User();
                user.setName(name);
                user.setAddress(address);
                user.setUsername(username);
                user.setPassword(password);
                user.setPermission(role);
                user.setEmail(email);
                user.setPhone(phone);
                user.setRegisterdate(registerDate);
                
//                userDao.addUser(user);

                // Strategy implementation
                UserManageContext context = new UserManageContext();
                context.setStrategy(new ConcreteStrategyAddUser());
                context.execute(user);
                //

                request.setAttribute("Message", "Added New User Successed");
                url="/manageuser?action=show";
            }
        }
        else if(action.equals("delete")){
            if(cartDao.checkUserExistInCart(idUser) || orderDao.checkUserExistOrders(Integer.parseInt(idUser)) ||
                    idUser.isEmpty() || idUser.isBlank()){
                request.setAttribute("Message", "You Can't Delete This User");
            }
            else{
//                userDao.deleteUser(idUser);

                User user1 = new User();
                user1.setId(Integer.parseInt(idUser));
                // Strategy implementation
                UserManageContext context = new UserManageContext();
                context.setStrategy(new ConcreteStrategyDeleteUser());
                context.execute(user1);
                //

                request.setAttribute("Message", "Delete User Successed");
            }
            url="/manageuser?action=show";
        }
        else if(action.equals("showupdate")){
            User user = userDao.searchById(idUser);
            request.setAttribute("userInfo", user);
            
            url="/admin/updateuser.jsp";
        }
        else if(action.equals("confirmupdate")){
            int role =0;
            if(permission.equals("2")){
                role =1;
            }
            
            User user = userDao.searchById(idUser);
            
            user.setName(name);
            user.setAddress(address);
            user.setUsername(username);
            user.setPassword(password);
            user.setPermission(role);
            user.setEmail(email);
            user.setPhone(phone);
            
//            userDao.updateUser(user);

            // Strategy implementation
            UserManageContext context = new UserManageContext();
            context.setStrategy(new ConcreteStrategyEditUser());
            context.execute(user);
            //
            
            request.setAttribute("Message", "Update User Successed");
            url="/manageuser?action=show";
        }
        else if(action.equals("cancel")){
            url="/manageuser?action=show";
        }
        
        getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
