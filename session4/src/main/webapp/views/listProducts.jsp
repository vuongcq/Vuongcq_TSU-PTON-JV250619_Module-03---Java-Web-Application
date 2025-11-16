<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 10/29/2025
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<form action="${pageContext.request.contextPath}/listProduct/search" method="get">
    <input type="search" name="searchProductName" value="${searchProductName}" placeholder="Input text...">
<button type="Submit">Search</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td>${p.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
