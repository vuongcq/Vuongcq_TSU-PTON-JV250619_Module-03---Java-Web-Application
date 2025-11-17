<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/17/2025
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>

<form method="post" action="${pageContext.request.contextPath}/ex4/add">

    <label>Tên sản phẩm:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Mô tả:</label><br>
    <textarea name="description" required></textarea><br><br>

    <label>Giá:</label><br>
    <input type="number" name="price" required><br><br>

    <label>Ảnh (URL):</label><br>
    <input type="text" name="image" required><br><br>

    <button type="submit">Thêm mới</button>
</form>

<p>
    <a href="${pageContext.request.contextPath}/ex4">Quay lại danh sách</a>
</p>

</body>
</body>
</html>
