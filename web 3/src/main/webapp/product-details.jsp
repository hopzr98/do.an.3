<%@page import="java.util.List"%>
<%@page import="entity.RamColorQuantity"%>
<%@page import="entity.ProductColor"%>
<%@page import="entity.ProductMemory"%>
<%@page import="entity.Product"%>
<%@page import="dao.DAO"%>
<%@page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>
	.bg-red {
		background-color: red;
	}
</style>
<body>
	<% 
		int id = Integer.parseInt(request.getParameter("productId"));
		DAO dao = new DAO();		
		Product product = dao.getProductByIdFullDetails(id);
		List<RamColorQuantity> quantities = dao.getRamAndColorQuantity(product);
	%>
	<script>
		var priceUnit = <%= product.getUnitPrice() %>
		var list = [
			<% for (ProductMemory ram : product.getMemorys()) { %>
				{id: <%= ram.getId() %>, name: '<%= ram.getMemory() %>', price: <%= ram.getPrice() %>, color: [
					<% for (RamColorQuantity quantity : quantities) { %>
						<% if (quantity.getRamId() == ram.getId()) { %>
						 	{idColor: <%= quantity.getColorId() %>, quantity: <%= quantity.getQuantity() %>}, 
						<% } %>
					<% } %>
				]}, 
		 	<% } %>
		];
		var ramSelected = list[0].id;
		var colorSelected = list[0].color[0].idColor
		onload = () => {
			choseRam(ramSelected)
			choseColor(colorSelected)
		}
		var ramSelected = list[0].id;
		var colorSelected = list[0].color[0].idColor
		var choseRam = (id) => {
			document.querySelectorAll('#list-ram button').forEach(item => {
				item.classList = ''
			})
			document.getElementById("btn-ram-" + id).classList = 'bg-red'
			let vl = list.filter(item => item.id == id)[0]
			document.getElementById('price').innerHTML = 'Giá: ' + (vl.price + priceUnit)
			document.getElementById('quantity').innerHTML = 'Số lượng: ' + vl.color.filter(item => item.idColor == colorSelected)[0].quantity
			ramSelected = id;
		}
		var choseColor = (id) => {
			document.querySelectorAll('#list-color button').forEach(item => {
				item.classList = ''
			})
			document.getElementById("btn-color-" + id).classList = 'bg-red'
			let vl = list.filter(item => item.id == ramSelected)[0]
			document.getElementById('price').innerHTML = 'Giá: ' + (vl.price + priceUnit)
			document.getElementById('quantity').innerHTML = 'Số lượng: ' + vl.color.filter(item => item.idColor == id)[0].quantity
			colorSelected = id;
		}
	</script>
	<h2>Thông tin sản phẩm</h2>
	<h3><%= product.getProductName() %></h3>
	<img src="<%= product.getImg() %>" alt="Ảnh sản phẩm"/>
	<p id="price">Giá: </p>
	<p id="quantity">Số lượng: </p>
	<ul id="list-ram">
		<h4>RAM</h4>
		<% for (ProductMemory ram : product.getMemorys()) { %>
			<li>
				<button type="button" id="btn-ram-<%= ram.getId() %>" onclick="choseRam(<%= ram.getId() %>)"><%= ram.getMemory() %></button>
			</li>
	 	<% } %>
	</ul>
	<ul id="list-color">
		<h4>Màu</h4>
		<% for (ProductColor color : product.getColors()) { %>
			<li>
				<button type="button" id="btn-color-<%= color.getId() %>" onclick="choseColor(<%= color.getId() %>)">
				<img src="<%= color.getImages() == null || color.getImages().size() == 0 ? "" : color.getImages().get(0).getImageUrl() %>" alt="Ảnh màu"/>
					<%= color.getColor() %></button>
			</li>
	 	<% } %>
	</ul>
</body>
</html>