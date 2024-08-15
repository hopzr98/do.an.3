package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private static final String URL = "jdbc:mysql://localhost:3306/mobile";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
//    public static void main(String[] args) {
//		try {
//			System.out.println(new DBContext().getConnection());
//			System.out.println("Ket noi thanh cong");
//		}catch (Exception e){
//			
//		}
//	}
}
