<%@ tag description="frituurFridaLogo" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="contextPath" value ="${pageContext.servletContext.contextPath}"/>
<link rel="stylesheet" href="${contextPath}/css/stylesFrituur.css" />
 <h1>Welkom bij frituur Frida</h1>
   <img src="${contextPath}/img/fridalogo.png" alt="Frida logo" />
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

