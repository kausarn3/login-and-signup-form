<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">LOGIN PAGE</h1>
<center>
<table>
<form action="Login" method ="post">
<tr><td>UserName:</td><td><input type="text" name="uid"></td></tr><br><br>
<tr><td>Password:</td><td><input type="password" name="pwd"></td></tr><br><br>
</table><br>
<input type="submit" value="LogIn"></form>
<table>
<tr><td><form action="createaccount.jsp" method="post"></td></tr>
<tr><td><p>Dont have account  </p></td>
<td><input type="submit" value="create account"></td></tr>
</table>
</form>

</center>
</body>
</html>