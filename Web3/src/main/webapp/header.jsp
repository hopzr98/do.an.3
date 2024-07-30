<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css_itplus.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery_new.js"></script>
    <title>Mobie Smart</title>
</head>
<body>
    <div class="menu-container">
        <div class="items1 item header"> 
            <div class="menu menu-head">
                <ul class="nav justify-content-end">
                    <li class="nav-item" >
                        <a class="nav-link active" href="#">Hỗ trợ <i class="fa fa-life-ring"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giỏ hàng <i class="fa fa-shopping-cart"></i></a>
                    </li>
                    <li class="nav-item">
                        <c:choose>
				        <c:when test="${empty sessionScope.username}">
				            <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Account
				                <i class="fa fa-user na" title="Cá nhân"></i>
				            </a>
				        </c:when>
				        <c:otherwise>
				            <a class="nav-link" href="${pageContext.request.contextPath}/HomeControll?action=customer"> <!-- Cập nhật đường dẫn -->
				                <span id="username">${sessionScope.username}</span> 
				                <i class="fa fa-user na" title="Cá nhân"></i>
				            </a>
				        </c:otherwise>
				    </c:choose>
                    </li>
                    
                    <!-- <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li> -->
                </ul>
            </div>
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/Home" >
                    <img class="logo-it" src="LoGo_ITPLUS__1_-removebg.png" width="30px" height="50px">
                    <i  title="Logo">Mobile Smart</i></a>
                <form class="form-inline" style="margin-right: 20px;">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
            <div class="list-menu">
                <ul class="list-ul-menu">
                    <li class="has-submenu"><a href="${pageContext.request.contextPath}/Home">Trang Chủ</a></li>         
                    <li class="has-submenu"><a href="${pageContext.request.contextPath}/Home">Sản Phẩm <i class="fa fa-chevron-down"></i></a>
                        <ul class="submenu">
                            <li class="submenu-item">
                                <ul class="menu-pruct menu-product">
                                    <li><b>Sản phẩm mới</b></li>
                                    <li><a href="#" title="iPhone 15 Promax 256Gb mới">iPhone 15 Promax 256Gb</a></li>
                                    <li><a href="#" title="iPhone 15 Promax 512Gb mới">iPhone 15 Promax 512Gb</a></li>
                                    <li><a href="#" title="iPhone 15 Promax 1Tb mới">iPhone 15 Promax 1Tb</a></li>
                                    <li><a href="#" title="iPhone 15 Pro 128Gb mới">iPhone 15 Pro 128Gb</a></li>
                                </ul>
                            </li>
                            <li class="submenu-item">
                                <ul class="menu-pruct menu-product">
                                    <li><b>Đã qua sử dụng 99%</b></li>
                                    <li><a href="#" title="iPhone 12 đã qua sử dụng">iPhone 12 đã qua sử dụng</a></li>
                                    <li><a href="#" title="iPhone 12 đã qua sử dụng">iPhone 12 đã qua sử dụng</a></li>
                                    <li><a href="#" title="iPhone 13 đã qua sử dụng">iPhone 13 đã qua sử dụng</a></li>
                                    <li><a href="#" title="iPhone 14 đã qua sử dụng">iPhone 14 đã qua sử dụng</a></li>
                                    <!-- Các dòng iPhone khác đã qua sử dụng -->
                                </ul>
                            </li>
                            <li class="submenu-item">
                                <ul class="menu-pruct menu-product">
                                    <li><b>Đã qua sử dụng 95%</b></li>
                                    <li><a href="#" title="iPhone 11 đã qua sử dụng 95%">iPhone 11 95%</a></li>
                                    <li><a href="#" title="iPhone 12 đã qua sử dụng 95%">iPhone 12 95%</a></li>
                                    <li><a href="#" title="iPhone 13 đã qua sử dụng 95%">iPhone 13 95%</a></li>
                                    <li><a href="#" title="iPhone 14 đã qua sử dụng 95%">iPhone 14 95%</a></li>
                                    <!-- Các dòng iPhone khác đã qua sử dụng 95% -->
                                </ul>
                            </li>
                            <li class="submenu-item">
                                <ul class="menu-pruct menu-product">
                                    <li><b>Linh kiện phụ kiện</b></li>
                                    <li><a href="#" title="Phụ kiện iPhone">Phụ kiện iPhone</a></li>
                                    <li><a href="#" title="Ốp lưng iPhone">Ốp lưng iPhone</a></li>
                                    <li><a href="#" title="Air pod">Air pod</a></li>
                                    <!-- Các linh kiện và phụ kiện khác -->
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="has-submenu"><a href="${pageContext.request.contextPath}/gioi-thieu.jsp">Giới Thiệu</a></li>
                    <li class="has-submenu"><a href="#">Dịch Vụ</a></li>
                    <li class="has-submenu"><a href="#">Tuyển Dụng <i class="fa fa-chevron-down"></i></a>
                        <ul class="submenu">
                            <li class="submenu-item"><a href="#" title="Tuyển dụng nhân viên bán hàng">Nhâ viên bán hàng</a></li>
                            <li class="submenu-item"><a href="#" title="Tuyển dụng nhân viên Marketing">Nhân viên Marketing</a></li>
                            <li class="submenu-item"><a href="#" title="Tuyển dụng nhân viên quản lý">Quản lý</a></li>
                            <li class="submenu-item"><a href="#" title="Tuyển dụng nhân viên kế toán">Kế toán</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>