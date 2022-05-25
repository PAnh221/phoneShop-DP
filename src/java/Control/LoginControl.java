
package Control;

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


@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
    private UserDAO userDao;
    private EntityManager em;
    private EntityManagerFactory emf;
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url="";
        String page = request.getParameter("page");
        
        if(page==null){
            url="/Home";
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        if("login-form".equals(page)){
            String username=request.getParameter("username");
            String password=request.getParameter("password");

            emf=Persistence.createEntityManagerFactory("Phone_webPU");
            em = emf.createEntityManager();
            userDao = new UserDAO(emf);
                
            List<User> listUser = new ArrayList<User>();
            listUser=userDao.login(username, password);
            if(!listUser.isEmpty()){             
                
                User user = listUser.get(0);
                if(user.getPermission() == 0){
                    url="/Home";
                }else{
                    url="/manageorder?action=show";
                }
                
                session = request.getSession();
                session.setAttribute("session", session);
                session.setAttribute("permission", user.getPermission());
                session.setAttribute("username", username);
                
            }
            else{
                url="/it_login.jsp";
                request.setAttribute("msg", "WRONG USERNAME OR PASSWORD!");
                request.setAttribute("username",username);
                
            }
            
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
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
