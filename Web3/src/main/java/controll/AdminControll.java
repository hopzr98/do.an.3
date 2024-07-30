package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import context.DBContext;
import dao.DAO;
import entity.Category;
import entity.Product;

@WebServlet("/addProduct")
public class AdminControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminControll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		 processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
        
		DAO dao = new DAO();
//	    int id = Integer.parseInt(request.getParameter("id"));
	    String productName = request.getParameter("productName");
	    String productCategoryPath = request.getParameter("productCategoryPath");
	    String img = request.getParameter("img");
	    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
	    double oldPrice = Double.parseDouble(request.getParameter("oldPrice"));
	    int cid = Integer.parseInt(request.getParameter("cid"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    dao.addProduct( productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity);
	    response.sendRedirect(request.getContextPath() + "/add-product.jsp");
	    
	    // loading lại trang product
//	    processRequest(request, response);
    }
	
	

}