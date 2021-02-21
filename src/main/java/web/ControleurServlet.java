/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Article;
import repositories.IArticleDAO;
import services.SArticleDAO;

/**
 *
 * @author Admin
 */
public class ControleurServlet extends HttpServlet {

  private IArticleDAO metier;
  
    /**
     *
     * @throws javax.servlet.ServletException
     */
    @Override
  public void init() throws ServletException{
      metier = new SArticleDAO();
      
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
 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/produits.jsp");
            String motCle=request.getParameter("motcle");
            ProduitModel model=new ProduitModel();
            model.setMotCle(motCle);
            List<Article> produits;
            try {
                produits = metier.ChercherArticle("%"+motCle+"%");
                model.setProduits(produits);
            request.setAttribute("model", model);
            dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ControleurServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        
    }

  

  


