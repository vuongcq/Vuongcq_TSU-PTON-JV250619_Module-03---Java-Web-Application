<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/6/2025
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Catalog Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listProducts}" var="product" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.catalog.catalogName}</td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
