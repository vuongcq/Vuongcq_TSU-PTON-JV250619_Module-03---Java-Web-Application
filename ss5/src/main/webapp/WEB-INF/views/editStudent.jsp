<%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 11/17/2025
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sinh viên</title>
</head>
<body>
<h2>Sửa Sinh Viên</h2>

<form action="/students/edit/${student.id}" method="POST">
    <label for="studentName">Tên:</label>
    <input type="text" id="studentName" name="studentName" value="${student.studentName}" required/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${student.email}" required/>

    <label for="birthday">Ngày Sinh:</label>
    <input type="date" id="birthday" name="birthday" value="${student.birthday}" required/>

    <label for="avgMark">Điểm Trung Bình:</label>
    <input type="number" id="avgMark" step="0.01" name="avgMark" value="${student.avgMark}" required/>

    <button type="submit">Cập Nhật</button>
</form>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
