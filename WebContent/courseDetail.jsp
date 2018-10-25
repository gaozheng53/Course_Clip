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
	<h1>Course Detail</h1>
	<br>
	<br>
	<p>Course Name: ${course.name}</p>
	<p>Course Description: ${course.description}</p>
	<p>Course Lecturer: </p>
	<c:forEach items="${professorList}" var="professor">
		<p>- <a href="${professor[1]}">${professor[0]}</a></p>
	</c:forEach>

	<table border="1">
		<tr>
			<th>username</th>
			<th>content</th>
			<th>file list</th>
			<th>create time</th>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.username}</td>
				<td>${comment.content}</td>
				<td>
				<table>
						<c:forEach items="${comment.fileList}" var="file">
							<a href="/OOAD-Project/downloadfile?filename=${file.fileName}"><tr>[${file.fileName}]</tr></a>
						</c:forEach>
					</table>
				 </td>			 
				<td>${comment.createTime}</td>			
			</tr>
			<br>
		</c:forEach>
	</table>
	
	<p>Add Your Comment</p>
	<form action = "addcomment.do" name="commentForm" method="post" enctype="multipart/form-data">
    	<textarea id="contentText" class="text" cols="70" rows ="8" name="contentText"></textarea>
    	<input type="hidden" value="${course.id}" name = "courseId">
    	<input type="hidden" value="${course.name}" name = "courseName">
    	
		<br>
		<input type="file" value="Attach File" name = "fileName" multiple>
   		<input type="submit" value="Submit" class="submitButton">
	</form>
</body>
</html>