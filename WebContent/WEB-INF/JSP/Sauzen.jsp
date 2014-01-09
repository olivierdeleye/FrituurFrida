<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<c:set  var="contextURL" value="${pageContext.servletContext.contextPath}"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title>Menu sauzen</title>
</head>
<h1>Menu sauzen</h1>
<body>
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<c:url value="/sauzenverwijderen.htm" var="sauzenverwijderenURL"/>
  <form action="${sauzenverwijderenURL}" method="post">
  <ul class="menu zebra">
   <c:forEach var="saus"  items="${sauzen}" >
    <li>Nr: ${saus.nummer}</li>
    <li><input type="checkbox" name="nummer" value="${saus.nummer}"/>${saus.naam}</li>
    <li class="border">
      <img src="${contextURL}/img/${saus.naam}.jpg" alt="saus"/>
    </li>
     <li>Ingredienten: 
         <c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status">
            <c:choose>
             <c:when test="${status.last}">
               ${ingredient}
             </c:when>
             <c:otherwise>
               ${ingredient},&nbsp;
             </c:otherwise>
           </c:choose>
          </c:forEach>
    </li>
   </c:forEach>
  </ul>
  <input type="submit" value="Aangevinkte sauzen verwijderen">
  </form>
  <script>
     document.getElementById('toevoegform').onsubmit = funtion(){
	     document.getElementById('toevoegform').disable = true;
     };
  </script>
</body>
</html>