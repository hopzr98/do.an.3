<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="css_itplus.css">
    <script src="jquery_new.js"></script>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }
        .user-update-content{
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
            position: absolute;
            top: 10%;
            left: 30%;
        }
        select {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        .button-container {
            text-align: center;
        }
        .button-container button {
            padding: 10px 20px;
            background-color: #4a4a4a;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .cancel {
            background-color: #dddddd;
            color: #555555;
            margin-left: 10px;
        }
        .infor{
            display: inline-block;
        }
        .disabled {
            opacity: 0.5;
            pointer-events: none;
        }
    </style>
    <title>Thông tin User</title>
</head>
<body>
    <div class="header">
        <div class="menu menu-head">
            <ul class="nav justify-content-end">
                <li class="nav-item" >
                    <a class="nav-link active" href="#">Hỗ trợ <i class="fa fa-life-ring"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/card.jsp">Giỏ hàng <i class="fa fa-shopping-cart"></i></a>
                </li>
                <li class="nav-item">
				    <c:choose>
				        <c:otherwise>
				            <a class="nav-link" href="${pageContext.request.contextPath}/customerInfo.jsp">
				                <span id="username">${sessionScope.username}</span> 
				                <i class="fa fa-user na" title="Cá nhân"></i>
				            </a>
				        </c:otherwise>
				    </c:choose>
				</li>
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
     </div>
    <div class="user-update-content">
    <form action="information-user">
    <h3>Thông tin User</h3>
    <c:choose>
        <c:when test="true">
           <label for="username">Tên đăng nhập: </label>
           <p name="username" class="infor"><b>${User.username}</b></p><br><br>
       <%--  </c:when>
        <c:when test="${not empty inforCus}"> --%>
          <%--   <c:forEach items="${inforCus}" var="o">
                <label for="name">Tên: </label>
                <p name="name" class="infor"><b>${o.customerName}</b></p><br><br>

                <label for="address">Địa chỉ: </label>
                <p name="address" class="infor"><b>${o.address}</b></p><br><br>

                <label for="phone">Số điện thoại: </label>
                <p name="phone" class="infor"><b>${o.phoneNumber}</b></p><br><br>

                <label for="email">Email: </label>
                <p name="email" class="infor"><b>${o.email}</b></p><br><br>
            </c:forEach> --%>
        </c:when>
        <c:otherwise>
            <p>Không có thông tin khách hàng hoặc người dùng.</p>
        </c:otherwise>
    </c:choose>
    <div class="form-group button-container">
        <button type="submit" class="but-update">Sửa</button>
        <button type="button" class="cancel">Thoát</button>
    </div>
</form>

    <script>
        $(document).ready(function() {
            $('.but-update').click(function(){
                window.location.href = "user-update.jsp";
            });
            $('.cancel').click(function() {
                window.location.href = "Home";
            });
        });
    </script>
</body>
</html>