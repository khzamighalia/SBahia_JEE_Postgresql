/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import models.Article;

/**
 *
 * @author Admin
 */
public class ProduitModel {
    
    private String MotCle;
    private List<Article> Produits = new ArrayList<Article>();

    public String getMotCle() {
        return MotCle;
    }

    public void setMotCle(String MotCle) {
        this.MotCle = MotCle;
    }

    public List<Article> getProduits() {
        return Produits;
    }

    public void setProduits(List<Article> Produits) {
        this.Produits = Produits;
    }
    
    
    
}
