/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toServer;

import interfaces.fascades.ServerFascade;
import interfaces.messages.MessageToServer;
import model.cases.PoliceCase;
import model.person.user.User;

/**
 *
 * @author Bartosz
 */
public class ServerAddCase implements MessageToServer{
    private User user;
    private PoliceCase policeCase;

    @Override
    public void executeMessage(ServerFascade fascade) {
        fascade.addCase(user,policeCase);
    }

    public ServerAddCase setUser(User u) {
        this.user = u;
        return this;
    }
    public ServerAddCase setCase(PoliceCase policeCase)
    {
        this.policeCase = policeCase;
        return this;
    }

    @Override
    public String toString() {
        return "ServerAddCase{" + "user=" + user + '}';
    }
    
    
}
