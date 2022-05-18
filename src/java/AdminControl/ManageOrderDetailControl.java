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

@WebServlet(name = "ManageOrderDetailControl", urlPatterns = {"/ManageOrderDetail"})
public class ManageOrderDetailControl extends HttpServlet {
    private OrderDetailDAO orderDetailDao;
    
    private EntityManager em;
    private EntityManagerFactory emf;
    //HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String order_id = request.getParameter("orderId");
       
       emf=Persistence.createEntityManagerFactory("Phone_webPU");
       em = emf.createEntityManager();
       orderDetailDao = new OrderDetailDAO(emf);
       
       List<Orrderdetail> listOrderDetail = new ArrayList<Orrderdetail>();
       listOrderDetail = orderDetailDao.getAllOrderDetail(order_id);
       
       request.setAttribute("listOrderDetail", listOrderDetail);
       request.setAttribute("IdOrder", order_id);
        
        getServletContext()
                    .getRequestDispatcher("/admin/orderdetail.jsp")
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
