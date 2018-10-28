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
	function clearFile(){
		$('#inputname').val(null);
		console.log($('#inputname').val());
	}
</script>

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

#comment{   
    position: absolute;   
    top: 50%;   
    left:50%;   
    margin: -150px 0 0 -150px;   
    width: 300px;   
    height: 300px;   
}

#comment h1{   
    color: #fff;   
    text-shadow:0 0 10px;   
    letter-spacing: 1px;   
    text-align: center;   
}

h1{   
    font-size: 2em;   
    margin: 0.67em 0;   
} 

input{   
    width: 278px;   
    height: 28px;   
    margin-bottom: 10px;   
    outline: none;   
    padding: 10px;   
    font-size: 13px;   
    color: #fff;   
    text-shadow:1px 1px 1px;   
    border-top: 1px solid #312E3D;   
    border-left: 1px solid #312E3D;   
    border-right: 1px solid #312E3D;   
    border-bottom: 1px solid #56536A;   
    border-radius: 4px;   
    background-color: #2D2D3F;   
} 

button{   
    width: 30px;   
    min-height: 9px;   
    display: block;   
    background-color: #4a77d4;   
    border: 1px solid #3762bc;   
    color: #fff;   
    padding: 14px 14px;   
    font-size: 15px;   
    line-height: normal;   
    border-radius: 5px;   
    margin: 0;   
}

</style>

</head>
<body>
<div id="comment">  
<h1>Edit Comment</h1>
<form class = "form" action="editcomment.do" method="post" enctype="multipart/form-data">
<c:forEach items="${commentList}" var="comment">
<input type ="hidden" name = "id" value="${comment.commentId}"><br>
Comment Content: <input type ="text" name = "commentcontent" value="${comment.content}"><br>
File name: <input type ="text" id = "inputname" name = "inputname" value="${fileList}" readonly>
<input type="file" id="files" name = "fileName" style="display:none" multiple />

<label for="files"> Select file button </label>

</c:forEach>
<input type="submit" value = "submit" style="background-color:#4a77d4; height: 36px; ">
</form>

<button id = "clear" onclick = "clearFile()" style="
    background-color:#4a77d4; 
    height: 36px;
    width: 278px;   
    margin-bottom: 10px;   
    outline: none;   
    padding: 10px;   
    font-size: 13px;   
    color: #fff;   
    text-shadow:1px 1px 1px;   
    border-top: 1px solid #312E3D;   
    border-left: 1px solid #312E3D;   
    border-right: 1px solid #312E3D;   
    border-bottom: 1px solid #56536A;   
    border-radius: 4px;">delete file</button>
</div>
</body>
</html>