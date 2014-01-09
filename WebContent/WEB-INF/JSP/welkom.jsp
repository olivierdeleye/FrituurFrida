<%--een welkom pagina --%>
<%@ page  contentType="text/html; charset=UTF-8" session="false" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<fmt:setBundle basename="resourceBundles.teksten"/>
<!DOCTYPE HTML>
<html lang="nl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set  var="contextURL" value="${pageContext.servletContext.contextPath}"/>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css"/>
<title><fmt:message key='frituurFrida'/></title>
</head>
<body>
<header><vdab:logo/></header> <!-- menu wordt a.d.v. custom tag in elke jsp ingevoegd -->
<!--<c:import url="/WEB-INF/JSP/Menu.jsp"/>-->
  <h1>
   <fmt:message key="vandaagZijnWeOpenGesloten">Vandaag zijn we</fmt:message>&nbsp;<fmt:message key="${openGesloten}"/>
  </h1>
   <img src= "${contextURL}/img/${openGesloten}<fmt:message key='lang'/>.png"  alt="image"/> 
  <div><fmt:message key="adresGegevens"/></div>
  <ul>
    <li><fmt:message key="straat"/>: ${adres.straat}</li>
    <li><fmt:message key="huisNr"/>: ${adres.huisNr}</li>
    <li><fmt:message key="gemeente"/>: ${adres.gemeente.naam} </li>
    <li><fmt:message key="postCode"/>: ${adres.gemeente.postCode} </li>
  </ul>
</body>
</html>