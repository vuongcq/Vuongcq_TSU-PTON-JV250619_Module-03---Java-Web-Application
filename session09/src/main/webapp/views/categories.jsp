<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/6/2025
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listCategories}" varStatus="loop" var="catalog">
            <tr>
                <td>${loop.index+1}</td>
                <td>${catalog.catalogId}</td>
                <td>${catalog.catalogName}</td>
                <td>${catalog.description}</td>
                <td>${catalog.status?"Hoạt động":"Không hoạt động"}</td>
                <td></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%--Hien thi cac trang--%>
<div>
    <c:forEach items="${listPages}" var="page">
        <a href="<%=request.getContextPath()%>/categoriesController/findAll?page=${page}">${page}  </a>
    </c:forEach>
</div>
<div>
    <a href="<%=request.getContextPath()%>/categoriesController/initCreate">Create new catatalog...</a>
</div>

</body>
</html>
