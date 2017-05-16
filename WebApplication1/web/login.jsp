<%-- 
    Document   : login.jsp
    Created on : 16-mag-2017, 11.40.38
    Author     : Silvia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdbook: trova nuovi amici</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Silvia Frau">
        <meta name="keywords" content="cerca amici nuovi gruppi social"> 
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header>
            <c:set var="title2" value="Login" scope="request"/>
            <jsp:include page="header.jsp"/>
            
            <div id="title">
                <h1>Nerdbook</h1>
            </div>   
        </header>
        <nav>
            <ul>
                <li class="li"><a href="bacheca.html" class="linkEffettivi">Bacheca</a></li>
                <li class="li"><a href="descrizione.html" class="linkEffettivi">Descrizione</a></li>
                <li class="li"><a href="profilo.html" class="linkEffettivi">Profilo</a></li>
            </ul>
        </nav>
            <div id="divBody">
               <div id="formLogin">

                   <c:if test="${invalidData == true}">
                       <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                   </c:if>

                   <form action="Login" method="post">
                       <div id="contentForm">
                            <div>
                                 <label for="textType">Inserisci il nome</label>
                                 <input type="text" name="UserName" value="UserName" id="textType" class="imput"/>
                             </div>
                             <div>
                                 <label for="Password">Inserisci password</label>
                                 <input type="password" name="login-password" tabindex="1" value="Password" id="Password" class="imput"/>
                             </div>
                             <div>
                                 <button id="submit" type="submit" >Accedi</button>
                             </div>
                       </div>
                   </form>
               </div>
            </div>
    </body>
</html>
