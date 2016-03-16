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
public class ServerUpdateCase implements MessageToServer {
    private PoliceCase policeCase;
    private User user;

    @Override
    public void executeMessage(ServerFascade fascade) {
        fascade.updateCase(user, policeCase);
    }

    public ServerUpdateCase setUser(User u) {
        this.user = u;
        return this;
    }

    public ServerUpdateCase setCase(PoliceCase policeCase) {
        this.policeCase = policeCase;
        return this;
    }

    @Override
    public String toString() {
        return "ServerUpdateCase{" + "policeCase=" + policeCase + ", user=" + user + '}';
    }
    
}
