package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import context.DBContext;
import entity.Category;
import entity.Customer;
import entity.Gift;
import entity.News;
import entity.Product;
import entity.ProductDetails;
import entity.User;

public class DAO {
	Connection connect = null; 			//ket noi SQL
	PreparedStatement prepare = null;   //Nem cau lenh sang SQL
	ResultSet resultSet = null; 		//Nhan ket qua tra ve
	
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product;";
		try {
			new DBContext();
			connect = DBContext.getConnection(); //Mo ket noi SQL
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						));
			}
			
			for (Product p : list)
				System.out.println(p.getId());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Product> getTop1(){
		List<Product> top1 = new ArrayList<>();
		String top = "SELECT * FROM product ORDER BY id DESC LIMIT 1;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(top);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				top1.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return top1;
	}
	public List<Category> getCategory() {
        List<Category> productList = new ArrayList<>();

        try {
            String sql = "select * from categoryProduct";
            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while(resultSet.next()) {
            	productList.add(new Category(
            			resultSet.getInt(1),
            			resultSet.getString(2)
            			));
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
	public List<Product> getProductByCateID(String id){
		List<Product> list = new ArrayList<>();
		String query = "Select * from `product` where cid = ?;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				list.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Gift> getAllGift(String id){
		List<Gift> list = new ArrayList<>();
		
		try {
			String gift = "SELECT * FROM gift where productId = ?";
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(gift);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new Gift(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Product getProductByID(String id){
		
		String query = "Select * from `product` where id = ?;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				return new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;		
	}
	
	//kiểm tra id sản phẩm tồn tại chưa và thêm sp mới
	public Product getProductByID(int id) {
	    String query = "SELECT * FROM product WHERE id = ?";
	    try {
	        new DBContext();
	        connect = DBContext.getConnection();
	        prepare = connect.prepareStatement(query);
	        prepare.setInt(1, id);
	        resultSet = prepare.executeQuery();
	        if (resultSet.next()) {
	            return new Product(
	                    resultSet.getInt(1),
	                    resultSet.getString(2),
	                    resultSet.getString(3),
	                    resultSet.getString(4),
	                    resultSet.getDouble(5),
	                    resultSet.getDouble(6),
	                    resultSet.getInt(7),
	                    resultSet.getInt(8)
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//NEWS
	public List<News> getNews(){
		List<News> list = new ArrayList<>();
		String query = "SELECT * FROM news";
		try {
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new News(
						resultSet.getInt(1),
						resultSet.getString(2)
						));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//ProDetaillss
	public List<ProductDetails> getAllDetails(String id){
		List<ProductDetails> list = new ArrayList<>();
		
		try {
			String de = "SELECT * FROM productDetails where productId = ?";
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(de);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new ProductDetails(
						resultSet.getInt(1),
						resultSet.getInt(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11),
						resultSet.getString(12),
						resultSet.getString(13),
						resultSet.getString(14),
						resultSet.getString(15),
						resultSet.getString(16),
						resultSet.getString(17),
						resultSet.getString(18),
						resultSet.getString(19),
						resultSet.getString(20),
						resultSet.getString(21),
						resultSet.getString(22)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public User getUser(String id){
		String user = "select * from users where id = ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(user);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				return new User(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public Customer getCustomer(String id) {
		String customer = "select * from customer where id = ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(customer);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				return new Customer(resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getString(5));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	public String getUserIdByUsername(String username) {
        String id = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            String query = "SELECT id FROM users WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return id;
    }
	//Test xem các chức năng đã được lấy từ DB về chưa..
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> listX = dao.getAllProduct();
		List<Category> list = dao.getCategory();
		List<Product> listP = dao.getProductByCateID("1");
		List<Gift> gift = dao.getAllGift("2");
		List<ProductDetails> d = dao.getAllDetails("2");
		
		for(Category o : list) {
			System.out.println(o);
		}
	}
	
	public void addProduct( String productName, String productCategoryPath, String img, double unitPrice, double oldPrice, int cid, int quantity) {
        String query = "INSERT INTO product ( productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity) " +
                       "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        try {
            new DBContext();
            connect = DBContext.getConnection();
            prepare = connect.prepareStatement(query);
//            prepare.setInt(1, id);
            prepare.setString(1, productName);
            prepare.setString(2, productCategoryPath);
            prepare.setString(3, img);
            prepare.setDouble(4, unitPrice);
            prepare.setDouble(5, oldPrice);
            prepare.setInt(6, cid);
            prepare.setInt(7, quantity);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public void updateProduct(int id, String productName, String productCategoryPath, double unitPrice, double oldPrice, int quantity) {
        String query = "UPDATE product set productName = ?, productCategoryPath = ?, unitPrice = ?, oldPrice = ?, quantity = ? " +
                       " WHERE id = ?";
        try {
        	System.out.println("price: " + unitPrice + "; oldPrice: " + oldPrice + ";quantity: " + quantity);
            new DBContext();
            connect = DBContext.getConnection();
            prepare = connect.prepareStatement(query);
//            prepare.setInt(1, id);
            prepare.setString(1, productName);
            prepare.setString(2, productCategoryPath);
            prepare.setDouble(3, unitPrice);
            prepare.setDouble(4, oldPrice);
            prepare.setInt(5, quantity);
            prepare.setInt(6, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	public boolean deleteProduct(int id) {
	    try {
	        new DBContext();
	        connect = DBContext.getConnection();
	        String query = "DELETE FROM product WHERE id = ?";
	        prepare = connect.prepareStatement(query);
	        prepare.setInt(1, id);
	        int rowsDeleted = prepare.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Close resources in finally block
	        try {
	            if (prepare != null) {
	                prepare.close();
	            }
	            if (connect != null) {
	                connect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	// luôn loading và update lại ID bên sql
	public void updateId() {
		  try {
		        new DBContext();
		        connect = DBContext.getConnection();
		        String query = "SET @new_id = 0;\r\n"
		        		+ "UPDATE `product` SET id = (@new_id := @new_id + 1) ORDER BY id;";
		        prepare = connect.prepareStatement(query);
		  }catch (Exception e) {
			// TODO: handle exception
		}
	}
}