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

</script>
</head>
<body>
<h1>Add new Course</h1>
<form action="addCourse.do">
<input type ="hidden" name = "id">
Name  <input type ="text" name = "name"><br>
Number  <input type ="text" name = "number"><br>
Description  <input type ="text" name = "description"><br>
Track  <input type ="text" name = "track"><br>
Professor <input type="button" onclick="addInput()" value = "Add Professor"></input><div id = "professor"></div>


<input type="submit" value = "submit">
</form>

</body>
</html>