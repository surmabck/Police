/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.model;
import model.person.user.UserProperties;

/**
 *
 * @author Bartosz
 */
public class UserModel {
    
    private UserProperties user = new UserProperties();
    public UserProperties getUser() {
        return user;
    }
    public void setUser(UserProperties user) {
        this.user = user;
    }
    
    
}
