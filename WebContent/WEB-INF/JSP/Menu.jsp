<%@ page  contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<c:set var ="contextPath" value ="${pageContext.servletContext.contextPath}"/>
<link rel="stylesheet" href="${contextPath}/css/stylesFrituur.css" />
<title>Menu</title>
</head>
<body>
  <header>
    <h1>Welkom bij frituur Frida</h1>
    <img src="${contextPath}/img/frituurfrida.png" alt="logo" />
    <nav>
      <ul class="menuLink">
        <c:url value="/" var="rootURL"/>
         <li><a href="${rootURL}">Welkom</a></li> 
         <c:url value="/sauzen.htm" var="sauzenURL" />      
         <li><a href="${sauzenURL}" >Overzicht sauzen</a></li>  
         <c:url value="/sauzenzoeken.htm" var="sauzenzoekenURL" />      
         <li><a href="${sauzenzoekenURL}" >Zoek sauzen</a></li>
         <c:url value="/meisjesjongens.htm" var="meisjesjongensURL" />      
         <li><a href="${meisjesjongensURL}" >Meisjes of jongens</a></li> 
         <c:url value="/sauzenraden.htm" var="sauzenradenURL" />      
         <li><a href="${sauzenradenURL}" >Sauzen raden</a></li>  
         <c:url value="/statistieken.htm" var="statistiekenURL" />      
         <li><a href="${statistiekenURL}" >Statistieken URL's</a></li> 
      </ul>
    </nav>
  </header>
</body>
</html>