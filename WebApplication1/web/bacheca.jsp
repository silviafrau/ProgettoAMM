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
        <header>
            <div id="title2">
                <h1>NerdBook</h1>
            </div>
            <!--<div id="title2">
                <h2>Bacheca</h2>
            </div>-->
        </header>
       

        <nav>
            <ul>
                <li class="li" id="active"><a href="bacheca.jsp" class="linkEffettivi">Bacheca</a></li>
                <li class="li"><a href="profilo.jsp" class="linkEffettivi">Profilo</a></li>
                <li class="li" id="LogoutUser"><a href="Login?logout=1" id="logout">Logout</a></li>
               
            </ul>
        </nav>
        <div id="PostInMezzo">
            <div id="Cercaamici">
                <p class="titlePersona">Persone</p>
                <ul class="listaAmici">
                <c:forEach var="user" items="${listaUtenti}">
                    <li><a href="Bacheca?altroutente=${user.id}">${user.nome}</a></li>
                </c:forEach>
                </ul>
            </div>
            <div id="Gruppi">
                <p class="titlePersona">Gruppi</p>
                <ul class="listaAmici">
                    <c:forEach var="gruppo" items="${listaGruppi}">
                         <li>${gruppo.nome}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--Contenuti della pagina-->
        <div id="divBody1">
            <!--Informazioni personali-->
            <div id="nuovoPost" class="Post">
                    <div id="formNewPost">
                            <form action="Bacheca" method="post">
                                <div id="postType">
                                    <div>
                                        <label for="textType">Post di Testo</label>
                                        <input type="radio" name="postType" value="textType" id="textType">
                                    </div>
                                    <div>
                                        <label for="imgType">Post con Foto</label>
                                        <input type="radio" name="postType" value="imgType" id="imgType">
                                    </div>
                                    <div>
                                        <label for="imgType">Post con Link</label>
                                        <input type="radio" name="postType" value="LinkType" id="imgType">
                                    </div>
                                </div>
                                <div id="postContent">
                                    <div>
                                        <label for="textPost">Testo</label>
                                        <textarea name="textPost" id="textPost"></textarea>
                                    </div>
                                    <div>
                                        <label for="imgPost">File d'immagine</label>
                                        <input type="file" name="imgPost" id="imgPost">
                                    </div>
                                </div>
                                <button type="submit">Invia</button>
                                
                                <c:if test="${validData == true}">
                                     <div id="validDataWarning">${user.nome} ha scritto nella sua bacheca personale.</div>  
                                </c:if>
                                <c:if test="${validData2 == true}">
                                     <div id="validDataWarning">${user.nome} ha scritto nella bacheca di ${user.nome}.</div>  
                                </c:if>   
                                <c:if test="${null == true}">
                                     <div id="validDataWarning">Non hai compilatp tutti i campi del post.</div>  
                                </c:if>   
                            </form>
                    </div>
            </div>
            <c:forEach var="post" items="${posts}">
           <div class="utente">
                <div class="imgProf">
                    <img title="FotoProfilo" alt="FotoProfilo" src="${user.urlFotoProfilo}">
                </div>
                <p class="nome">
                    <strong>${user.username}</strong> 
                </p>
           </div>  
            <!--lista dei post-->
            <div id="posts">
                
                    <div class="Post">
                        <c:if test="${post.postType == 'TEXT'}">
                            <p>${post.content}</p>
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <c:if test="${post.content != null}">
                                <p>${post.content}</p>
                            </c:if>
                            <img alt="Post con foto" src="${post.image}">
                        </c:if>
                        <c:if test="${post.postType == 'LINK'}">
                            <c:if test="${post.content != ''}">
                                <p>${post.content}</p>
                            </c:if>
                                <a href="${post.url}">Link</a>
                        </c:if>
                    </div>
               
            </div>
           </c:forEach>
        </div>

    </body>
</html>
