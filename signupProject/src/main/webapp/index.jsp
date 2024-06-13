<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
    <form action="register" method="post">
    <h3>Name :<input type="text" name="name" placeholder="Enter name"/></h3>
    <h3>Email :<input type="email" name="email" placeholder="Enter email"/></h3>
    <h3>Password :<input type="password" name="password" placeholder="Password"/></h3>
    <h3>Gender :<input type="radio" name="gender" value="M"/>Male
                <input type="radio" name="gender" value="F"/>Female
                <input type="radio" name="gender" value="O"/>Others</h3>
    <h3>Select your city:<select name="city">
        <option value="Jharkhand">Jharkhand</option>
        <option value="Delhi">Delhi</option>
        <option value="Hariyana">Hariyana</option>
        <option value="Bihar">Bihar</option>
        </select></h3>
    <input type="submit" value="Register"/>
    </form>
    <p>Already registered?<a href="./login.jsp">Login</a></p>

</body>
</html>