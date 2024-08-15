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
import entity.Product;

@WebServlet("/category")
public class CategoryControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryControll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
		
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String cateID = request.getParameter("id");
		
		DAO dao = new DAO();
		List<Product> list = dao.getProductByCateID(cateID);
		List<Category> listC = dao.getCategory();
		List<Product> top = dao.getTop1();
		
		request.setAttribute("listP", list);
		request.setAttribute("Top1", top);
		request.setAttribute("ListC", listC);
		request.setAttribute("tag", cateID);

		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
}
