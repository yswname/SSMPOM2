<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<c:forEach items="${userList}" var="_user" varStatus="_status">
    ${_status.index+1} -> ${_user.urUserName}->${_user.urName}-->${_user.urAge}<br/>
</c:forEach>
</body>
</html>