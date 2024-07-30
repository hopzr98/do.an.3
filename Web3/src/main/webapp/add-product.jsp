<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container my-5">
        <h1>Thêm sản phẩm mới</h1>

        <form action="addProduct" method="post">
            <!-- <div class="form-group">
                <label for="id">ID:</label>
                <input type="number" class="form-control" id="id" name="id" required>
            </div> -->
            <div class="form-group">
                <label for="productName">Tên sản phẩm:</label>
                <input type="text" class="form-control" id="productName" name="productName" required>
            </div>
            <div class="form-group">
                <label for="productCategoryPath">Đường dẫn danh mục sản phẩm:</label>
                <input type="text" class="form-control" id="productCategoryPath" name="productCategoryPath" required>
            </div>
            <div class="form-group">
                <label for="img">Đường dẫn ảnh:</label>
                <input type="text" class="form-control" id="img" name="img" required>
            </div>
            <div class="form-group">
                <label for="unitPrice">Đơn giá:</label>
                <input type="number" class="form-control" id="unitPrice" name="unitPrice" required>
            </div>
            <div class="form-group">
                <label for="oldPrice">Đơn giá cũ:</label>
                <input type="number" class="form-control" id="oldPrice" name="oldPrice" required>
            </div>
            <div class="form-group">
                <label for="cid">ID danh mục:</label>
                <input type="text" class="form-control" id="cid" name="cid" required>
            </div>
            <div class="form-group">
                <label for="quantity">Số lượng:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required>
            </div>
            <!-- <label for="productInformation">Thông tin sản phẩm:</label>
        	<textarea id="productInformation" name="productInformation" required></textarea><br> -->
            <button type="submit" class="btn btn-primary">Lưu</button>
            <a class="btn btn-danger text-light" href="${pageContext.request.contextPath}/admin.jsp#showProduct">Thoat</a>
        </form>
    </div>
</body>
</html>