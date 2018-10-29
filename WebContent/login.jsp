
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>

<script type="text/javascript">

  function register(){

  window.open("register.jsp","_self");

  }

</script>



</head>

<body>
<h1>Login</h1>
<form action="login.do" method="post">

  <table  border="1">

  <tr>

  <td><label for="username">Username</label></td>

  <td><input type="text" name="username" id="username"/></td>

  </tr>

   <tr>

  <td><label for="password">Password</label></td>

  <td><input type="password" name="password" id="password"/></td>

  </tr>

  <tr>

  <td colspan="2" align="center">

   <input type="submit" value="Login" id = "login"/>

   <input type="button" value="Registration" onclick=register() />

  </td>

  </tr>

  </table>

  </form>

  <c:if test="${requestScope.inf!=null}">

      <p id="loginAlert"> ${requestScope.inf} </p>

  </c:if>

</body>

</html>