/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toServer;

import interfaces.fascades.ServerFascade;
import interfaces.messages.MessageToServer;
import model.person.user.User;

/**
 *
 * @author Bartosz
 */
public class ServerGetPeople implements MessageToServer {
    private User user;
    public ServerGetPeople setUser(User u)
    {
        this.user = u;
        return this;
    }
    @Override
    public void executeMessage(ServerFascade fascade) {
        fascade.getPeople(user);
    }

    @Override
    public String toString() {
        return "ServerGetPeople{" + "user=" + user + '}';
    }
    
}
