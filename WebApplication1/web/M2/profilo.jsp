<%-- 
    Document   : profilo
    Created on : 16-mag-2017, 17.55.16
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
        <!--header contenente in titolo della pagina-->
        <c:set var="title2" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <nav>
                <ul>
                    <li class="li" id="active"><a href="profilo.html" class="linkEffettivi">Profilo</a></li>
                    <li class="li"><a href="bacheca.html" class="linkEffettivi">Bacheca</a></li>
                    <li class="li" id="LogoutUser"><a href="login.html" id="logout">Silvia Frau : Logout</a></li>
                </ul>
        </nav>
        
        <!--Contenuti della pagina-->
        <div id="divBody2">
            
            <c:if test="${invalidData2 == true}">
                 <div id="invalidDataWarning">Non sei autentificato. Riprova.</div>
            </c:if>
            <c:if test="${empty param.user}">
                    <p id="logOutLink"><a href="Profilo?logout=1">Logout</a></p>
            </c:if>
                       
            <div id="formProfilo" class="form">
                <form action="Profilo" method="post">
                    <div id="contentFormP">
                        <label for="Nome">Nome</label>
                        <input type="text" name="Nome" value="UserName" id="Nome"/><br>

                        <label for="Cognome">Cognome</label>
                        <input type="text" name="Cognome" value="Cognome" id="Cognome"/><br>

                        <label for="ImmagineProfilo">URL immagine profilo</label>
                        <input type="file" accept="image/*" id="ImmagineProfilo" name="ImmagineProfilo"/><br>

                        <label for="DescrizionePersonale">Descrizione personale</label>
                        <textarea name="Presentazione personale" id="DescrizionePersonale" rows="3" cols="50">Inserisci una breve descrizione personale.</textarea><br>

                        <label for="Data">Data</label>
                        <input type="date" name="Data" id="Data"/><br>

                        <label for="Password">Inserisci password</label>
                        <input type="password" name="login-password" tabindex="1" value="Password" id="Password"/><br>

                        <label for="DuplicaPassword">Conferma password</label>
                        <input type="password" name="login-password" tabindex="1" value="Password" id="DuplicaPassword"/><br>

                        <button type="submit" id="submit"  >Invia dati</button>
                    </div>
                    <c:if test="${validData == true}">
                        <div id="validDataAdvertising">Dati inviati: </div>
                        <!--devo far vedere anche i dati inviati-->
                        Nome: <%= request.getParameter("Nome") %> <br /> 
                        Cognome: <%= request.getParameter("Cognome") %>
                        URL immagine profilo:<%= request.getParameter("ImmagineProfilo")%>
                        Descrizione Personale:<%= request.getParameter("DescrizionePersonale")%>
                        Data: <%= request.getParameter("Data")%>
                        Password: <%= request.getParameter("Password")%>
                        
                    </c:if>
                </form>
                
            </div>
        </div>
    </body>
</html>
