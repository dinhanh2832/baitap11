<%--
  Created by IntelliJ IDEA.
  User: anh
  Date: 29/11/2021
  Time: 11:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <style>
        .message{
            color: aqua;
        }
    </style>
</head>
<body>
<h1>Create new product</h1>
<p>
    <a href="/products">Back list product</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post" >
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Tên: </td>
                <td><input type="text" name="Ten" id="name"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="number" name="gia" id="gia"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td><input type="text" name="Nhasanxuat" id="nhasx"></td>
            </tr>
            <tr>
                <td></td>
                <td><button>Thêm</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
