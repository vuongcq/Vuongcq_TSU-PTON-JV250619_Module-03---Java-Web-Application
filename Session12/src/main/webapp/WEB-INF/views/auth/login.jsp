<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form {
            display: flex;
            flex-direction: column;
        }
        .form input {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form button {
            padding: 10px;
            background-color: #5cb85c;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }
        .form button:hover {
            background-color: #4cae4c;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Đăng nhập</h1>
    <form:form action="/auth/login" method="post" class="form" modelAttribute="customer">
        <form:input path="email" placeholder="Email"  />
        <form:errors path="email" cssClass="error"/>
        <br>

        <form:input type="password" path="password" placeholder="Mật khẩu"  />
        <form:errors path="password" cssClass="error"/>
        <button type="submit">Đăng nhập</button>
    </form:form>

    <c:if test="${not empty message}">
        <script>
            alert("${message}")
        </script>
    </c:if>
</div>
</body>
</html>