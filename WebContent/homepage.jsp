<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Homepage</title>

<script type="text/javascript">

  function logout(){
  window.open("logout.do","_self");
  }

</script>

</head>

<body>

	<h1>登录成功</h1>

	欢迎${username}!
	<br>
	<br>

	<form method="post" action="logout.do">
		<input type="submit" value="退出" />
	</form>

	<br>
	<br>
	<table border="1">
		<tr>
			<td>id</td>
			<td>course.name</td>
			<td>number</td>
			<td>description</td>
			<td>track</td>
			<td>comment number</td>
		</tr>
		<c:forEach items="${couseList}" var="course">

			<tr>
				<td>${course.id}</td>
				<td><a href="course.do?id=${course.id}">${course.name}</a></td>
				<td>${course.number}</td>
				<td>${course.description}</td>
				<td>${course.track}</td>
				<td>${course.commentNum}</td>
			</tr>
			<br>
		</c:forEach>
	</table>
</body>

</html>

