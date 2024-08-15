package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import context.DBContext;
import entity.Category;
import entity.Customer;
import entity.Gift;
import entity.News;
import entity.Product;
import entity.ProductColor;
import entity.ProductColorImage;
import entity.ProductDetails;
import entity.ProductMemory;
import entity.RamColorQuantity;
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public Product getProductByIdFullDetails(int id) {
		String query = "SELECT * FROM product WHERE id = " + id;
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			if (resultSet.next()) {
				Product product = new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						);
				List<ProductColor> colors = new ArrayList<>();
				query = "Select * from color where productId = ?";
				try {
					new DBContext();
					connect = DBContext.getConnection();
					prepare = connect.prepareStatement(query);
					prepare.setInt(1, product.getId());
					ResultSet rs = prepare.executeQuery();
					while(rs.next()) {
						int colorId = rs.getInt("id");
						query = "SELECT * FROM ProductColorImages WHERE coID = ?";
						prepare = connect.prepareStatement(query);
						prepare.setInt(1, colorId);
						ResultSet rs1 = prepare.executeQuery();
						List<ProductColorImage> images = new ArrayList<ProductColorImage>();
						while(rs1.next()) {
							images.add(new ProductColorImage(rs1.getInt("coID"), rs1.getString("imageUrl")));
						}
						colors.add(new ProductColor(colorId, product.getId(), rs.getString("color"), images));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				product.setColors(colors);
				List<ProductMemory> rams = new ArrayList<>();
				query = "Select * from memory where productId = ? order by price";
				try {
					new DBContext();
					connect = DBContext.getConnection();
					prepare = connect.prepareStatement(query);
					prepare.setInt(1, product.getId());
					ResultSet rs = prepare.executeQuery();
					while(rs.next()) {
						rams.add(new ProductMemory(rs.getInt("id"), product.getId(), rs.getString("memory"), rs.getDouble("price")));
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
				product.setMemorys(rams);
				return product;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public List<RamColorQuantity> getRamAndColorQuantity(Product product) {
		List<RamColorQuantity> list = new ArrayList<>();
		String query = "SELECT * FROM memory_color_quantity";
		if (product.getMemorys() != null && product.getMemorys().size() > 0) {
			query += " WHERE memory_id IN (" + product.getMemorys().stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(",")) + ")";
		} 
		if (product.getColors() != null && product.getColors().size() > 0) {
			if (product.getMemorys() != null && product.getMemorys().size() > 0)
				query += " AND color_id IN (" + product.getColors().stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(",")) + ")";
			else 
				query += " WHERE color_id IN (" + product.getColors().stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(",")) + ")";
		}
		query += " ORDER BY memory_id, color_id";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new RamColorQuantity(resultSet.getInt("memory_id"), resultSet.getInt("color_id"), resultSet.getInt("quantity")));
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Product> getAllProductFullDetails(){
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM product";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				Product product = new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getDouble(5),
						resultSet.getDouble(6),
						resultSet.getInt(7),
						resultSet.getInt(8)
						);
				List<ProductColor> colors = new ArrayList<>();
				query = "Select * from color where productId = ?";
				try {
					new DBContext();
					connect = DBContext.getConnection();
					prepare = connect.prepareStatement(query);
					prepare.setInt(1, product.getId());
					ResultSet rs = prepare.executeQuery();
					while(rs.next()) {
						int colorId = rs.getInt("id");
						query = "SELECT * FROM ProductColorImages WHERE coID = ?";
						prepare = connect.prepareStatement(query);
						prepare.setInt(1, colorId);
						ResultSet rs1 = prepare.executeQuery();
						List<ProductColorImage> images = new ArrayList<ProductColorImage>();
						while(rs1.next()) {
							images.add(new ProductColorImage(rs1.getInt("coID"), rs1.getString("imageUrl")));
						}
						colors.add(new ProductColor(colorId, product.getId(), rs.getString("color"), images));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				product.setColors(colors);
				List<ProductMemory> rams = new ArrayList<>();
				query = "Select * from memory where productId = ? order by price";
				try {
					new DBContext();
					connect = DBContext.getConnection();
					prepare = connect.prepareStatement(query);
					prepare.setInt(1, product.getId());
					ResultSet rs = prepare.executeQuery();
					while(rs.next()) {
						rams.add(new ProductMemory(rs.getInt("id"), product.getId(), rs.getString("memory"), rs.getDouble("price")));
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
				product.setMemorys(rams);
				list.add(product);
			}
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
		String query = "Select * from product where cid = ?;";
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
	public List<ProductColor> getColorsByProductId(int productId){
		List<ProductColor> list = new ArrayList<>();
		String query = "Select * from color where productId = ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, productId);
			resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				int colorId = resultSet.getInt("id");
				query = "SELECT * FROM ProductColorImages WHERE coID = ?";
				prepare = connect.prepareStatement(query);
				prepare.setInt(1, colorId);
				ResultSet rs1 = prepare.executeQuery();
				List<ProductColorImage> images = new ArrayList<ProductColorImage>();
				while(rs1.next()) {
					images.add(new ProductColorImage(rs1.getInt("coID"), rs1.getString("imageUrl")));
				}
				list.add(new ProductColor(colorId, productId, resultSet.getString("color"), images));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<ProductMemory> getRamsByProductId(int productId){
		List<ProductMemory> list = new ArrayList<>();
		String query = "Select * from memory where productId = ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, productId);
			resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				list.add(new ProductMemory(resultSet.getInt("id"), productId, resultSet.getString("memory"), resultSet.getDouble("price")));
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
		
		String query = "Select * from product where id = ?;";
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
						resultSet.getString(21)
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
	
	public boolean addProduct(Product product, List<RamColorQuantity> quantities) {
		boolean success = false;
        String query = "INSERT INTO product ( productName, productCategoryPath, img, unitPrice, oldPrice, cid, quantity) " +
                       "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        try {
            new DBContext();
            connect = DBContext.getConnection();
            connect.setAutoCommit(false);
            prepare = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//            prepare.setInt(1, id);
            prepare.setString(1, product.getProductName());
            prepare.setString(2, product.getProductCategoryPath());
            prepare.setString(3, product.getImg());
            prepare.setDouble(4, product.getUnitPrice());
            prepare.setDouble(5, product.getOldPrice());
            prepare.setInt(6, product.getCid());
            prepare.setInt(7, product.getQuantity());
            prepare.executeUpdate();
            ResultSet rs = prepare.getGeneratedKeys();
            if (rs.next()) {
            	product.setId((int) rs.getLong(1));
            	// Them color
            	for (ProductColor color : product.getColors()) {
            		try {
	            		query = "INSERT INTO color (productId, color) VALUES (?,?)";
	            		prepare = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	            		prepare.setInt(1, product.getId());
	            		prepare.setString(2, color.getColor());
	            		prepare.executeUpdate();
	            		rs = prepare.getGeneratedKeys();
	            		if (rs.next()) {
		            		color.setId((int) rs.getLong(1));	
		            		for (RamColorQuantity quantity : quantities) 
		            			if (quantity.getColor().equals(color.getColor()))
		            				quantity.setColorId(color.getId());
		            		for (ProductColorImage image : color.getImages()) {
		            			try {
		            				query = "INSERT INTO ProductColorImages (coID, imageUrl) VALUES (?, ?)";
		    	            		prepare = connect.prepareStatement(query);
		    	            		prepare.setInt(1, color.getId());
		    	            		prepare.setString(2, image.getImageUrl());
		    	            		prepare.executeUpdate();
		            			} catch (Exception e) {
									// TODO: handle exception
								}
		            		}
	            		}
            		} catch (Exception e) {
						// TODO: handle exception
					}
            	}
            		// Them memory
        		for (ProductMemory memory : product.getMemorys()) {
            		try {
	            		query = "INSERT INTO memory (productId, memory, price) VALUES (?,?,?)";
	            		prepare = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
	            		prepare.setInt(1, product.getId());
	            		prepare.setString(2, memory.getMemory());
	            		prepare.setDouble(3, memory.getPrice());
	            		prepare.executeUpdate();
	            		rs = prepare.getGeneratedKeys();
	            		if (rs.next()) {
		            		for (RamColorQuantity quantity : quantities) 
		            			if (quantity.getRam().equals(memory.getMemory()))
		            				quantity.setRamId(rs.getInt(1));	
	            		}
            		} catch (Exception e) {
						// TODO: handle exception
					}
        		}
        		for (RamColorQuantity quantity : quantities) {
            		try {
	            		query = "INSERT INTO memory_color_quantity (memory_id, color_id, quantity) VALUES (?,?,?)";
	            		prepare = connect.prepareStatement(query);
	            		prepare.setInt(1, quantity.getRamId());
	            		prepare.setInt(2, quantity.getColorId());
	            		prepare.setInt(3, quantity.getQuantity());
	            		prepare.executeUpdate();
            		} catch (Exception e) {
						// TODO: handle exception
					}
        		}
                connect.commit();
                success = true;	
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            if (connect != null) {
                try {
                    connect.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
        return success;
    }
	
	public boolean updateProduct(Product product, List<RamColorQuantity> quantities) {
        String query = "UPDATE product set productName = ?, productCategoryPath = ?, unitPrice = ?, oldPrice = ?, quantity = ? " +
                       " WHERE id = ?";
        boolean success = false;
        try {
            new DBContext();
            connect = DBContext.getConnection();
            connect.setAutoCommit(false);
            prepare = connect.prepareStatement(query);
//            prepare.setInt(1, id);
            prepare.setString(1, product.getProductName());
            prepare.setString(2, product.getProductCategoryPath());
            prepare.setDouble(3, product.getUnitPrice());
            prepare.setDouble(4, product.getOldPrice());
            prepare.setInt(5, product.getQuantity());
            prepare.setInt(6, product.getId());
            prepare.executeUpdate();
            ResultSet rs = null;
        	// Them | Edit color
        	for (ProductColor color : product.getColors()) {
        		try {
        			if (color.getId() < 0) {
        				query = "INSERT INTO color (productId, color) VALUES (?,?)";
        			} else {
        				query = "UPDATE color SET productId = ?, color = ? WHERE id = " + color.getId();
        			}
            		prepare = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            		prepare.setInt(1, product.getId());
            		prepare.setString(2, color.getColor());
            		prepare.executeUpdate();
            		rs = prepare.getGeneratedKeys();
	    			if (color.getId() < 0 && rs.next())
	    				color.setId((int) rs.getLong(1));	
	    			else {
	    				try {	
	    					query = "DELETE FROM ProductColorImages WHERE coID = " + color.getId();
	    					connect.prepareStatement(query).executeUpdate();
	    				} catch (Exception e) {
	    		        	System.out.println(e.getMessage());
							// TODO: handle exception
	    					e.printStackTrace();
						}
            		}
            		for (ProductColorImage image : color.getImages()) {
            			try {
            				query = "INSERT INTO ProductColorImages (coID, imageUrl) VALUES (?, ?)";
                			prepare = connect.prepareStatement(query);
    	            		prepare.setInt(1, color.getId());
    	            		prepare.setString(2, image.getImageUrl());
    	            		prepare.executeUpdate();
            			} catch (Exception e) {
							// TODO: handle exception
            	        	System.out.println(e.getMessage());
            				e.printStackTrace();
						}
            		}
            		for (RamColorQuantity quantity : quantities) 
            			if (quantity.getColor().equals(color.getColor()))
            				quantity.setColorId(color.getId());
        		} catch (Exception e) {
					// TODO: handle exception
        			e.printStackTrace();
                	System.out.println(e.getMessage());
				}
        	}
        	try {
        		query = "DELETE FROM color WHERE productId = " + product.getId() + " and id NOT IN (" + product.getColors().stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(",")) + ")";
        		connect.prepareStatement(query).executeUpdate();
        	} catch (Exception e) {
				// TODO: handle exception
			}
        		// Them memory
    		for (ProductMemory memory : product.getMemorys()) {
        		try {
        			if (memory.getId() < 0)
        				query = "INSERT INTO memory (productId, memory, price) VALUES (?,?,?)";
        			else 
        				query = "UPDATE memory SET productId = ?, memory = ?, price = ? WHERE id = " + memory.getId();
        			prepare = connect.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            		prepare.setInt(1, product.getId());
            		prepare.setString(2, memory.getMemory());
            		prepare.setDouble(3, memory.getPrice());
            		prepare.executeUpdate();
            		rs = prepare.getGeneratedKeys();
	    			if (memory.getId() < 0 && rs.next())
	    				memory.setId(rs.getInt(1));
            		for (RamColorQuantity quantity : quantities) 
            			if (quantity.getRam().equals(memory.getMemory()))
            				quantity.setRamId(memory.getId());	
        		} catch (Exception e) {
					// TODO: handle exception
        			e.printStackTrace();
                	System.out.println(e.getMessage());
				}
    		}
    		try {
    			query = "DELETE FROM memory_color_quantity WHERE memory_id IN (SELECT id FROM color WHERE productId = ?) OR " + 
    				" memory_id IN (SELECT id FROM memory WHERE productId = ?)";
        		prepare = connect.prepareStatement(query);
        		prepare.setInt(1, product.getId());
        		prepare.setInt(2, product.getId());
        		prepare.executeUpdate();
    		} catch (Exception e) {
				// TODO: handle exception
			}
    		for (RamColorQuantity quantity : quantities) {
        		try {
            		query = "INSERT INTO memory_color_quantity (memory_id, color_id, quantity) VALUES (?,?,?)";
            		prepare = connect.prepareStatement(query);
            		prepare.setInt(1, quantity.getRamId());
            		prepare.setInt(2, quantity.getColorId());
            		prepare.setInt(3, quantity.getQuantity());
            		prepare.executeUpdate();
        		} catch (Exception e) {
					// TODO: handle exception
				}
    		}
            connect.commit();
            success = true;	
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
            if (connect != null) {
            	try {
					connect.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
		        	System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
            }
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
            	System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return success;
    }
	
	public boolean deleteProduct(int id) {
	    try {
	        new DBContext();
	        connect = DBContext.getConnection();
	        connect.setAutoCommit(false);
	        String query = "DELETE FROM memory_color_quantity WHERE memory_id IN (SELECT id FROM memory WHERE productId = ?) OR"
	        		+ " color_id IN (SELECT id FROM color WHERE productId = ?)";
	        prepare = connect.prepareStatement(query);
	        prepare.setInt(1, id);
	        prepare.setInt(2, id);
	        prepare.executeUpdate();
	        query = "DELETE FROM ProductColorImages WHERE coId IN (SELECT id FROM color WHERE productId = " + id + ")";
	        connect.prepareStatement(query).executeUpdate();
	        query = "DELETE FROM memory WHERE productId = " + id;
	        connect.prepareStatement(query).executeUpdate();
	        query = "DELETE FROM color WHERE productId = " + id;
	        connect.prepareStatement(query).executeUpdate();
	        query = "DELETE FROM product WHERE id = ?";
	        prepare = connect.prepareStatement(query);
	        prepare.setInt(1, id);
	        int rowsDeleted = prepare.executeUpdate();
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	    	try {
				connect.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Close resources in finally block
	        try {
	            if (prepare != null) {
	                prepare.close();
	            }
	            if (connect != null) {
	            	connect.commit();
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
		        		+ "UPDATE product SET id = (@new_id := @new_id + 1) ORDER BY id;";
		        prepare = connect.prepareStatement(query);
		  }catch (Exception e) {
			// TODO: handle exception
		}
	}
}