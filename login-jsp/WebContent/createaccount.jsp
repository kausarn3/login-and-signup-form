<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<style>table,tr,td{border-collapse:collapse}</style>
<table height=50% width=30%>
<script>window.history.forward();</script>
<form action="Createaccount" method ="post">
<tr><td>UserName:</td><td><input type="text" name="uid" placeholder="Enter Username" required></td></tr><br><br>
<tr><td>Password:</td><td><input type="password" name="pwd1" placeholder="Enter Password" required></td></tr><br><br>
<tr><td>Retype Password:</td><td><input type="text" name="pwd" placeholder="Retype Password" required></td><br><br>
</table><br><br>
<input type="submit" value="Submit">
</form>

</center>
</body>
</html>