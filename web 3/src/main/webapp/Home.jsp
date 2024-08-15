<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<body>
	<div class="items2 item nav">
        <div class="list-group">
        	<c:forEach items="${ListC}" var="c">
            	<a href="category?id=${c.id}" class="list-group-item list-group-item-action list-group-item-success 
            	${tag == c.id ? "active" : ""}">${c.categoryName}</a>
        	</c:forEach>
        </div>
    </div>
    <div class="items3 item contents content-menu">
        <div class="banner-content">
            <input class="button-back-banner" type="button" id="flip" value="&lt">
            <div class="panel"><img class="emg" src="https://mir-s3-cdn-cf.behance.net/project_modules/1400_webp/f3832e180145769.6505ae76214ca.jpg" alt=""></div>
            <div class="panel"><img class="emg"  src="https://images.macrumors.com/article-new/2023/08/iPhone-15-Blue-Three-Quarters-Perspective-Feature-2.jpg" alt=""></div>
            <div class="panel"><img class="emg" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLbjJ7V74vIEYBQAOH3akynXRIzIykiESLkNHBkyBP&s" alt=""></div>
            <input class="button-next-banner" type="button" id="flop" value="&gt">
            <div class="danhsach"> 	
                <ul class="uu">
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
        <div class="promotion">
            <div class="list-promotion">
                <label for="" class="text-promotion"><b>Khuyen mai</b></label>
	               <c:forEach items="${Top1}" var="o">
		                <div class="container-promotion">
		                    <div class="goods-promotion">
		                        <a href="#">
		                        <img width="100px" height="150px" src="${o.img }" alt="">
		                        <h5 style="color: red;">${o.unitPrice}</h5>
		                        <p>${o.productName}</p>
		                        </a>
		                    </div>
		                </div>
	                </c:forEach>
            </div>
        </div>
        <div class="container">
				<div class="row row-cols-1 row-cols-md-5 g-4">
				<c:forEach items="${listP}" var="o">
					
		                <div class="col">
		                <a href="detail?pid=${o.id}" title="${o.productName}">
			                  <div class="card h-100">
			                    <img src="${o.img}" class="card-img-top" alt="${o.productName}" title="${o.productName}">
			                    <div class="card-body">
			                     	<h5 class="card-text" >${o.productName}</h5>
									<p class="text-danger"><b>${o.unitPrice}</b></p>
								</div>
			                  </div>
			                  </a>
		                </div>
	                
                </c:forEach>
              </div>
        </div>
    </div>  
        <%@ include file="footer.jsp"%>