/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toClient;

import interfaces.fascades.ClientFascade;
import interfaces.messages.MessageToClient;
import java.util.List;
import model.person.Person;

/**
 *
 * @author Bartosz
 */
public class GetPeopleResponse implements MessageToClient{
    private List<Person> p;

    public void setPeopleList(List<Person> p) {
        this.p = p;
    }

    @Override
    public void executeMessage(ClientFascade fascade) {
        fascade.getPeopleResponse(p);
    }
    
}
