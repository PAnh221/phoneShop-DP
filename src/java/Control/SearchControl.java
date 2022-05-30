package Control;

import Entity.*;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;


@WebServlet(name = "SearchControl", urlPatterns = {"/search"})
public class SearchControl extends HttpServlet {
//    private ProductDAO productDao;
//    private BrandDAO brandDao;
    private EntityManager em;
    private EntityManagerFactory emf;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url="/it_shop.jsp";
        
        String txtsearch=request.getParameter("txt");

        emf=Persistence.createEntityManagerFactory("Phone_webPU");
        em = emf.createEntityManager();
        
        // Singleton Implementation
        ProductDAO productDao = ProductDAO.getInstance(emf);
        BrandDAO brandDao = BrandDAO.getInstance(emf);
        
        
        List<Product> listProductFound = new ArrayList<Product>();
        listProductFound = productDao.searchByNameDetail(txtsearch);
        if(listProductFound.isEmpty()){
            String message="NO RESULTS FOUND";
            String btn="Back Home";
            request.setAttribute("notfoundtxt",message);
            request.setAttribute("btn",btn);
            
            getServletContext()
                .getRequestDispatcher("/notfound.jsp")
                .forward(request, response);
        }
        request.setAttribute("listProduct", listProductFound);
        request.setAttribute("txtsearch",txtsearch);
        
        List<Brand> listCategory = new ArrayList<Brand>();
        listCategory = brandDao.getAllBrand();
        request.setAttribute("listCategory", listCategory);
        
        List<String> listTagSearch = new ArrayList<>();
        listTagSearch.add("Gaming");
        listTagSearch.add("Văn phòng");
        listTagSearch.add("SSD");
        listTagSearch.add("Ram");
        listTagSearch.add("Lenovo");
        
        request.setAttribute("listTagSearch", listTagSearch);
        request.setAttribute("tagsearch", txtsearch);
        
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
