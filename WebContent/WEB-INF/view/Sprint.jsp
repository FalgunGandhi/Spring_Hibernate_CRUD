<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border=1>
		<tr>
			<td>id</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>user name</td>
			<td>password</td>
			<td colspan="2">Action</td>
		</tr>
<c:forEach items="${is}" var="p">
<tr>
<td>${p.id }</td>
<td>${p.fn }</td>
<td>${p.ln }</td>
<td>${p.un}</td>
<td>${p.pwd}</td>
<td><a href="delete.html?x=${p.id}">delete</a></td>
<td><a href="edit.html?y=${p.id}">edit</a></td>
</tr>		
</c:forEach>
</table>
</body>
</html>