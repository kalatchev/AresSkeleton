<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
html, body {
	font-family: 'segoe ui' , verdana, arial, sans-serif;
	font-size: 15px;
	margin: 0px;
	padding: 0px;
}
a, a:visited {
	color: #06F;
}
</style>
</head>
<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% 
	ResourceBundle resource = ResourceBundle.getBundle("project");
  	String pver=resource.getString("prjversion");
  	String pname=resource.getString("prjname"); %>
<body>
	<div style="margin-left: auto; margin-right: auto; margin-top: 20px; margin-bottom: 80px; width: 800px;">
		<h1>Ares Server</h1>
		<p>This site is not for end users, it's an API base of 
			<a href="http://arenal.skyware-group.com/" target="_blank">Arenal</a> servers chain.</p>
		<p>Version: <%= pname + " " + pver %></p>
	</div>	
</body>
</html>