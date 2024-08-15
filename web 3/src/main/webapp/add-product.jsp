<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<style>
	.hide {
		display: none;
	}
</style>
<body>
    <div class="container my-5">
        <h1>Thêm sản phẩm mới</h1>

        <form action="addProduct" onsubmit="return thensubmit()" method="post">
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
            <div class="form-group">
                <label for="quantity">Màu:</label>
                <table id="tableColor">
                	<thead>
                		<tr>
                			<th>Tên</th>
                			<th>Ảnh</th>
                			<th>Hành động</th>
                		</tr>
                	</thead>
                	<tbody>
                		<tr stt="1">
                			<td>
                				<input name="nameColors" type="text" required />
                			</td>
                			<td>
                				<input name="imageColors" type="text" required placeholder="Nhập đường dẫn ảnh" />
                			</td>
                			<td>
                				<button type="button" onclick="removeRow(this)">Xóa</button>
                			</td>
                		</tr>
                	</tbody>
                </table>
                <button type="button" id="btnAddColor">Thêm màu</button>
            </div>              
            <div class="form-group">
                <label for="quantity">Ram:</label>
                <table id="tableRam">
                	<thead>
                		<tr>
                			<th>Tên</th>
                			<th>Giá</th>
                			<th>Hành động</th>
                		</tr>
                	</thead>
                	<tbody>
                		<tr stt="1">
                			<td>
                				<input name="nameRams" type="text" required />
                			</td>
                			<td>
                				<input name="priceRams" type="number" required />
                			</td>
                			<td>
                				<button type="button" onclick="removeRow(this)">Xóa</button>
                			</td>
                		</tr>
                	</tbody>
                </table>
                <button type="button" id="btnAddRam">Thêm ram</button>
            </div>            
            <div class="form-group">
				<label>Số lượng:</label>
				<table id="tableQuantity">
					<thead>
						<th>Ram</th>
						<th>Màu</th>
						<th>Số lượng</th>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
            <!-- <label for="productInformation">Thông tin sản phẩm:</label>
        	<textarea id="productInformation" name="productInformation" required></textarea><br> -->
            <button type="submit" class="btn btn-primary">Lưu</button>
            <a class="btn btn-danger text-light" href="` + pageContext.request.contextPath}/admin.jsp#showProduct">Thoat</a>
        </form>
    </div>
    <script>
		var sttColor = 1;
		var sttRam = 1;
		var listColor = [1]
		var listRam = [1]
    	var btnAddColor = document.getElementById('btnAddColor');
    	var btnAddRam = document.getElementById('btnAddRam');
		var tableColor = document.getElementById('tableColor');
		var tableRam = document.getElementById('tableRam');
		onload = () => {
			btnAddColor.onclick = () => {
				// Tạo một DocumentFragment để chứa các phần tử mới
				const fragment = document.createDocumentFragment();

				// Tạo một tr mới
				const row = document.createElement('tr');

				// Thêm nội dung vào tr mới
				row.innerHTML = `
               		<tr>
						<td>
							<input name="nameColors" type="text" required />
						</td>
						<td>
							<input name="imageColors" type="text" required placeholder="Nhập đường dẫn ảnh" />
						</td>
						<td>
							<button type="button" onclick="removeRow(this)">Xóa</button>
						</td>
					</tr>
				`;

				row.setAttribute('stt', ++sttColor)

				// Thêm hàng mới vào DocumentFragment
				fragment.appendChild(row);

				// Thêm DocumentFragment vào tbody của bảng
				tableColor.querySelector('tbody').appendChild(fragment);

				listColor = [...listColor, sttColor]

				addRowQuantity()
			}
			btnAddRam.onclick = () => {
				// Tạo một DocumentFragment để chứa các phần tử mới
				const fragment = document.createDocumentFragment();

				// Tạo một tr mới
				const row = document.createElement('tr');

				// Thêm nội dung vào tr mới
				row.innerHTML = `
					<tr>
						<td>
							<input name="nameRams" type="text" required />
						</td>
						<td>
							<input name="priceRams" type="number" required />
						</td>
						<td>
							<button type="button" onclick="removeRow(this)">Xóa</button>
						</td>
					</tr>
				`;

				row.setAttribute('stt', ++sttRam)

				// Thêm hàng mới vào DocumentFragment
				fragment.appendChild(row);

				// Thêm DocumentFragment vào tbody của bảng
				tableRam.querySelector('tbody').appendChild(fragment);

				listRam = [...listRam, sttRam]

				addRowQuantity()
			}
		}
		function addRowQuantity() {
			let table = document.querySelector('#tableQuantity')
			if (listRam.length == 0 || listColor.length == 0)
				table.querySelector('tbody').innerHTML = ''
			else {
				for (let i = 0; i < listRam.length; i++) {
					for (let j = 0; j < listColor.length; j++) {
						let element = document.querySelector(`tr[sttColor="` + listColor[j] + `"][sttRam="` + listRam[i] + `"]`);
						if (element) continue;
						const rowQuantity = document.createElement('tr');
						const nameRam = document.querySelector(`#tableRam tbody tr[stt="` + listRam[i] + `"] input[name="nameRams"]`).value
						const nameColor = document.querySelector(`#tableColor tbody tr[stt="` + listColor[j] + `"] input[name="nameColors"]`).value
						rowQuantity.innerHTML = `
							<tr>
								<td class="hide">
									<input type="text" require name="quantity-rams-name" value="` + nameRam + `"/>
									<input type="text" require name="quantity-colors-name" value="` + nameColor + `"/>
								</td>
								<td class="nameRam">
									` + nameRam + `
								</td>
								<td class="nameColor">
									` + nameColor + `
								</td>
								<td>
									<input name="quantity-count" min="0" type="number" value="0" />
								</td>
							</tr>
						`;
						rowQuantity.setAttribute('sttColor', listColor[j])
						rowQuantity.setAttribute('sttRam', listRam[i])
						if (j == 0 && i == 0) 
							table.querySelector('tbody').appendChild(rowQuantity)
						else if (j == 0)
							document.querySelector(`tr[sttColor="` + listColor[listColor.length - 1] + `"][sttRam="` + listRam[i-1] + `"]`).insertAdjacentElement('afterend', rowQuantity);
						else
							document.querySelector(`tr[sttColor="` + listColor[j - 1] + `"][sttRam="` + listRam[i] + `"]`).insertAdjacentElement('afterend', rowQuantity);
					}
				}
			}
			document.querySelectorAll('input[name="nameRams"]').forEach(item => item.onkeyup = (event) => {
				let element = event.target
				let stt = element.parentNode.parentNode.getAttribute('stt')
				for (let index of listColor) {
					document.querySelector(`tr[sttColor="` + index + `"][sttRam="` + stt + `"] .nameRam`).innerHTML = element.value
					document.querySelector(`tr[sttColor="` + index + `"][sttRam="` + stt + `"] input[name="quantity-rams-name"]`).value = element.value
				}
			});
			document.querySelectorAll('input[name="nameColors"]').forEach(item => item.onkeyup = (event) => {
				let element = event.target
				let stt = element.parentNode.parentNode.getAttribute('stt')
				for (let index of listRam) {
					document.querySelector(`tr[sttColor="` + stt + `"][sttRam="` + index + `"] .nameColor`).innerHTML = element.value
					document.querySelector(`tr[sttColor="` + stt + `"][sttRam="` + index + `"] input[name="quantity-colors-name"]`).value = element.value
				}
			});
		}
		function removeRow(element) {
			let stt = element.parentNode.parentNode.getAttribute('stt');
			let id = element.parentNode.parentNode.parentNode.parentNode.getAttribute('id')
			element.parentNode.parentNode.remove()
			if (id === 'tableColor') {
				listColor = listColor.filter(item => item != stt);
				document.querySelectorAll('#tableQuantity tbody tr').forEach(item => {if (item.getAttribute('sttColor') == stt) item.remove()})
			}
			else { 
				listRam = listRam.filter(item => item != stt);
				document.querySelectorAll('#tableQuantity tbody tr').forEach(item => {if (item.getAttribute('sttRam') == stt) item.remove()})
			}
		}
		function thensubmit() {
			if( tableRam.querySelectorAll('tbody tr').length > 0 && tableColor.querySelectorAll('tbody tr').length > 0)
				return true;
			alert('Can it nhat 1 hang mau va 1 hang ram')
			return false;
		}
		
		addRowQuantity()
	</script>
</body>
</html>