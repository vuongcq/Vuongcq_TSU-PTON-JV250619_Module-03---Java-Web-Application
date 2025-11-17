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
    <title>Kiểm tra độ tuổi</title>
</head>
<body>
<h1>Tuổi của bạn là : ${age}</h1>
<c:if test="${not empty age and age < 12}">
    <h1  class="css">Bạn là trẻ em</h1>
</c:if>

<c:if test="${not empty age and age >= 12 and age < 18}">
    <h1  class="css">Bạn là thiếu niên</h1>
</c:if>

<c:if test="${not empty age and age >= 18}">
    <h1 class="css">Bạn là người trưởng thành</h1>
</c:if>
</body>
</html>
