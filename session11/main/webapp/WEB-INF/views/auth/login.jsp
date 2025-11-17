<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/18/2025
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <c:if test="${not empty message}">
        <script>
            alert("${message}");
        </script>
    </c:if>

    <form:form action="/auth/login" modelAttribute="userLogin" method="post">
        <form:input path="username" placeholder="Username"/>
        <form:errors path="username" cssClass="error"/>

        <form:input path="password" type="password" placeholder="Password"/>
        <form:errors path="password" cssClass="error"/>

        <button type="submit">Login</button>
    </form:form>
    <div class="footer">
        <p>© 2025 Your Company</p>
    </div>
</div>
</body>
</html>
