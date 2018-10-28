<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Course Detail</title>


<style type="text/css">

html{   
    width: 100%;   
    height: 100%;   
    overflow: hidden;   
    font-style: sans-serif;   
}

body{   
    width: 100%;   
    height: 100%;   
    font-family: 'Open Sans',sans-serif;   
    margin: 0;   
    background-color: #727696;   
}

#detail{   
    position: absolute;   
    top: 26%;   
    left:26%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 300px;   
}

#detail h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: left;   
}

#table{
    margin: auto;
    width: 90%;
    margin-top: 260px;
    padding: 10px;
}

h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
} 

</style>


</head>


<body>
<div id="detail">
	<h1>Course Detail</h1>
	<br>
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
		<button>Subscribe</button>
	</form>
	
	<form action="unsubscribe.do" name = "unsubscribeForm" method = "post">
		<input type = "hidden" value = "${course.id}" name = "courseId">
		<button>Unsubscribe</button>
	</form>


	<p id = "alertm">${alertmessage}</p>
	<p id = "unalertm">${uns_alertmessage}</p>
	
	
	<p>Add Your Comment</p>
	<form action = "addcomment.do" name="commentForm" method="post" enctype="multipart/form-data">
    	<textarea id="contentText" class="text" cols="70" rows ="8" name="contentText"></textarea>
    	<input type="hidden" value="${course.id}" name = "courseId">
    	<input type="hidden" value="${course.name}" name = "courseName">
    	
		<br>
		<input type="file" value="Attach File" name = "fileName" multiple>
   		<input type="submit" value="Submit" class="submitButton">
	</form>
<div>
</body>
</html>