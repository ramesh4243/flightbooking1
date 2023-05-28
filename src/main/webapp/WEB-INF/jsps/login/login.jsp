<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
 ${error}
<form action="verifyLogin" method="post">
     Email <input type="text" name="email"/>
     Password <input type="password" name="password"/>
     <input type="Submit" value="Login"/>
     </form>
</body>
</html>