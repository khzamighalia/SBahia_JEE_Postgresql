/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.SQLException;
import java.util.List;
import models.Article;

/**
 *
 * @author Admin
 */
public interface IArticleDAO {
    public Article ajouterArticle(Article A) throws SQLException;
    public List<Article> AfficherArticles() throws SQLException;
    public void SupprimerArticle(int id) throws SQLException;
    public List<Article> ChercherArticle(String name) throws SQLException;
    public Article ChercherArticleById(int id) throws SQLException;
    public void ModifierArticle(int id,String img,String titre,int vote,int prix) throws SQLException;
           }
