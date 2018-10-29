<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>

<script>
	function viewAndRemove(userid,courseid){
		var url="remove.do";
		var tempForm = document.createElement("form");
	    tempForm.id = "tempForm1";
	    tempForm.method = "post";
	    tempForm.action = url;
	    var hideInput1 = document.createElement("input");
	    hideInput1.type = "hidden";
	    hideInput1.name="userID"; 
	    hideInput1.value = userid;
	    var hideInput2 = document.createElement("input");
	    hideInput2.type = "hidden";
	    hideInput2.name="courseID"; 
	    hideInput2.value = courseid;
	    console.log(userid);
	    console.log(courseid);
	    document.body.appendChild(tempForm);
	    tempForm.submit();
	    document.body.removeChild(tempForm);
	}
</script>

<body>
<h1>Profile</h1>
<br>
<p>Welcome ${user.username}!</p>
<p>Contact me: ${user.email}</p>
<a href="javascript:history.go(-1)">Back</a>
<h2>Comment History</h2>
<table border="1">
		<tr>
			<td>Course Name</td>
			<td>Content</td>
			<td>File list</td>
			<td>Create Time</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${commentList}" var="comment">
			<tr id="comment${comment.commentId}">
				<td>${comment.courseName}</td>
				<td>${comment.content}</td>
				<td>
					<table>
						<c:forEach items="${comment.fileList}" var="file">
							<a href="/OOAD-Project/downloadfile?filename=${file.fileName}"><tr>[${file.fileName}]</tr></a>
						</c:forEach>
					</table>
				</td>
				<td>${comment.createTime}</td>
				<td><a href="/OOAD-Project/EditComment?comment=${comment.commentId}" id="edit${comment.commentId}"> Edit</a> | <a href="/OOAD-Project/DeleteComment?comment=${comment.commentId}"id="delete${comment.commentId}">Delete</a></td>
			</tr>
		</c:forEach>
</table>
<br>
<br>

<h2>New Comment Notification</h2>
<table border = "1">
		<tr>
			<td>Course Name</td>
			<td>View</td>
		</tr>
	<c:forEach items="${notificationList}" var="notification">
		<tr>
			<td><a href="course.do?id=${notification.id}">${notification.name}</a></td>
			<td>	
				<form action="remove.do" name = "removeForm" method = "post">
					<input type = "hidden" value = "${notification.id}" name = "courseID">
					<input type = "hidden" value = "${user.userId}" name = "userID">
					<button>View</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
	
</body>
</html>