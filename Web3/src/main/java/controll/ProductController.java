package controll;

import java.io.IOException;

import dao.DAO;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		 processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
		
		DAO dao = new DAO();
		int id = Integer.parseInt(request.getParameter("productId"));
		Product product = dao.getProductByID(id);
		if (product == null)
			response.sendRedirect(request.getRequestURI());
		String name = request.getParameter("productName");
		double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
		double oldPrice = Double.parseDouble(request.getParameter("oldPrice"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String cate = request.getParameter("productCategoryPath");
		
		try {
			dao.updateProduct(id, name, cate, unitPrice, oldPrice, quantity);
			response.sendRedirect(request.getContextPath() + "/admin");
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect(request.getRequestURI());
		}
		
//		DAO dao = new DAO();
////	    int id = Integer.parseInt(request.getParameter("id"));
//	    String productName = request.getParameter("productName");
//	    String productCategoryPath = request.getParameter("productCategoryPath");
//	    String img = request.getParameter("img");
//	    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
//	    double oldPrice = Double.parseDouble(request.getParameter("oldPrice"));
//	    int cid = Integer.parseInt(request.getParameter("cid"));
//	    int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//	    dao.addProduct( productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity);
//	    response.sendRedirect(request.getContextPath() + "/add-product.jsp");
//	    
//	    // loading lại trang product
////	    processRequest(request, response);
    }
	
	

}