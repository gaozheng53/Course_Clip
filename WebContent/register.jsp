<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Registration</title>

</head>

<body>

	<script>

		
		function validate() {
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			var passwordRep = document.getElementById("passwordRep");
			var email = document.getElementById("email");
			username = username.value;
			password = password.value;
			passwordRep = passwordRep.value;
			email = email.value;
			if (username.length == 0) {
				alert("username cannot be null");
				return false;
			}
			if (password.length == 0) {
				alert("password cannot be null");
				return false;
			}else if(password.length < 6){   
				alert("password length should be at least 6");
				return false;
			}else if(password != passwordRep){
				alert("Please enter the same password twice");
				return false;
			}
			if (email.length == 0) {
				alert("email cannot be null");
				return false;
			}else if(email.substring(email.length - 13) != "@utdallas.edu"){  
				alert("email should be UTD email");
				return false;
			}
			return true;
		}
	</script>
	

	<form action="register.do" method="post">

		<table border="1">

			<tr>

				<td><label for="username">Username</label></td>

				<td><input type="text" name="username" id="username" /></td>

			</tr>

			<tr>

				<td><label for="password">Password</label></td>

				<td><input type="password" name="password" id="password" /></td>

			</tr>
			<tr>

				<td><label for="passwordRep">Confirm Password</label></td>

				<td><input type="password" name="passwordRep" id="passwordRep" /></td>

			</tr>
			<tr>

				<td><label for="email">Email：</label></td>

				<td><input type="text" name="email" id="email" /></td>

			</tr>

			<tr>

				<td colspan="2" align="center">
				<input type="submit" value="Submit" onclick="return validate()" id = "register" /> 
				<input type="reset" value="Reset" />
				</td>

			</tr>

		</table>

	</form>

<p id = "message">${message}</p>
</body>

</html>







