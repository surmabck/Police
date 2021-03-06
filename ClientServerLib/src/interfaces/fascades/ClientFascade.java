/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.fascades;

import java.util.List;
import model.cases.PoliceCase;
import model.person.Person;
import model.person.user.User;

/**
 *
 * @author Bartosz
 */
public interface ClientFascade {
    public void loginResponse(User user);
    public void getPeopleResponse(List<Person> p);
    public void getCasesReponse(List<PoliceCase> cases);
    public void serverAlive();
}
