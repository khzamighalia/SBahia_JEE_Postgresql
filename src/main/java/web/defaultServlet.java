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
import services.SUserDAO;

/**
 *
 * @author Admin
 */
public class defaultServlet extends HttpServlet {
     private IArticleDAO metier;
  
    /**
     *
     * @throws javax.servlet.ServletException
     */
    @Override
  public void init() throws ServletException{
      metier = new SArticleDAO();
      
  }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            ProduitModel model2=new ProduitModel();
            List<Article> produits;
         try {
             produits = metier.AfficherArticles();
             model2.setProduits(produits);
            request.setAttribute("modelAcc", model2);
            dispatcher.forward(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(defaultServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            ProduitModel model2=new ProduitModel();
            List<Article> produits;
         try {
             produits = metier.AfficherArticles();
             model2.setProduits(produits);
            request.setAttribute("modelAcc", model2);
            dispatcher.forward(request, response);
         } catch (SQLException ex) {
             Logger.getLogger(defaultServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

  

}
