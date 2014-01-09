<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<c:set value="${pageContext.servletContext.contextPath}" var="contextURL"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title>Meisjes - Jongens</title>
</head>
<body class="${meisjesjongens}">
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<h1>Meisjes jongens</h1>
<c:url value="/meisjesjongens.htm" var="action"/>
<form  method="post" action="${action}" id="naamform">
  <input type="submit" name= "meisjesjongens" value="meisjes" id="onthoudknop"/>
  <input type="submit" name= "meisjesjongens" value="jongens" id="onthoudknop"/>
</form>
</body>
<script>
 document.getElementById('naamform').onsubmit = funtion(){
	 document.getElementById('onthoudknop').disable = true;
 };
</script>
</html>