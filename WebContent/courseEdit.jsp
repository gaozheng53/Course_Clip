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



$( document ).ready(function() {
	$("#track").val("${course.track}");
});
function addInput(){
	$("#professor").append("<div>Name: &nbsp;<input type ='text' name = 'professorName' > Link: &nbsp;<input type ='text' name = 'professorLink'><input type='button' onclick='($(this).parent().remove())' value = 'x'><br></div>");
}

function remove(a){
	console.log(a);
	var id = "#pro" + a;
	$(id).remove();
}

function validate() {
	var name = document.getElementById("name");
	var number = document.getElementById("number");
	name = name.value;
	number = number.value;
	if (name.length == 0) {
		alert("course name cannot be null");
		return false;
	}
	if (number.length == 0) {
		alert("course number cannot be null");
		return false;
	}
	return true;
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
Track  <%-- <input type ="text" name = "track" value="${course.track}"> --%>
<select name = "track" id = "track">
	  <option value =""></option>
	  <option value ="DS">Data Sciences</option>
	  <option value ="IA">Information Assurance</option>
	  <option value="IS">Intelligent Systems</option>
	  <option value="IC">Interactive Computing</option>
	  <option value ="SYS">Systems</option>
	  <option value="TCS">Traditional Computer Science</option></select><br>
Professor:<input type="button" onclick="addInput()" value = "Add Professor"></input><div id = "professor"></div><br>
<c:forEach items="${professorList}" var="professorList">
<div class = "professorList" id = "pro${professorList.teachId}">
Name: <input type ="text" name = "professorName" value="${professorList.professorName}">
Link: <input type ="text" name = "professorLink" value="${professorList.professorLink}">
<input type="button" onclick ="remove(${professorList.teachId})" value = "x"><br>
</div>

</c:forEach>

<input type="submit" value = "submit" onclick="return validate()">
</form>

<c:if test="${requestScope.inf!=null}">

      <span color="red"> ${requestScope.inf} </span>

</c:if>

</body>
</html>