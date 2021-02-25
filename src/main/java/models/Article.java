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
    private byte[] image;

    public Article() {
    }

    
    public Article(int id,String titre, int prix, int vote,byte[] image) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.vote = vote;
        this.image=image;
    }

    public Article(String titre, int prix, int vote, byte[] image) {
        this.titre = titre;
        this.prix = prix;
        this.vote = vote;
        this.image = image;
    }
    
    /**
     *
     * @param titre
     * @param prix
     * @param vote
     * @param image
     */
  
    
    public Article( String titre, int prix,byte[] image) {
        this.titre = titre;
        this.prix = prix;
        this.image=image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", prix=" + prix + ", vote=" + vote + ", image=" + image + '}';
    }

    

    
 
    

   

    

    

    
}

    
