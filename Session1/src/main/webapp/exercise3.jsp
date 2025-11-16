<%@ page import="com.ra.session1.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sora_Windows
  Date: 10/15/2025
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border: 1px solid #ddd;
        border-collapse: collapse;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    img {
        border-radius: 50%; /* Làm cho hình ảnh tròn */
        border: 2px solid #ddd; /* Viền cho hình ảnh */
    }
</style>
<head>
    <title>Customer Table</title>
</head>
<body>
<h1>Customer List</h1>
<table>
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>DATE OF BIRTH</th>
        <th>ADDRESS</th>
        <th>IMAGE</th>
    </tr>
    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
        if (customers != null) {
            int index = 1;
            for (Customer customer : customers) {
    %>
    <tr>
        <td><%= index++ %>
        </td>
        <td><%= customer.getName() %>
        </td>
        <td><%= customer.getDateOfBirth() %>
        </td>
        <td><%= customer.getAddress() %>
        </td>
        <td><img width="100" height="100" src="<%= customer.getImage() %>" alt=""></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5" style="text-align: center;">No customers found.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
