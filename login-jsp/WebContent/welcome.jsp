<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="logout.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>window.history.forward();</script>
<%
if (session.getAttribute("a1")!=null)
%>
<h1 align="center">Welcome</h1>
<%
if (session.getAttribute("a1")==null){
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>