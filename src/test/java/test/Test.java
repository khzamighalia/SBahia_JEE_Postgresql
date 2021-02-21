/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Article;
import services.SArticleDAO;
import services.SUserDAO;


/**
 *
 * @author Admin
 */
public class Test {
     public static void main (String[] args) throws SQLException, ClassNotFoundException {
        //SArticleDAO dao=SArticleDAO.getInstance();
        SUserDAO dao= SUserDAO.getInstance();
     
             dao.Register("user","user","user");
             //Article ar=new Article("hello","test",34000);
             //Article b=dao.ajouterArticle(new Article("uhhhhhhhhhhh","panier",1500));
             //dao.ajouterArticle(ar);
             //System.out.println(a.toString());
             //System.out.println(b.toString());
             //List<Article> Produits = new ArrayList<Article>();
             /* ar=dao.ChercherArticleById(7);
             System.out.println(ar.toString());*/
             /*Produits=dao.AfficherArticles();
             for (Article p : Produits){
             System.out.println(p.toString());
             }*/
             //dao.ModifierArticle(2,"v11.jpg","Plat", 10,20000);
             //Produits=dao.AfficherArticles();
             /*    Produits=dao.AfficherArticles();
             for (Article p : Produits){
             System.out.println(p.toString());
             }
             dao.SupprimerArticle(3);*/
             /*Produits=dao.AfficherArticles();
             for (Article p : Produits){
             System.out.println(p.toString());
             }*/
             
             /*  Produits=dao.ChercherArticle("test");
             for (Article p : Produits){
             System.out.println(p.toString());
             }*/
         
         
              
     }
}
