<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/ProductController?flag=selectpro" method="post">
	<center><h1>Welcome to Job Work Mechanism</h1></center>
	<center><input type="submit" value="Lets Explore"></center>
	</form>
</body>
</html>