/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.classi.*;
import amm.nerdbook.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Silvia
 */

@WebServlet(urlPatterns=
 {
     "/login.html"
 })

public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Apertura della sessione
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {
            
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) 
        {
                int loggedUserID = (int)session.getAttribute("loggedUserID");
                UtentiRegistrati utente= UtenteFactory.getInstance().getUserById(loggedUserID);
                if(utente.getCognome() == null ||
                   utente.getNome()== null||
                   utente.getUrlFotoProfilo() == null ||
                   utente.getPresentation() == null)
                {
                    request.getRequestDispatcher("profilo.jsp").forward(request, response);
                    return;
                }
              request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            return;
        }
        
        //Se l'utente non è loggato...
        else {
            String username = request.getParameter("UserName");
            String password = request.getParameter("login-password");
            if (username != null && password != null) 
                {
                    int loggedUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
                    //se l'utente è valido...
                    session.setAttribute("loggedUserID", loggedUserID);
                    UtentiRegistrati user = UtenteFactory.getInstance().getUserById(loggedUserID);
                    if(loggedUserID!=-1)
                    {   
                        if(user.getCognome() == null ||
                           user.getNome()== null||
                           user.getUrlFotoProfilo() == null ||
                           user.getPresentation() == null)
                        {   
                            request.setAttribute("invalidData2",true);
                            request.getRequestDispatcher("profilo.jsp").forward(request, response);
                            return;
                        }
                        else
                        {
                      
                        //UtentiRegistrati user = UtenteFactory.getInstance().getUserById(loggedUserID);
                        
                            session.setAttribute("UserName",username);
                            session.setAttribute("password",password);
                            session.setAttribute("loggedIn", true);
                            session.setAttribute("loggedUserID", loggedUserID);
                            session.setAttribute("listaUtenti", UtenteFactory.getInstance().getUserList());
                            session.setAttribute("listaGruppi", GruppoFactory.getInstance().getGroupList());
                            session.setAttribute("loggedIn", true);
                            session.setAttribute("user", UtenteFactory.getInstance().getUserById(loggedUserID));
                            session.setAttribute("gruppo", GruppoFactory.getInstance().getGruppoByMembro(user));
                            session.setAttribute("posts",PostFactory.getInstance().getPostList(user));
                            session.setAttribute("post",PostFactory.getInstance().getPostById(loggedUserID));

                            request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                            return;
                        }
                    } else {
                    //altrimenti se la coppia user/pass non è valida (id==-1)
                    //ritorno al form del login informandolo che i dati non sono validi
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                    }
                }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
