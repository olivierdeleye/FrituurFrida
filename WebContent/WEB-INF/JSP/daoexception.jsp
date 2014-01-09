<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE HTML>
<c:set value="${pageContext.servletContext.contextPath}" var="contextURL"/>
<html lang="nl">
<head>
<title>Frituur Frida - probleem bij ophalen data</title>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
</head>
<body>
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<h1>Problemen bij het ophalen van data</h1>
<img alt="data fout" src="${contextURL}/img/datafout.jpg"/>
<p>We kunnen de gevraagde data niet ophalen
   wegens een technische storing.<br/>
   Gelieve de helpdesk te contacteren.</p>
</body>
</html>