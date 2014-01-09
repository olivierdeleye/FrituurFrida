<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<c:set value="${pageContext.servletContext.contextPath}" var="contextURL"/>
<html lang="nl">
<head>
<title>Frituur Frida - pagina niet gevonden</title>
<link rel="stylesheet" href="${contextURL}/css/stylesFrituur.css" />
</head>
<body>
<c:import url="/WEB-INF/JSP/Menu.jsp"/>
<h1>Pagina niet gevonden</h1>
<img alt="fout" src="${contextURL}/img/fout.jpg"/>
<p>De pagina die u zocht staat niet op onze website.</p>
</body>
</html>