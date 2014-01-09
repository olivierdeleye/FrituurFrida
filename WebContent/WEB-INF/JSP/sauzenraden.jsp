<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<c:set value="${pageContext.servletContext.contextPath}" var="contextURL"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title>Sauzen raden</title>
</head>
<body>
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
<c:choose>
 <c:when test="${sauzenRaden.lost}">
 <section>Spel verloren, saus was ${sauzenRaden.saus}</section>
 </c:when>
 <c:when test="${sauzenRaden.won}">
 <section>Spel gewonnen, saus was ${sauzenRaden.saus}</section>
 </c:when>
 <c:otherwise>
  <c:url value="/sauzenraden.htm" var="url"/>
  <h2>Sauzen raden</h2>
  <div class="fun">
  <section>Te raden saus: ${sauzenRaden.sausPuntjes}</section>
  <form method="post" action="${url}" id="radenform">
   <section><label>letter:
   <input name="letter" maxLength="1" size="1" autofocus/></label>
   <input type="submit" id="radenknop" value="Raden"/></section>
  </form>
  </div>
  <script>
    document.getElementById('radenform').onsubmit = funtion(){
	 document.getElementById('radenknop').disable = true;
    };
</script>
 </c:otherwise>
</c:choose>
<c:url value="/sauzenraden.htm" var="nieuwURL">
 <c:param name="Nieuw" value="true"></c:param></c:url>
 <form method="post" action="${nieuwURL}" id="nieuwform">
    <input type="submit" id="nieuw" value="Nieuw spel" />
  </form>
  <img src="${contextURL}/img/${sauzenRaden.pogingen}.png" alt="image.${sauzenRaden.pogingen}.png"/>
  <script>
    document.getElementById('nieuwform').onsubmit = funtion(){
	 document.getElementById('nieuw').disable = true;
    };
</script>
</body>
</html>