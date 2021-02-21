/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import models.User;

/**
 *
 * @author Admin
 */
public interface IUserDAO {
    
    public User Login(String userName, String password) throws ClassNotFoundException;
    public void Register(String name,String userName, String password) throws ClassNotFoundException;   
}
