<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 29/11/2021
  Time: 10:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<p>
    <a href="/products?action=create">Create new Product</a>
</p>
<p>
    <a href="/products?action=find">Find Product By Name</a>
</p>
<table border="1">
    <tr>
        <td>Tên</td>
        <td>Giá</td>
        <td>Nhà sản xuất</td>
        <td>Sửa</td>
        <td>Xóa</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/customers?action=edit&id=${product.getId()}">Sửa</a></td>
            <td><a href="/customers?action=delete&id=${product.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
