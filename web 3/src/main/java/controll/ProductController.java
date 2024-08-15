package controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.DAO;
import entity.Product;
import entity.ProductColor;
import entity.ProductColorImage;
import entity.ProductMemory;
import entity.RamColorQuantity;
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
	    String productName = request.getParameter("productName");
	    String productCategoryPath = request.getParameter("productCategoryPath");
	    String img = request.getParameter("img");
	    double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
	    double oldPrice = Double.parseDouble(request.getParameter("oldPrice"));
	    int cid = Integer.parseInt(request.getParameter("cid"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    
	    List<Integer> idColors = Arrays.stream(request.getParameterValues("idColors")).map(Integer::parseInt).toList();
	    List<String> nameColors = Arrays.stream(request.getParameterValues("nameColors")).toList();
	    List<String> imageColors = Arrays.stream(request.getParameterValues("imageColors")).toList();
	    
	    List<ProductColor> colors = new ArrayList<ProductColor>();
	    for (int i = 0; i < nameColors.size(); i++) {
	    	ProductColorImage image = new ProductColorImage();
	    	image.setImageUrl(imageColors.get(i));
	    	
	    	ProductColor color = new ProductColor();
	    	color.setId(idColors.get(i));
	    	color.setColor(nameColors.get(i));
	    	color.setImages(List.of(image));
	    	
	    	colors.add(color);
	    }
	    
	    List<Integer> idRams = Arrays.stream(request.getParameterValues("idRams")).map(Integer::parseInt).toList();
	    List<String> nameRams = Arrays.stream(request.getParameterValues("nameRams")).toList();
	    List<Double> priceRams = Arrays.stream(request.getParameterValues("priceRams")).map(item -> Double.parseDouble(item)).toList();
	    
	    List<ProductMemory> rams = new ArrayList<ProductMemory>();
	    for (int i = 0; i < nameRams.size(); i++) {
	    	ProductMemory ram = new ProductMemory();
	    	ram.setMemory(nameRams.get(i));
	    	ram.setPrice(priceRams.get(i));
	    	ram.setId(idRams.get(i));
	    	rams.add(ram);
	    }
	    
	    List<String> quantityRamNames = Arrays.stream(request.getParameterValues("quantity-rams-name")).toList();
	    List<String> quantityColorNames = Arrays.stream(request.getParameterValues("quantity-colors-name")).toList();
	    List<Integer> quantityCount = Arrays.stream(request.getParameterValues("quantity-count")).map(Integer::parseInt).toList();
	    
	    List<RamColorQuantity> quantities = new ArrayList<RamColorQuantity>();
	    for (int i = 0; i < quantityCount.size(); i++) {
	    	quantities.add(new RamColorQuantity(quantityRamNames.get(i), quantityColorNames.get(i), quantityCount.get(i)));
	    }
	    
	    Product product = new Product(id, productName, productCategoryPath, img, unitPrice,
			oldPrice, cid, quantity, colors, rams);
	    try {
	    	if (dao.updateProduct(product, quantities)) {
	    		response.sendRedirect(request.getContextPath() + "/admin");
	    		return;
	    	}
	    } catch (Exception e) {
	    	// TODO: handle exception
		}
	    response.sendRedirect(request.getContextPath() + "/edit-information.jsp?productId=" + id);
    }
	
	

}