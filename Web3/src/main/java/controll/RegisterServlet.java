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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Kiểm tra xem các trường có được cung cấp hay không
        if (username != null && password != null) {
            // Kết nối tới cơ sở dữ liệu
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String dbURL = "jdbc:mysql://localhost:3306/mobile";
                String dbUsername = "root";
                String dbPassword = "root";
                conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                // Kiểm tra xTrong phần tiếp theo của mã servlet, bạn sẽ thấy phần logic kiểm tra xem tên đăng nhập đã tồn tại trong cơ sở dữ liệu hay chưa và phần thêm người dùng mới vào cơ sở dữ liệu. Bạn có thể tiếp tục viết mã này trong servlet "RegisterServlet":

                // Kiểm tra xem tên đăng nhập đã tồn tại trong cơ sở dữ liệu hay chưa
                String checkUsernameQuery = "SELECT COUNT(*) FROM users WHERE username = ?;";
                stmt = conn.prepareStatement(checkUsernameQuery);
                stmt.setString(1, username);
                ResultSet resultSet = stmt.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count > 0) {
                    response.getWriter().println("<p class=\"error-message\">Tên đăng nhập đã được sử dụng. Vui lòng chọn tên đăng nhập khác.</p>");
                } else {
                    String insertUserQuery = "INSERT INTO users (`username`, `password`) VALUES (?, ?)";
                    stmt = conn.prepareStatement(insertUserQuery);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected > 0) {
                    	HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("isLoggedIn", true);
                        response.sendRedirect("customers.jsp");
                        // response.getWriter().println("<p>Đăng ký thành công!</p>");
                    } else {
                        response.getWriter().println("<p class=\"error-message\">Đăng ký không thành công. Vui lòng thử lại sau.</p>");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("<p class=\"error-message\">Đăng ký không thành công. Vui lòng thử lại sau.</p>");
            } finally {
                // Đóng kết nối và tài nguyên
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}