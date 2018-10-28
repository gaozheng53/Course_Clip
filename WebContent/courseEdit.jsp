<%@page import="po.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script>
function addInput(){
	$("#professor").append("<div>Name: &nbsp;<input type ='text' name = 'professorName' > Link: &nbsp;<input type ='text' name = 'professorLink'><input type='button' onclick='($(this).parent().remove())' value = 'x'><br></div>");
}

function remove(a){
	console.log(a);
	var id = "#pro" + a;
	$(id).remove();
}


</script>
</head>
<body>
<h1>Edit Course</h1>
<form class = "form" action="update.do">
<input type ="hidden" name = "id" value="${course.id}">
Name  <input type ="text" name = "name" value="${course.name}"><br>
Number  <input type ="text" name = "number" value="${course.number}"><br>
Description  <input type ="text" name = "description" value="${course.description}"><br>
Track  <input type ="text" name = "track" value="${course.track}"><br>
Professor:<input type="button" onclick="addInput()" value = "Add Professor"></input><div id = "professor"></div><br>
<c:forEach items="${professorList}" var="professorList">
<div class = "professorList" id = "pro${professorList.teachId}">
Name: <input type ="text" name = "professorName" value="${professorList.professorName}">
Link: <input type ="text" name = "professorLink" value="${professorList.professorLink}">
<input type="button" onclick="remove(${professorList.teachId})" value = "x"><br>
</div>

</c:forEach>

<input type="submit" value = "submit">
</form>
<!-- todo: Professor - add/edit/remove -->
</body>
</html>