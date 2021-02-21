/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class Article {
    private int id;
    private String titre;
    private int prix;
    private int vote;
    private String fileName;
    private String filePath;

    public Article() {
    }

    
    public Article(int id,String titre, int prix, int vote,String fileName,String filePath) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.vote = vote;
        fileName=this.fileName;
        filePath=this.filePath;
    }

    public Article(String titre, int prix, int vote,String fileName,String filePath) {
        this.titre = titre;
        this.prix = prix;
        this.vote = vote;
        fileName=this.fileName;
        filePath=this.filePath;
    }
    
    public Article( String titre, int prix,String fileName,String filePath) {
        this.titre = titre;
        this.prix = prix;
        fileName=this.fileName;
        filePath=this.filePath;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", prix=" + prix + ", vote=" + vote + ", fileName=" + fileName + ", filePath=" + filePath + '}';
    }

    

    
}

    
