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
    <title>Cập nhật sản phẩm</title>
</head>
<body>
<h2>Cập Nhật Sản Phẩm</h2>
<c:if test="${not empty message}">
    <script>
        alert("${message}")
    </script>
</c:if>

<form:form action="/products/edit/${id}" modelAttribute="product" method="post" enctype="multipart/form-data">

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
    <p>Hình ảnh cũ:</p>
    <img src="${image}" alt="Hình ảnh sản phẩm cũ" width="150" height="150"/>
    <br>
    <button type="submit">Cập Nhật Sản Phẩm</button>
</form:form>
</body>
</html>
