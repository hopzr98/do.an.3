package controll;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import context.DBContext;
import dao.DAO;
import entity.Category;
import entity.Product;
import entity.User;

@WebServlet("/Home")
public class HomeControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeControll() {
        super();

    }
	public void init(ServletConfig config) throws ServletException {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		boolean isLoggedIn = checkLoginStatus(request);
		 
		 if (isLoggedIn) {
			String action = request.getParameter("action");
			if (action == null) {
	            action = "list1";
			}
			switch(action) {

				default:
					home(request, response);
					break;
			} 
		 } else {
		        // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
			 String action = request.getParameter("action");
		        if (action == null) {
		            action = "list1";
		        }
		        switch(action) {
		            case "customer":
		            	customer(request,response);
		            	break;
		            default:
		                home(request, response);
		                break;
		        }
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    boolean authenticated = authenticate(username, password);

	    if (authenticated) {
	        // Lưu thông tin người dùng vào session
	        HttpSession session = request.getSession();
	        session.setAttribute("username", username);
	        session.setAttribute("isLoggedIn", true);

	        // Lấy giá trị id từ cơ sở dữ liệu dựa trên username và lưu vào session
	        DAO userDAO = new DAO();
	        String id = userDAO.getUserIdByUsername(username);
	        session.setAttribute("id", id);

	        // Chuyển hướng đến trang "Home.jsp"
	        response.sendRedirect("Home");
	    } else {
	        // Xử lý khi xác thực không thành công
	        request.setAttribute("loginError", "Tên người dùng hoặc mật khẩu không chính xác.");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
	        dispatcher.forward(request, response);
	    }
	}
	private void home(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		List<Category> listC = dao.getCategory();
		List<Product> top = dao.getTop1();
		
		request.setAttribute("listP", list);
		request.setAttribute("Top1", top);
		request.setAttribute("ListC", listC);
		///Lam tiep
		DAO cate = new DAO();
//		List<Product> cid = cate.getProductsByCategoryId(0);
//		request.setAttribute("Cate", cid);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}
	protected void customer(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		String id = request.getParameter("userId");
		DAO dao = new DAO();
		
		User user = dao.getUser(id);
		request.setAttribute("User", user);
		request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
	}
	protected void customerID(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
	}
	private boolean checkLoginStatus(HttpServletRequest request) {
		 
	    HttpSession session = request.getSession();
	    String id = (String) session.getAttribute("id");
	    String username = (String) session.getAttribute("username");
	    return username != null && id != null; 
	}
	private boolean authenticate(String username, String password) {
	    Connection conn = null;
	    try {
	        conn = DBContext.getConnection();

	        return true; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return false; // Trả về false nếu thông tin đăng nhập không hợp lệ
	}
}