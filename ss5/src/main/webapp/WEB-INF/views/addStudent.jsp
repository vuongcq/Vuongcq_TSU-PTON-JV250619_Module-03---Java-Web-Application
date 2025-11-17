<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/17/2025
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sinh viên</title>
</head>
<body>
<h2 style="text-align: center">Thêm Sinh Viên</h2>

<form action="/students/add" method="POST">
    <input type="hidden" name="id">
    <label for="studentName">Tên:</label>
    <input type="text" id="studentName" name="studentName" required/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/>

    <label for="birthday">Ngày Sinh:</label>
    <input type="date" id="birthday" name="birthday" required/>

    <label for="avgMark">Điểm Trung Bình:</label>
    <input type="number" id="avgMark" step="0.01" name="avgMark" required/>

    <button type="submit">Thêm</button>
</form>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
