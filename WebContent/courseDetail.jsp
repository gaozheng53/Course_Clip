<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Detail</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script type="text/javascript">
	function validate(){
		var content = $('contentText').val();
		alert(content);
		var filecontent = $('fileName').val();
		alert(filecontent);
	}
</script>
</head>

<body>
	<h1>Course Detail</h1>
	<br>
	<a id="backHomepage" href="homepage.do">Back Homepage</a>
	<br>
	Welcome <a href="userinfo.do?id=${userid}">${username}</a>!
	<p>Course Name: ${course.name}</p>
	<p>Course Description: ${course.description}</p>
	<p>Course Lecturer: </p>
	<c:forEach items="${professorList}" var="professor">
		<p>- <a href="${professor[1]}">${professor[0]}</a></p>
	</c:forEach>

<a href="javascript:history.go(-1)">Back</a>

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
	
	<form action="subscribe.do" name = "subscribeForm" method = "post">
		<input type = "hidden" value = "${course.id}" name = "courseId">
		<button id = "subscribe">Subscribe</button>
	</form>
	
	<form action="unsubscribe.do" name = "unsubscribeForm" method = "post">
		<input type = "hidden" value = "${course.id}" name = "courseId">
		<button id = "unsubscribe">Unsubscribe</button>
	</form>


	<p id = "alertm">${alertmessage}</p>
	<p id = "unalertm">${uns_alertmessage}</p>
	
	
	<p>Add Your Comment</p>
	<form action = "addcomment.do" name="commentForm" method="post" enctype="multipart/form-data">
    	<textarea id="contentText" class="text" cols="70" rows ="8" name="contentText"></textarea>
    	<input type="hidden" value="${course.id}" name = "courseId">
    	<input type="hidden" value="${course.name}" name = "courseName">   	
		<br>
		<input type="file" value="Attach File" name = "fileName" id = "fileName" multiple>
   		<input type="button" value="Submit" id = "postcomment" onclick = "validate()" class="submitButton">
	</form>
</body>
</html>