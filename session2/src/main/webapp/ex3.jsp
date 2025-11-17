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
    <title>Máy tính đơn giản</title>
</head>
<body>
<h1>Máy Tính Đơn Giản</h1>
<form action="ex3" method="post">
    <label for="first-number">Số thứ nhất:</label>
    <input type="text" name="first-number" id="first-number" required>
    <label for="second-number">Số thứ hai:</label>
    <input type="text" name="second-number" id="second-number" required>
    <label for="operator">Phép tính:</label>
    <select name="operator" id="operator">
        <option value="+">Cộng</option>
        <option value="-">Trừ</option>
        <option value="*">Nhân</option>
        <option value="/">Chia</option>
    </select>
    <input type="submit" value="Tính toán">
</form>
</body>
</html>
