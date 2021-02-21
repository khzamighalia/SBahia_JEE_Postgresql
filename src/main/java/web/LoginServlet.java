/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.SUserDAO;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        SUserDAO dao= new SUserDAO();
        User user;
        response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("username");  
    String p=request.getParameter("password");  
          
        try {
            user=new User();
            user=dao.Login(n,p);
            if( user!=null){
                 HttpSession session=request.getSession();  
                 session.setAttribute("name",user.getName());  
                if(user.getStatus().equals("user")){
                RequestDispatcher rd=request.getRequestDispatcher("/AccueilServlet");
                rd.forward(request,response);
                }
                else {
                    RequestDispatcher rd=request.getRequestDispatcher("/defaultServlet");
                rd.forward(request,response);
                }
            }
            else{
                out.print("Nom d'utilisateur ou de mot de passe erroné");
                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                rd.include(request,response);  
            }   } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    //out.close();  
    }  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */



