<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="contextURL" value="${pageContext.servletContext.contextPath}"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title>Sauzen zoeken op ingredient</title>
</head>
<body>
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
<h2>Sauzeningredienten</h2>
<c:url var="url" value="/sauzenzoeken.htm"/>
<form method="get" action="${url}">
<label>
 <input name="ingredient"><span class="fout">${fouten.fout}</span>
</label>
  <input type="submit" value="zoek sauzen">
</form>
<c:if test="${not empty gevondenSauzen}">
 <ul class="zebra">
  <c:forEach var="saus" items="${gevondenSauzen}">
     <li>${saus.naam}</li>
  </c:forEach>
 </ul>
</c:if>
<c:if test="${not empty fouten.nietgevonden}">
  <div><span class="fout">${fouten.nietgevonden}</span></div>
</c:if>
</body>
</html>