/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializableMessage.toClient;

import interfaces.messages.MessageToClient;
import interfaces.fascades.ClientFascade;
import java.util.List;
import model.cases.PoliceCase;

/**
 *
 * @author Bartosz
 */
public class GetCasesResponse implements MessageToClient {

    private List<PoliceCase> cases;
    public void setCasesList(List<PoliceCase> cases) {
        this.cases = cases;
    }

    public void executeMessage(ClientFascade fascade) {
        fascade.getCasesReponse(cases);
    }


}
