<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
</head>
<body>
	<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
	<h2>${message}</h2>

	<form action="logout" method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>