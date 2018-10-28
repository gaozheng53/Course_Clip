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

</script>
</head>
<body>
<h1>Add new Course</h1>
<form action="addCourse.do">
<input type ="hidden" name = "id">
Name  <input type ="text" name = "name" id = "name"><br>
Number  <input type ="text" name = "number" id = "number"><br>
Description  <input type ="text" name = "description" id = "description"><br>
Track  
	  <select name = "track" id = "track">
	  <option value ="" selected></option>
	  <option value ="DS">Data Sciences</option>
	  <option value ="IA">Information Assurance</option>
	  <option value="IS">Intelligent Systems</option>
	  <option value="IC">Interactive Computing</option>
	  <option value ="SYS">Systems</option>
	  <option value="TCS">Traditional Computer Science</option></select>
<br>
Professor <input type="button" onclick="addInput()" value = "Add Professor"></input><div id = "professor"></div>


<input type="submit" value = "submit" onclick="return validate()">
</form>
<c:if test="${requestScope.inf!=null}">

      <span color="red"> ${requestScope.inf} </span>

</c:if>
</body>
</html>