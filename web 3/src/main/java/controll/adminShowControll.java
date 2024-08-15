package controll;

import java.io.IOException;
import java.util.List;

import dao.DAO;
import entity.Product;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class adminShowControll extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public adminShowControll() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
        
        // Check if the request is to delete a product
        if ("DELETE".equalsIgnoreCase(request.getParameter("_method"))) {
            doDelete(request, response);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        
        request.setAttribute("productsp", list);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DAO dao = new DAO();
        boolean deleted = dao.deleteProduct(id);
        
        if (deleted) {
            // Redirect to a success page or just set response status
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Redirect to an error page or set appropriate response status
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}