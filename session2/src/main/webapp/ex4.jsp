<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/17/2025
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/ex4/add">Thêm sản phẩm mới</a>
<h1>Danh sách sản phẩm</h1>
<table>
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>DESCRIPTION</th>
        <th>PRICE</th>
        <th>IMAGE</th>
        <th>ACTIONS</th>
    </tr>

    <c:forEach var="product" items="${products}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td><img src="${product.image}" alt=""></td>
            <td><a href="${pageContext.request.contextPath}/ex4/delete?id=${p.id}"
                   onclick="return confirm('Bạn có chắc muốn xoá?');">
                Xóa
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
