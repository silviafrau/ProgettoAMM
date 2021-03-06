/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.classi.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Utente
 */


@WebServlet(urlPatterns=
 {
     "/bacheca.html"
 })
public class Bacheca extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        //se la sessione esiste ed esiste anche l'attributo loggedIn impostato a true
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
           
           /*String username = request.getParameter("Username");
           String password = request.getParameter("login-password");
           int loggedUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
           UtentiRegistrati utente = UtenteFactory.getInstance().getUserById(loggedUserID);
           */
           String user = (String) request.getParameter("altroutente"); //cercalo poi sul jsp
           int userID;
           String parameter = (String) request.getParameter("postType");
           String text = (String) request.getParameter("textPost");
           
           if(user != null){
                userID = Integer.parseInt(user);
                
           } else {
                int loggedUserID = (Integer)session.getAttribute("loggedUserID");
                userID = loggedUserID;
                
                if(parameter.equals("textType") || parameter.equals("imgType") || parameter.equals("LinkType")){
                    if(text != null){
                        request.setAttribute("validData",true);
                        request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                   }     
                 }else{
                    request.setAttribute("null",true);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
           }
           UtentiRegistrati utente2 = UtenteFactory.getInstance().getUserById(userID);
           
           if(utente2 != null){
                request.setAttribute("user", utente2);
                request.setAttribute("listaUtenti", UtenteFactory.getInstance().getUserList());
                List<Post> posts = PostFactory.getInstance().getPostList(utente2);
                request.setAttribute("posts", posts);
                request.setAttribute("post",PostFactory.getInstance().getPostById(userID));
                        
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                
                if(parameter.equals("textType") || parameter.equals("imgType") || parameter.equals("LinkType")){
                    if(text != null){
                        request.setAttribute("validData2",true);
                        request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                    } 
                }else{
                    request.setAttribute("null",true);
                    request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                }
               
           }else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
      }
       else
      {
          request.getRequestDispatcher("bacheca.jsp").forward(request,response);
       }
               
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
