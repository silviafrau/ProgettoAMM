<%-- 
    Document   : bacheca.jsp
    Created on : 16-mag-2017, 12.04.38
    Author     : Silvia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <title>Nerdbook: trova nuovi amici</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Silvia Frau">
        <meta name="keywords" content="cerca amici nuovi gruppi social"> 
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>>
    </head>
    <body>
        <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>

        <nav>
            <ul>
                <li class="li" id="active"><a href="bacheca.html" class="linkEffettivi">Bacheca</a></li>
                <li class="li"><a href="profilo.html" class="linkEffettivi">Profilo</a></li>
                <li class="li" id="LogoutUser"><a href="login.html" id="logout">Silvia Frau : Logout</a></li>
            </ul>
        </nav>

        <!--Contenuti della pagina-->
        <div id="divBody1">
            <!--Informazioni personali-->
           
                <div class="imgProf">
                    <img title="FotoProfilo" alt="FotoProfilo" src="${UtentiRegistrati.urlFotoProfilo}">
                </div>
                <p id="Nome">
                    <strong>Nome:</strong> 
                    ${UtentiRegistrati.nome}
                </p>
                
                <c:if test="${empty param.user}">
                    <p id="logOutLink"><a href="Login?logout=1">Logout</a></p>
                </c:if>

            <!--lista dei post-->
            <div id="posts">
                <c:forEach var="post" items="${posts}">
                    <div class="post">
                        <c:if test="${post.postType == 'TEXT'}">
                            <p>${post.content}</p>
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <img alt="Post con foto" src="${post.content}">
                        </c:if>
                        <c:if test="${post.postType == 'LINK'}">
                            <img alt="Post con link" src="${post.content}">
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>

    </body>
</html>
