<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product Information</title>
    <!-- edit-informatrion.jsp -->
</head>
<body>
    
    <%@ page import="entity.Product" %>
    <%@ page import="dao.DAO" %>
    <%
    // Lấy tham số productId từ URL
    int productId = Integer.parseInt(request.getParameter("productId"));
	DAO d = new DAO();
    // Kết nối đến database mobile và lấy thông tin sản phẩm
    Product product = d.getProductByID(productId);
    
	%>

<!-- Hiển thị thông tin sản phẩm trên trang -->
<h1>Sửa thông tin sản phẩm</h1>
<form action="update-product" method="post">
    <input type="hidden" name="productId" value="<%= product.getId() %>">
    <label for="productName">Tên sản phẩm:</label>
    <input type="text" id="productName" name="productName" value="<%= product.getProductName() %>"><br>

    <label for="productCategoryPath">Đường dẫn danh mục sản phẩm:</label>
    <input type="text" id="productCategoryPath" name="productCategoryPath" value="<%= product.getProductCategoryPath() %>"><br>

    <label for="unitPrice">Giá bán:</label>l
    <input type="number" id="unitPrice" name="unitPrice" value="<%= product.getUnitPrice() %>"><br>

    <label for="oldPrice">Giá cũ:</label>
    <input type="number" id="oldPrice" name="oldPrice" value="<%= product.getOldPrice() %>"><br>

    <label for="quantity">Số lượng:</label>
    <input type="number" id="quantity" name="quantity" value="<%= product.getQuantity() %>"><br>

    <button type="submit">Lưu thay đổi</button>
</form>
</body>
</html>