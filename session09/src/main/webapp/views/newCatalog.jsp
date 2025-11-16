<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/6/2025
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Catalog</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/categoriesController/create" method="post">
        <label for="catalogName">Catalog Name</label>
        <input type="text" id="catalogName" name="catalogName"/><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description"/><br>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
