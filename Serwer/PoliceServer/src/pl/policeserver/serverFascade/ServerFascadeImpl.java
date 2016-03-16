/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.policeserver.serverFascade;

import interfaces.fascades.ServerFascade;
import java.util.ArrayList;
import java.util.List;
import serializableMessage.toClient.GetCasesResponse;
import serializableMessage.toClient.GetPeopleResponse;
import serializableMessage.toClient.LoginResponse;
import serializableMessage.toClient.StandardResponse;
import model.cases.PoliceCase;
import model.person.Person;
import model.person.user.User;
import pl.policeserver.database.DatabaseConnector;
import pl.policeserver.PoliceServer;
import pl.policeserver.ServerRequest;
import serializableMessage.toClient.HearthBeatResponse;

/**
 *
 * @author Bartosz
 */
public class ServerFascadeImpl implements ServerFascade {

    private final ServerRequest request;
    private PoliceServer mainApp;

    public ServerFascadeImpl(ServerRequest request, PoliceServer mainApp) {
        this.request = request;
        this.mainApp = mainApp;
    }

    @Override
    public void login(User user) {
        user.setSessionId("0");
        if (new DatabaseConnector().loginUser(user)) {
            mainApp.createSession(user);
        }
        LoginResponse m = new LoginResponse();
        m.setUser(user);
        request.send(m);
    }

    @Override
    public void getPeople(User user) {
        if (mainApp.checkSession(user)) {
            GetPeopleResponse m = new GetPeopleResponse();
            m.setPeopleList(new DatabaseConnector().getPeople(user));
            request.send(m);
        }
    }

    @Override
    public void addPerson(User user, Person p) {
        if (mainApp.checkSession(user)) {
            Boolean ret = new DatabaseConnector().addPerson(p);
            StandardResponse m = new StandardResponse();
            String message;
            if (ret) {
                message = "Person added";
            } else {
                message = "Cannot add person";
            }
            m.setMessage(message);
            request.send(m);
        }
    }

    @Override
    public void deletePerson(User user, Person p) {
        if (mainApp.checkSession(user)) {
            Boolean ret = new DatabaseConnector().deletePerson(p);
            StandardResponse m = new StandardResponse();
            String message;
            if (ret) {
                message = "Person deleted";
            } else {
                message = "Cannot delete person";
            }
            m.setMessage(message);
            request.send(m);
        }
    }

    @Override
    public void getCases(User user) {
        if (mainApp.checkSession(user)) {
            List<PoliceCase> l = new ArrayList<>();
            new DatabaseConnector().getCases(l, user);
            GetCasesResponse m = new GetCasesResponse();
            m.setCasesList(l);
            request.send(m);
        }
    }

    @Override
    public void updateCase(User user, PoliceCase policeCase) {
        if (mainApp.checkSession(user)) {
            Boolean ret = new DatabaseConnector().updateCase(user,policeCase);
            StandardResponse m = new StandardResponse();
            String message;
            if (ret) {
                message = "Case updated";
            } else {
                message = "Cannot update case";
            }
            m.setMessage(message);
            request.send(m);
        }
    }

    @Override
    public void addCase(User user, PoliceCase policeCase) {
        if (mainApp.checkSession(user)) {
            Boolean ret = new DatabaseConnector().addCase(user,policeCase);
            StandardResponse m = new StandardResponse();
            String message;
            if (ret) {
                message = "Case added";
            } else {
                message = "Cannot add case";
            }
            m.setMessage(message);
            request.send(m);
        }
    }

    @Override
    public void checkIfAlive() {
        request.send(new HearthBeatResponse());
    }

}
