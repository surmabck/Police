/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.messages;

import interfaces.fascades.ClientFascade;
import java.io.Serializable;

/**
 *
 * @author Bartosz
 */
public interface MessageToClient extends Serializable{
    public void executeMessage(ClientFascade fascade);
}
