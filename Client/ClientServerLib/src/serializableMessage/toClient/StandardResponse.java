/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toClient;

import interfaces.fascades.ClientFascade;
import interfaces.messages.MessageToClient;

/**
 *
 * @author Bartosz
 */
public class StandardResponse implements MessageToClient{
    private String message;

    public StandardResponse setMessage(String message)
    {
        this.message = message;
        return this;
    }
    @Override
    public void executeMessage(ClientFascade fascade) {
        System.out.println(message);
    }
    
}
