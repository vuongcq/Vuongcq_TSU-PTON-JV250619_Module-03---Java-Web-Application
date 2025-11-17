<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/18/2025
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Thêm Sản phẩm</title>
</head>
<body>
<h2>Thêm Sản Phẩm Mới</h2>
<form:form action="/products/add" modelAttribute="product" method="post" enctype="multipart/form-data">
    <label for="productName">productName</label>
    <form:input path="productName" />
    <form:errors path="productName" cssClass="error"/>
    <br>
    <label for="price">price</label>
    <form:input path="price" type="number"/>
    <form:errors path="price" cssClass="error"/>
    <br>
    <label for="stock">stock</label>
    <form:input path="stock" />
    <form:errors path="stock" cssClass="error"/>
    <br>
    <label for="status">status</label>
    <form:select path="status" >
        <form:option value="true" >active</form:option>
        <form:option value="false" >inactive</form:option>
    </form:select>
    <br>
    <form:input path="image" type="file"/>
    <form:errors path="image" cssClass="error" />
    <br>
    <button type="submit">Thêm</button>
</form:form>
</body>
</html>
