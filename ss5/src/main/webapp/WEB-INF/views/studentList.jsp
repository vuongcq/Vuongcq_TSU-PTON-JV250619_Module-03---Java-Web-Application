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
    <title>Danh sách sinh viên</title>
</head>
<body>
<script c:if="${not empty message}">
    alert('${message}');
</script>

<h2>Danh Sách Sinh Viên</h2>

<form method="GET" action="/students" id="formSearch">
    <input type="text" name="search" value="${search}" placeholder="Tìm kiếm..."/>
    <select name="sort">
        <option value="ASC" selected="${sort == 'ASC'}">Tăng dần</option>
        <option value="DESC" selected="${sort == 'DESC'}">Giảm dần</option>
    </select>
    <button type="submit">Lọc</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Ngày Sinh</th>
        <th>Điểm Trung Bình</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.email}</td>
            <td>${student.birthday}</td>
            <td>${student.avgMark}</td>
            <td>
                <a href="/students/edit/${student.id}">Sửa</a>
                <a href="/students/delete/${student.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a class="add-button" href="/students/add">Thêm Sinh Viên</a>
</body>
</html>
