<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/18/2025
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<c:if test="${not empty message}">
    <div class="message">
        <script>
            alert("${message}");
        </script>
    </div>
</c:if>
<h2>Danh Sách Sản Phẩm</h2>
<div class="button-container">
    <button><a href="/products/add">Thêm mới sản phẩm</a></button>
    <button><a href="/auth/logout">Đăng xuất</a></button>
</div>
<div class="search-container">
    <form action="/products" method="get">
        <input type="text" name="searchNameProduct" placeholder="Tìm kiếm sản phẩm" value="${search}">
        <button type="submit">Tìm kiếm</button>
    </form>
</div>
<table>
    <tr>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Số Lượng</th>
        <th>Hình Ảnh</th>
        <th>Trạng Thái</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td><img src="${product.image}" alt="${product.productName}"/></td>
            <td>${product.status ? 'Còn bán' : 'Ngừng bán'}</td>
            <td>
                <button style="background-color: orangered"><a href="/products/edit/${product.id}">Sửa</a></button>
                <button style="background-color: red"><a href="/products/delete/${product.id}"
                                                         onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm này chứ?')">Xóa</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
