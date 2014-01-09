<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<c:set value="${pageContext.servletContext.contextPath}" var="contextURL"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title>Statistieken URL's</title>
</head>
<body>
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<!--<c:import url="/WEB-INF/JSP/Menu.jsp" />-->
<h2>Frituur Frida - Statistieken URL's</h2>
<table>
 <thead>
  <tr><th>URL</th><th>&nbsp;aantal requests</tr>
 </thead>
 <tbody>
 <c:if test="${not empty fouten}">
 <tr><td><c:out value="${fout}"/></td></tr>
 </c:if>
 <c:forEach  var="entry" items="${statistieken}">
  <tr><td>${entry.key}</td><td>${entry.value}</td></tr>
 </c:forEach>
 </tbody>
</table>
</body>
</html>