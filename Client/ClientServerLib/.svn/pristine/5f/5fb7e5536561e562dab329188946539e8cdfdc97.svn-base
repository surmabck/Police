/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toClient;

import interfaces.fascades.ClientFascade;
import interfaces.messages.MessageToClient;
import model.person.user.User;

/**
 *
 * @author Bartosz
 */
public class LoginResponse implements MessageToClient{
    private User user;
    public void setUser(User user)
    {
        this.user = user;
    }
    @Override
    public void executeMessage(ClientFascade fascade) {
        fascade.loginResponse(user);
    }
    
}
