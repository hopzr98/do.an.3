package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kết nối đến cơ sở dữ liệu
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/mobile";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

            // Lấy giá trị tên đăng nhập và mật khẩu từ request
            String username = request.getParameter("username");
            String pass = request.getParameter("password");

            // Kiểm tra đăng nhập cho người dùng
            String userLoginQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(userLoginQuery);
            statement.setString(1, username);
            statement.setString(2, pass);

            resultSet = statement.executeQuery();
         
            if (resultSet.next()) {
                // Lưu tên người dùng vào session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("isLoggedIn", true);

                // Chuyển hướng người dùng đến trang "Home"
                response.sendRedirect("Home");
                return;
            }
            // Kiểm tra đăng nhập cho admin
            String adminname = request.getParameter("username");
            String adminpass = request.getParameter("password");

            String adminLoginQuery = "SELECT * FROM admins WHERE name = ? AND password = ?";
            statement = connection.prepareStatement(adminLoginQuery);
            statement.setString(1, adminname);
            statement.setString(2, adminpass);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Lưu tên admin vào session
                HttpSession session = request.getSession();
                session.setAttribute("name", adminname);
                session.setAttribute("isLoggedIn", true);

                // Chuyển hướng admin đến trang "admin.jsp"
                response.sendRedirect("admin.jsp");
                return;
            }
            else {
            	String errorMessage = "Thông tin đăng nhập không chính xác. Vui lòng thử lại.";
            	request.setAttribute("errorMessage", errorMessage);
            	request.getRequestDispatcher("login.jsp").forward(request, response);
			}
    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và giải phóng tài nguyên
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}