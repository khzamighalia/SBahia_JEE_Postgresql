/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import static com.sun.tools.javac.tree.TreeInfo.name;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import models.Article;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import services.SArticleDAO;
import static sun.jvm.hotspot.interpreter.Bytecodes.name;

/**
 *
 * @author Admin
 */
@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
                  maxFileSize = 1024 * 1024 * 5,
                  maxRequestSize = 1024 * 1024 * 5 * 5 )
public class Uploaddata extends HttpServlet {

    
       

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        InputStream inputStream = null;
        Part filePart = request.getPart("image");

        if (filePart != null) {
            inputStream = filePart.getInputStream();
        } 
        byte[] image = IOUtils.toByteArray(inputStream);
        
         String titre= request.getParameter("titre");
        String prix= request.getParameter("prix");
        int price = Integer.parseInt(prix);
        Article a=new Article(titre,price,0,image);
        SArticleDAO dao= SArticleDAO.getInstance();
        try {
            Article b= dao.ajouterArticle(a);
        } catch (SQLException ex) {
            Logger.getLogger(Uploaddata.class.getName()).log(Level.SEVERE, null, ex);
        }
     ServletContext context= getServletContext();
     request.setAttribute("a",a);
     request.setAttribute("image",image);
     
     RequestDispatcher rd= context.getRequestDispatcher("/defaultServlet");
     rd.forward(request, response);
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
