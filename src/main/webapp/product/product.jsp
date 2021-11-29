<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 29/11/2021
  Time: 3:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products">Back list product</a>
</p>
<table>
    <tr>
        <td>Tên: </td>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <td>Giá: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Nhà sản xuất: </td>
        <td>${requestScope["product"].getProducer()}</td>
    </tr>
</table>
</body>
</html>
