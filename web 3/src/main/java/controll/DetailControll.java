package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.DAO;
import entity.Category;
import entity.Gift;
import entity.News;
import entity.Product;
import entity.ProductDetails;

@WebServlet("/detail")
public class DetailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailControll() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
//		gift(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
//		gift(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");
	    DAO dao = new DAO();
	    
	    String id = request.getParameter("pid");
	    Product p = dao.getProductByID(id);
	    List<Gift> gifts = dao.getAllGift(id);
	    List<News> news = dao.getNews();
	    List<ProductDetails> detail = dao.getAllDetails(id);
	    
	    request.setAttribute("de", detail);
	    request.setAttribute("newss", news);
	    request.setAttribute("detail", p);
	    request.setAttribute("gift", gifts);
	    request.getRequestDispatcher("san-pham.jsp").forward(request, response);
	}

}
