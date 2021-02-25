/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;




import ConnectionDB.Singleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Article;
import repositories.IArticleDAO;

/**
 *
 * @author Admin
 */
public class SArticleDAO implements IArticleDAO {
    
     private static SArticleDAO instance;
    public SArticleDAO(){
    }

    public static SArticleDAO getInstance(){
        if(instance==null){
            instance = new SArticleDAO();
        }
        return instance;
    }

     @Override
    public Article ajouterArticle(Article A) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int id=0;
        int state=0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "INSERT INTO public.\"Article\"(\n" +
"	titre, prix, vote, image)\n" +
"	VALUES (?, ?, ?, ?);";
            statement = connection.prepareStatement(query_POST,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, A.getTitre());
            statement.setInt(2, A.getPrix());
            statement.setInt(3, 0);
            statement.setBytes(4, A.getImage());
            state= statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
             while (rs.next()) {
                A.setId(rs.getInt(1));
                            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(SArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            if (connection != null) {
                connection.close();
            }
           
        }

    return A;
    }
    
    @Override
    public List<Article> AfficherArticles() throws SQLException{
           List<Article> Produits = new ArrayList<Article>();
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {
            connection = Singleton.getConnection();
            String query_POST = "SELECT *\n" +
"	FROM public.\"Article\";";
            statement = connection.prepareStatement(query_POST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Article A = new Article();
                A.setId(rs.getInt(1));
                A.setImage(rs.getBytes(2));
                A.setTitre(rs.getString(3));
                A.setPrix(rs.getInt(4));
                A.setVote(rs.getInt(5));
                Produits.add(A);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(SArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return  Produits;
    
        
    }
    @Override
    public void SupprimerArticle(int id) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "DELETE FROM public.\"Article\"\n" +
"	WHERE \"id_Article\"=?; ";
            statement = connection.prepareStatement(query_POST);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(SArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
 
       
    
     @Override
    public List<Article> ChercherArticle(String name) throws SQLException {
        List<Article> Produits = new ArrayList<Article>();
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "SELECT \"id_Article\", img, titre, prix, vote\n" +
"	FROM public.\"Article\" where titre like ?;";
            statement = connection.prepareStatement(query_POST);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Article A = new Article();
                A.setId(rs.getInt(1));
              //  A.setImg(rs.getString(2));
                A.setTitre(rs.getString(3));
                A.setVote(rs.getInt(4));
                A.setPrix(rs.getInt(5));
                Produits.add(A);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return  Produits;
    }
    
    public Article ChercherArticleById(int id) throws SQLException {
        Article A = new Article();
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        int state = 0;
        try {

            try {
                // check if the User Exists Or Not
                // code goes here ::
                connection = Singleton.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query_POST = "SELECT \"id_Article\", img, titre, prix, vote\n" +
"	FROM public.\"Article\" where \"id_Article\"=?; ";
            preparedStatement = connection.prepareStatement(query_POST);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               A.setId(rs.getInt(1));
                //A.setImg(rs.getString(2));
                A.setTitre(rs.getString(3));
                A.setPrix(rs.getInt(4));
                A.setVote(rs.getInt(5));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return  A;
    }
    
         @Override
    public void ModifierArticle(int id,String img,String titre,int prix,int vote) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int state=0;
        try {

            try {
                // check if the User Exists Or Not
                // code goes here ::
                connection = Singleton.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query_POST = "UPDATE public.\"Article\"\n" +
"	SET  img=?, titre=?, prix=?, vote=? \n" +
"	WHERE \"id_Article\"=?; ";
            statement = connection.prepareStatement(query_POST);
            /*Article A=new Article();
                A.setId(id);
                A.setTitre(titre);
                A.setImg(img);
                A.setVote(vote);
                A.setPrix(prix);*/
                statement.setString(1, img);
                statement.setString(2, titre);
                statement.setInt(3, prix);
                statement.setInt(4, vote);
                statement.setInt(5, id);
               state=statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }


    }
     
        
    
}
