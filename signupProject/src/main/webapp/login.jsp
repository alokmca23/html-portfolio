<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
    <form action="login" method="post">
    <h3>Email : <input type="email" name="email" placeholder="Enter email id"/></h3>
    <h3>Password : <input type="password" name="password" Placeholder="password"/></h3>
    <input type="submit" value="login"/>
    <p>Not registered?<a href="./index.jsp">Registration</a></p>
    </form>

</body>
</html>