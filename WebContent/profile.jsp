<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>
<h1>User Info</h1>
<br>
<p>${user.username}</p>
<p>${user.email}</p>


<table border="1">
		<tr>
			<td>course name</td>
			<td>content</td>
			<td>create time</td>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.courseName}</td>
				<td>${comment.content}</td>
				<td>${comment.createTime}</td>
			</tr>
		</c:forEach>
</table>	
</body>
</html>