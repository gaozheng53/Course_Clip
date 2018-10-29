<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Management</title>
</head>
<body>
<h1>Manage Course</h1>

<input type = "" id = "newCourseId" value = "${newCourseId}">
<a href="courseAdd.jsp" id = "addCourse">Add New Course</a>
<table border="1" id="courseTable">
		<tr>
			<td>id</td>
			<td>course.name</td>
			<td>number</td>
			<td>description</td>
			<td>track</td>
			<td>Operation</td>
		</tr>
		
		<c:forEach items="${courseList}" var="course">

			<tr class="tableContent">
				<td>${course.id}</td>
				<td><a href="course.do?id=${course.id}">${course.name}</a></td>
				<td>${course.number}</td>
				<td>${course.description}</td>
				<td>${course.track}</td>
				<td><a id="edit${course.id}" href="editCourse.do?id=${course.id}">Edit</a>&nbsp;&nbsp;<a id="delete${course.id}"href="deleteCourse.do?id=${course.id}">Delete</a></td>
			</tr>
			<br>
		</c:forEach>
	</table>

</body>
</html>