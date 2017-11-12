<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div id = "ordersBody">
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>Name</th>
            <th>Second Name</th>
            <th>Passport Number</th>
            <th>E-mail</th>
            <th></th>
            <c:forEach items = "${users}" var = "user">
        <tr>
            <td>${user.getName()} </td>
            <td>${user.getSureName()} </td>
            <td>${user.getPhoneNumber()} </td>
            <td>${user.getEmailAdress()} </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



</body>
</html>
