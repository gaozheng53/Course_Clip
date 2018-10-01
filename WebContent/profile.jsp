<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
<h1>Profile</h1>
<br>
<p>Welcome ${user.username}!</p>
<p>Contact me: ${user.email}</p>

<h2>Comment History</h2>
<table border="1">
		<tr>
			<td>Course Name</td>
			<td>Content</td>
			<td>Create Time</td>
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