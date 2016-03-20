<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/tags/temperature" prefix="temp"%>
<html>
<head>
<title>Hello Custom Tag</title>
</head>
<body>
	<h3>Hello World!</h3>
	<br /> 100 Celsius equals
	<temp:convert to="F">100</temp:convert>
	Fahrenheit
	<br /> 0 Celsius equals
	<temp:convert to="Fahrenheit">0</temp:convert>
	Fahrenheit
	<br /> 100 Celsius equals
	<temp:convert to="K">100</temp:convert>
	Kelvin
	<br /> 0 Celsius equals
	<temp:convert to="Kelvin">0</temp:convert>
	Kelvin
	<br /> 100 Celsius equals
	<temp:convert>100</temp:convert>
	Default degrees
	<br />
	<% out.println("Your IP address is " + request.getRemoteAddr()); %>
</body>
</html>