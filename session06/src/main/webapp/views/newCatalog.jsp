<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/30/2025
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/catalogController/create" method="post">
    <label for="catalogName">Catalog Name</label>
    <input type="text" id="catalogName" name="catalogName"/><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description"/><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
