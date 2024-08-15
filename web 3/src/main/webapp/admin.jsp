<%@page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import="java.util.List, entity.Product, dao.DAO" %>
<%@ page import="java.util.List, context.DBContext, controll.AdminControll, controll.adminShowControll, dao.DAO, entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery_new.js"></script>
    <link rel="stylesheet" href="admin.css">

    <title>Administrator</title>
</head>
<body>
    <div class="header">
        <div class="menu menu-head">
            <ul class="nav justify-content-end navbar bg-dark border-bottom border-body" data-bs-theme="dark">
                <li class="nav-item">
                    <a class="nav-link" href="#">Account
                        <i class="fa fa-user na" title="Cá nhân"></i>
                    </a>
                </li>
                
            </ul>
        </div>
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" style="border-right: 1px solid #c3c3c3; padding-right: 20px;" href="${pageContext.request.contextPath}/Home.jsp" >
                <img class="logo-it" src="LoGo_ITPLUS__1_-removebg.png" width="30px" height="50px">
                <i  title="Logo"><b>Mobile Smart</b> - Administrator</i></a>
            <form class="form-inline" style="margin-right: 20px;" >
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-secondary" type="submit">Search</button>
            </form>
            <a class="oders nav-chose" href="#" style="border-right: 1px solid #c3c3c3;">Đơn hàng</a>
            <a class="nav-chose contact" href="#">Liên hệ</a>
        </nav>
    </div>
    <div class="menu-content">
        <div class="form-menu">
            <ul>
                <li class="form-menu-trang-chu fo " data-show-item="trang-chu">Trang chủ Admin</li>
                <li class="form-menu-danh-muc fo">Quản lý Sản phẩm
                    <ul class="form-menu-child">
                        <li class="menu-child child-item" data-show-item="loai-danh-muc">Loại danh mục</li>
                        <li class="menu-child child-item" data-show-item="san-pham">Sản phẩm</li>
                        <li class="menu-child child-item" data-show-item="chi-tiet">Chi tiết sản phẩm</li>
                    </ul>
                </li>
				
                <li class="form-menu-ql-khach-hang fo">Quản lý khách hàng
                    <ul class="form-menu-child">
                        <li class="menu-child child-item" data-show-item="danh-sach-khach-hang">Danh sách khách hàng</li>
                        <li class="menu-child child-item" data-show-item="danh-sach-don-hang">Danh sách đơn hàng</li>
                        <li class="menu-child child-item" data-show-item="khach-hang-lien-he">Khách hàng liên hệ</li>
                    </ul>
                </li>
                <li class="form-menu-ql-user fo">Quản lý User
                    <ul class="form-menu-child">
                        <li class="menu-child child-item" data-show-item="quan-ly-user">Quản lý User</li>
                        <li class="menu-child child-item" data-show-item="danh-sach-quyen">Danh sách quyền</li>
                        <li class="menu-child child-item" data-show-item="thong-tin-user">Thông tin User</li>
                        <li class="menu-child child-item" >Thoát</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="show-form-menu">
            <div id="trang-chu" class="form-menu-danh-muc-item sho show-item">
                <div class="home-admin">
                    <h3 class="alert-adimin">Nếu cần hỗ trợ kĩ thuật vui lòng liên hệ thông tin sau</h3>
                    <p class="send-email">Gửi eMail đến kỹ thuật: <span class="mail al">alernwad113@gmail.com</span></p>
                    <p class="send-phone">Hoặc gọi đến hotLine: <span class="phone al">0333.333.333</span></p>
                    <p> Xin chân thành cám ơn đã sử dụng dịch vụ!</p>
                </div>
            </div>
            <div id="loai-danh-muc" class="form-menu-danh-muc-item sho">
                <div class="danh-muc-item show-item inn">
                    <div class="infor">
                        <h5 class="infor-text">Thông tin chung</h5>
                        <label for="imge">Hình ảnh: </label>
                        <input type="file" name="imge" id="imge" class="imge">
                        <br><br>

                        <label for="name">Tên sản phẩm: </label>
                        <input type="text" name="name" id="name" class="name" placeholder="Nhập tên sản phẩm"><br><br>

                        <label for="memory">Bộ nhớ: </label>
                        <select id="bo-nho-dien-thoai" class="memory" name="memory">
                            <option value="32">32Gb</option>
                            <option value="64">64Gb</option>
                            <option value="128">128Gb</option>
                            <option value="256">256Gb</option>
                            <option value="512">512Gb</option>
                            <option value="1024">1Tb</option>
                        </select><br><br>
                        <label for="title">Chọn loại: </label>
                        <select id="loai-dien-thoai" class="memory" name="title">
                            <option value="iPhone">iPhone</option>
                        </select><br><br>
                        <label for="price">Nhập giá: </label>
                        <input type="text" name="price" id="price" class="price" placeholder="Nhập giá tiền"><br><br>
                    </div>
                    <div class="infor-detailed">
                        <h5 class="detailed-text">Thông tin chi tiết sản phẩm</h5>
                        <form method="post">
                            <!-- <label for="productId">Mã sản phẩm:</label>
                            <input type="number" name="productId" required placeholder="Nhập mã sản phẩm"><br>
                     -->
                     <label for="screenTechnology">Công nghệ màn hình:</label>
                     <input type="text" id="screenTechnology" name="screenTechnology" required placeholder="Nhập công nghệ màn hình"><br>
                     
                     <label for="screenResolution">Độ phân giải màn hình:</label>
                     <input type="text" id="screenResolution" name="screenResolution" required placeholder="Nhập độ phân giải màn hình"><br>
                     
                     <label for="glassQuality">Chất lượng kính:</label>
                     <input type="text" id="glassQuality" name="glassQuality" required placeholder="Nhập chất lượng kính"><br>
                     
                     <label for="screenSize">Kích thước màn hình:</label>
                     <input type="text" id="screenSize" name="screenSize" required placeholder="Nhập kích thước màn hình"><br>
                     
                     <label for="rearCameraResolution">Độ phân giải camera sau:</label>
                     <input type="text" id="rearCameraResolution" name="rearCameraResolution" required placeholder="Nhập độ phân giải camera sau"><br>
                     
                     <label for="frontCameraResolution">Độ phân giải camera trước:</label>
                     <input type="text" id="frontCameraResolution" name="frontCameraResolution" required placeholder="Nhập độ phân giải camera trước"><br>
                     
                     <label for="rearCameraDetails">Chi tiết camera sau:</label>
                     <input type="text" id="rearCameraDetails" name="rearCameraDetails" required placeholder="Nhập chi tiết camera sau"><br>
                     
                     <label for="videoRecordingCapability">Khả năng quay video:</label>
                     <input type="text" id="videoRecordingCapability" name="videoRecordingCapability" required placeholder="Nhập khả năng quay video"><br>
                     
                     <label for="cameraFeatures">Tính năng camera:</label>
                     <input type="text" id="cameraFeatures" name="cameraFeatures" required placeholder="Nhập tính năng camera"><br>
                     
                     <label for="processor">Bộ vi xử lý:</label>
                     <input type="text" id="processor" name="processor" required placeholder="Nhập bộ vi xử lý"><br>
                     
                     <label for="chip">Chip:</label>
                     <input type="text" id="chip" name="chip" required placeholder="Nhập chip"><br>
                     
                     <label for="operatingSystem">Hệ điều hành:</label>
                     <input type="text" id="operatingSystem" name="operatingSystem" required placeholder="Nhập hệ điều hành"><br>
                     
                     <label for="ram">RAM:</label>
                     <input type="text" id="ram" name="ram" required placeholder="Nhập RAM"><br>
                     
                     <label for="storage">Bộ nhớ trong:</label>
                     <input type="text" id="storage" name="storage" required placeholder="Nhập bộ nhớ trong"><br>
                     
                     <label for="mobileNetworkSupport">Hỗ trợ mạng di động:</label>
                     <input type="text" id="mobileNetworkSupport" name="mobileNetworkSupport" required placeholder="Nhập hỗ trợ mạng di động"><br>
                     
                     <label for="wifiSupport">Hỗ trợ Wi-Fi:</label>
                     <input type="text" id="wifiSupport" name="wifiSupport" required placeholder="Nhập hỗ trợ Wi-Fi"><br>
                     
                     <label for="bluetoothSupport">Hỗ trợ Bluetooth:</label>
                     <input type="text" id="bluetoothSupport" name="bluetoothSupport" required placeholder="Nhập hỗ trợ Bluetooth"><br>
                     
                     <label for="gpsSupport">Hỗ trợ GPS:</label>
                     <input type="text" id="gpsSupport" name="gpsSupport" required placeholder="Nhập hỗ trợ GPS"><br>
                     
                     <label for="connectivityPorts">Cổng kết nối:</label>
                     <input type="text" id="connectivityPorts" name="connectivityPorts" required placeholder="Nhập cổng kết nối"><br>
                     
                     <label for="batteryCapacity">Dung lượng pin:</label>
                     <input type="text" id="batteryCapacity" name="batteryCapacity" required placeholder="Nhập dung lượng pin"><br>
                            <input type="submit" value="Nhập" class="button-nhap">
                        </form>
                    </div>
                </div>
            </div>
            <div id="san-pham" class="form-menu-danh-muc-item sho">
                <div class="danh-muc-item show-item" id="showProduct">
                    <h5>Danh sách sản phẩm</h5>
                    <a href="${pageContext.request.contextPath}/add-product.jsp" class="btn btn-primary">Thêm sản phẩm</a> <!-- //Đường dẫn prje -->
					
                    <table class="table table-striped">
                    	<thead>
                			<tr>
                              <th>STT</th>
			                  <th>Tên</th>
			                  <th>Giá</th>
			                  <th>Số lượng</th>
			                  <th>RAM</th>
			                  <th>Màu</th>
			                  <th>Hành động</th>  
                            </tr>
            			</thead>
				            <tbody>
				                <%
				                	DAO dao = new DAO();
				                	List<Product> products = dao.getAllProductFullDetails();		
				                	pageContext.setAttribute("productsp", products);
				                	for (Product p : products) {
				                %>
									    <tr>
								        <td><%= p.getId() %></td>
								        <td><%= p.getProductName() %></td>
								        <td><%= p.getUnitPrice() + (p.getMemorys() == null || p.getMemorys().size() == 0 ? 0 : p.getMemorys().get(0).getPrice()) %></td>
								        <td><%= p.getQuantity() %></td>
								        								        <td><%= p.getMemorys() != null ? p.getMemorys().stream().map(item -> item.getMemory()).collect(Collectors.joining(" - ")) : "" %></td>
								        <td><%= p.getColors() != null ? p.getColors().stream().map(item -> item.getColor()).collect(Collectors.joining(" - ")) : "" %></td>
								        <td>
								            <a href="product-details.jsp?productId=<%= p.getId() %>" class="btn">Xem chi tiết</a>								        	
								            <a href="edit-information.jsp?productId=<%= p.getId() %>" class="btn btn-primary">Sửa</a>
								            <a href="#" class="btn btn-danger" onclick="deleteProduct(<%= p.getId() %>)">Xóa</a>
								        </td>
								    </tr>	
								<%
				                	}
				                %>
				            </tbody>
            
			                <script>
							    function deleteProduct(id) {
							        if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này?")) {
							            $.ajax({
							                url: "${pageContext.request.contextPath}/admin?id=" + id,
							                type: "DELETE",
							                success: function() {
							                    alert("Xóa sản phẩm thành công!");
							                    location.reload();
							                },
							                error: function() {
							                    alert("Xóa sản phẩm thất bại!");
							                }
							            });
							        }
							    }
							</script>
                      </table>
                </div>
            </div>
            <div id="chi-tiet" class="form-menu-danh-muc-item sho">
                <div class="danh-muc-item show-item">
                    <h5>Chi tiết sản phẩm</h5>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">Tên</th>
                              <th scope="col">Ảnh</th>
                              <th scope="col">Giá</th>  
                              <th scope="col">Bộ nhớ</th> 
                              <th scope="col">Chip</th>   
                              <th scope="col">Hệ điều hành</th>  
                              <th scope="col">Tác vụ</th>  
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Xem thêm</a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>fat</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Xem thêm</a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td >Larry the Bird</td>
                                <td>@twitter</td>
                                <td>ÁD</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Xem thêm</a>
                                </td>
                            </tr>
                      </table>
                </div>
            </div>
            <div id="danh-sach-khach-hang" class="form-menu-ql-khach-hang-item sho">
                <div class="ql-khach-hang-item show-item">
                    <h5>Danh sách khách hàng</h5>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">Tên</th>
                              <th scope="col">Điện thoại</th>
                              <th scope="col">địa chỉ</th>  
                              <th scope="col">email</th>  
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>as</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>fat</td>
                                <td>ggg</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td >Larry the Bird</td>
                                <td>@twitter</td>
                                <td>ÁD</td>
                                <td>dadsa</td>
                            </tr>
                      </table>
                </div>
            </div>
            <div id="danh-sach-don-hang" class="form-menu-ql-khach-hang-item sho">
                <div class="ql-khach-hang-item show-item">
                    <h5>Danh sách đơn hàng</h5>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">Mã đơn hàng</th>
                              <th scope="col">Tên khách hàng</th>
                              <th scope="col">Ngày đặt</th>  
                              <th scope="col">Trạng thái</th>  
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>as</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>fat</td>
                                <td>ggg</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td >Larry the Bird</td>
                                <td>@twitter</td>
                                <td>ÁD</td>
                                <td>dadsa</td>
                            </tr>
                      </table>
                </div>
            </div>
            <div id="khach-hang-lien-he" class="form-menu-ql-khach-hang-item sho">
                <div class="ql-khach-hang-item show-item">Đây là danh sách khách hàng liên hệ</div>
            </div>
            <div id="quan-ly-user" class="form-menu-ql-user-item sho">
                <div class="ql-user-item show-item">
                    <h5>Danh sách người dùng</h5>
                    <a href="#" class="btn btn-primary">Thêm User</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">Tên</th>
                              <th scope="col">Quyền hạn</th>
                              <th scope="col">Trạng thái</th>  
                              <th scope="col">Tác vụ</th>  
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Cập nhật</a>
                                    <a href="#" class="btn btn-danger">Xóa</a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>fat</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Cập nhật</a>
                                    <a href="#" class="btn btn-danger">Xóa</a>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td >Larry the Bird</td>
                                <td>@twitter</td>
                                <td>ÁD</td>
                                <td>
                                    <a href="#" class="btn btn-primary">Cập nhật</a>
                                    <a href="#" class="btn btn-danger">Xóa</a>
                                </td>
                            </tr>
                      </table>
                </div>
            </div>
            <div id="danh-sach-quyen" class="form-menu-ql-user-item sho">
                <div class="ql-user-item show-item">Đây là danh sách các quyền</div>
            </div>
            <div id="thong-tin-user" class="form-menu-ql-user-item sho">
                <div class="ql-user-item show-item">
                    <h5>Thông tin User</h5>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <th scope="col">#</th>
                              <th scope="col">Tên</th>
                              <th scope="col">Quyền hạn</th>
                              <th scope="col">Trạng thái</th>  
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>as</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>ggg</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td >Larry the Bird</td>
                                <td>@twitter</td>
                                <td>dadsa</td>
                            </tr>
                      </table>
                </div>
            </div>
        </div>
      </div>
    <script src="admin.js"></script>
</body>
</html>