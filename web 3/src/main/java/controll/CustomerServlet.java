package controll;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
//        int userId = request.getIntHeader("userId");

        if (customerName != null && address != null && phoneNumber != null && email != null) {
            Connection conn = null;
            PreparedStatement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String dbURL = "jdbc:mysql://localhost:3306/mobile";
                String dbUsername = "root";
                String dbPassword = "root";
                conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

                String insertUserQuery = "INSERT INTO customers (customerName, address, phoneNumber, email) "
                		+ "VALUES (?, ?, ?, ?)";
                stmt = conn.prepareStatement(insertUserQuery);
                stmt.setString(1, customerName);
                stmt.setString(2, address);
                stmt.setString(3, phoneNumber);
                stmt.setString(4, email);
//                stmt.setInt(5, userId);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    response.sendRedirect("Home");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
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
