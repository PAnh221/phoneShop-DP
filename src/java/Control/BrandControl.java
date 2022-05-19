package Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

import DAO.*;
import Entity.*;


@WebServlet(name = "BrandControl", urlPatterns = {"/Brand"})
public class BrandControl extends HttpServlet {
    private ProductDAO productDao;
    private BrandDAO brandDao;
    private EntityManager em;
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/it_shop.jsp";
        String tag=request.getParameter("bid");
        
        emf=Persistence.createEntityManagerFactory("Phone_webPU");
        em = emf.createEntityManager();
        productDao = new ProductDAO(emf);
        brandDao = new BrandDAO(emf);
        
        List<Product> listProduct = new ArrayList<Product>();
        listProduct = productDao.getPaging(tag,1);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("indexPage",1);
           
        
        int countPage = productDao.getNumPage(tag);
        request.setAttribute("pageNum", countPage);

        List<Brand> listCategory = new ArrayList<Brand>();
        listCategory = brandDao.getAllBrand();
        request.setAttribute("tag",tag);
        request.setAttribute("listCategory", listCategory);
        
        List<String> listTagSearch = new ArrayList<>();
        listTagSearch.add("Gaming");
        listTagSearch.add("Văn phòng");
        listTagSearch.add("SSD");
        listTagSearch.add("Ram");
        listTagSearch.add("Lenovo");
        request.setAttribute("listTagSearch", listTagSearch);
        
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
