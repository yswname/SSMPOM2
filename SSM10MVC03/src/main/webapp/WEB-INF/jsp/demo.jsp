<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
Hello, ${name} 上午好！
<%
    System.out.println("4444444444444");
%>
<br/>
${sessionScope.user.userName},${sessionScope.user.name}<br/>
${requestScope.user.userName}
</body>
</html>