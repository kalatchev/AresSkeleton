<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="java.util.ResourceBundle"
	import="com.skywaregroup.arenal.ServiceProvider"%>
<%
	ResourceBundle resource = ResourceBundle.getBundle("project");
	String pver = resource.getString("prjversion");
	String pname = resource.getString("prjname");
	String porg = resource.getString("prjorg");
	String purl = resource.getString("prjorgurl");
	ServiceProvider provider = ServiceProvider.demoObject();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=pname%></title>
<style type="text/css">
html, body {
	font-family: 'segoe ui', verdana, arial, sans-serif;
	font-size: 15px;
	margin: 0px;
	padding: 0px;
}

a, a:visited {
	color: #06F;
}

div.Main {
	margin: 20px auto 20px auto;
	width: 800px;
}
</style>
</head>

<body>
	<div class="Main">
		<h1><%=pname%></h1>
		<p>
			Този сайт <span style="font-weight: bold;">не е предназначен</span>
			за крайни потребители. Той предоставя услуги, достъпни само от
			допълнителен софтуер, като например системи за ОПЛ и СИМП. Арес е
			сървър за резултати за системата <a
				href="http://arenal.skyware-group.com" target="_blank">Аренал</a>.
			Проекта в <a href="https://github.com/kalatchev/AresSkeleton"
				target="_blank">Github</a> е референтната имплементация.
			Имплементатор на този конкретен сайт е <a href="<%=purl%>"
				target="_blank"><%=porg%></a>.
		</p>
		<h3>Данни за изпълнителя</h3>
		<p>
			<a href="<%=provider.webSite%>" target="_blank"><span
				style="font-weight: bold;"><%=provider.name%></span></a><br />
			<%=provider.city + " " + provider.postalCode%><br />
			<%=provider.address%><br />
			тел.: <%=provider.phone1%>
		</p>
		<p>
			<hr/>
			Version: <span style="font-weight: bold;"><%=pver%></span>
		</p>
	</div>
</body>
</html>