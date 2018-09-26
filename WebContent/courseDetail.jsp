<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Detail</title>
</head>
<body>
	Course Detail
	<br>
	<br>
	<p>course name = ${course.name}</p>
	<p>course description = ${course.description}</p>


	<br>
	<br>
	<table border="1">
		<tr>
			<th>username</th>
			<th>content</th>
			<th>attachment</th>
			<th>create time</th>
		</tr>
		<c:forEach items="${commentList}" var="comment">

			<tr>
				<td>${comment.username}</td>
				<td>${comment.content}</td>
				<td>${comment.attachment}</td>
				<td>${comment.createTime}</td>
			</tr>
			<br>
		</c:forEach>
	</table>
</body>
</html>