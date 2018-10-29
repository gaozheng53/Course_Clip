<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Comment</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function() {
	var script = document.createElement("script")
	script.setAttribute("src", "http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js") 
	$('input:file').change(
		
	    function(e){
	    	var filenames = "";
	        var f = e.target.files,
	            len = f.length;
	        for (var i=0;i<len;i++){
	        	filenames += f[i].name + ",";	           
	        }
	        filenames = filenames.substring(0, filenames.length-1);
	        console.log(filenames);
	        $('#inputname').val(filenames);
	    });
});
</script>
<script type="text/javascript">
	
	var script = document.createElement("script")
	script.setAttribute("src", "http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.0.min.js") 
	function clearFile(){
		
		$('#inputname').val(null);
		console.log($('#inputname').val());
		console.log("dd");
	}
</script>
</head>
<body>
<h1>Edit Comment</h1>
<form class = "form" action="editcomment.do" method="post" enctype="multipart/form-data">
<c:forEach items="${commentList}" var="comment">
<input type ="hidden" name = "id" value="${comment.commentId}"><br>
Comment Content: <input type ="text" id = "commentcontent" name = "commentcontent" value="${comment.content}"><br>
File name: <input type ="text" id = "inputname" name = "inputname" value="${fileList}" readonly>
<input type="file" id="files" name = "fileName" style="display:none" multiple />

<label for="files"> Select file button </label>

</c:forEach>
<input id = "submitbutton" type="submit" value = "submit">
</form>

<button id = "clearComment" onclick = "clearFile()">delete file</button>
</body>
</html>