/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toServer;

import interfaces.fascades.ServerFascade;
import interfaces.messages.MessageToServer;

/**
 *
 * @author Bartosz
 */
public class HearthBeatMessage implements MessageToServer{

    @Override
    public void executeMessage(ServerFascade fascade) {
        fascade.checkIfAlive();
    }
    
}
