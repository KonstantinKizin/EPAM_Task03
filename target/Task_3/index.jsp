<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div >
    <form method = "GET" action = "/users">
        <input type="hidden" value="search_user" name="hidden">
        <div class="form-group">
            <label ><b>Name</b></label>
            <input type="text" class="form-control"   name = "name">
        </div>
        <div class="form-group">
            <label><b>Surename</b></label>
            <input type="text" class="form-control"  name = "surename">
        </div>
        <button type="submit" class="btn btn-primary">search</button>
    </form>
</div>
</body>
</html>
