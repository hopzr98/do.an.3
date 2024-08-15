<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="header.jsp" %>
<link rel="stylesheet" href="css_itplus.css">
<body>
    <div class="content-menu-san-pham">
        <nav aria-label="breadcrumb">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Home.jsp" style="cursor: pointer;">Trang Chủ</a></li>
                    <li class="breadcrumb-item">Sản Phẩm</li>
                    <li class="breadcrumb-item active" aria-current="page">${detail.productCategoryPath}</li>
                    </ol>
                </nav>
            </nav>
        <div class="information-product">
            <div class="production">
            
			<div class="production-img">
			    <input class="button-back-banner" type="button" id="flip" value="&lt;">
			    <div class="imagess panel">
			        <img class="emgi" src="${detail.img}" alt="">
			    </div>
			    <input class="button-next-banner" type="button" id="flop" value="&gt;">
			    <div class="list-img-product">
			        <!-- Hiển thị thông tin sản phẩm -->
			        <%-- <h2>${detail.productName}</h2>
			        <p>Product Category: ${detail.productCategoryPath}</p>
			        <p>Unit Price: ${detail.unitPrice}</p> --%>
			        <ul class="uu">
			            <li></li>
			            <li></li>
			            <li></li>
			        </ul>
			    </div>
			</div>
                
            </div>
            <div class="priced">
            
                <h3 class="name-phone">${detail.productName}</h3>
				<h4 class="price">${detail.unitPrice}đ</h4> <span><del>${detail.oldPrice}</del></span>
                <div class="chose-memories">
                    <p><b>Chọn dung lượng</b></p>
                    <div class="chose-memory chose">
                        <input type="radio" class="check-radio-memory" id="chose1">
						<label for="myCheckbox">64Gb</label>
                    </div>
                    <div class="chose-memory chose">
                        <input type="radio" class="check-radio-memory" id="chose2">
                        <label for="myCheckbox" >128Gb</label>
                    </div>                    
                </div>
               
                <div class="chose-colors">
                    <p><b>Chọn màu</b></p>
                    <div class="chose chose-color">
                        <input type="radio" class="check-radio-color">
                        <label for="myCheckbox" >Đen</label>
                        <h6 class="price">11.000.000đ</h6>
                    </div>
                    <div class="chose chose-color">
                        <input type="radio" class="check-radio-color" >
                        <label for="myCheckbox" >Trắng</label>
                        <h6 class="price">12.890.000đ</h6>
                    </div>        
                    <div class="chose chose-color">
                        <input type="radio" class="check-radio-color" >
                        <label for="myCheckbox" >Vàng gold</label>
                        <h6 class="price">12.890.000đ</h6>
                    </div> 
                    <div class="chose chose-color">
                        <input type="radio" class="check-radio-color">
                        <label for="myCheckbox" >Xanh</label>
                        <h6 class="price">12.890.000đ</h6>
                    </div>             
                </div>
                <div class="pay">
                    <input type="button" class="button-pay button-pay-now" id="button-pay-now" value="Thanh toán ngay"><br>
                    <input type="button" class="button-pay button-installment" id="button-installment" value="Trả góp"><br>
                    <input type="button" class="button-pay button-pay-later" id="button-pay-later" value="Thanh toán khi nhận hàng"><br><br>
                    <button type="button" class="button-add button-add-to-card" id="button-add-to-card" value="Thêm vào giỏ hàng">Thêm vào giỏ hàng <i class="fa fa-shopping-cart"></i></button>
                    <br>
                   <c:forEach items="${gift}" var="g">
                    	<p class="gom"><i class="fa fa-check-circle"></i> ${g.giftName}</p>
                    </c:forEach>

                </div>
            </div>
            <div class="guarantee">
                <p class="guarant"><b>Bảo hành 12 tháng</b></p>
                <p class="guarant"><i class="fa fa-shield"></i> Bảo hành 12 tháng</p>
                <p class="guarant"><i class="fa fa-shield"></i> Hỗ trợ 1 đổi 1 trong 30 ngày</p>
            </div>
            <div class="news">
            <c:forEach items="${newss}" var="n">
        		<p class="gioithieu-p">${n.pnews}</p>
        	</c:forEach>
            </div>
            <div class="information">
                <p class="infor-item"><b>Thông số kĩ thuật của <a href="#">${detail.productName}</a></b></p>
                <img class="info-img" src="${detail.img }" alt="${detail.productName}">
                <div class="info-text">
                <c:forEach items="${de }" var="dem">
                    <p><b>Công nghệ màn hình:</b> ${dem.screenTechnology}</p>
                    <%-- <p><b>Tần số quét:</b> ${de.}</p> --%>
                    <p><b>Kích thước màn hình:</b> ${dem.screenResolution}</p>
                    <p><b>Hệ điều hành: </b>${dem.operatingSystem}</p>
                    <p><b>Vi xử lý: </b>${dem.processor }</p>
                    <!-- <p><b>Sim: </b>1 nano SIM và 1 eSIM</p> --></c:forEach>
                </div>
                <input type="button" class="button-show-infor" id="button-show-infor" value="Xem chi tiết">
            </div>
        </div>
        <%@ include file="footer.jsp"%>