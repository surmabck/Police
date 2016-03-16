/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.fascades.clientFascade;

import java.util.List;
import interfaces.fascades.ClientFascade;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import pl.police.FrontController;
import pl.police.guiFactory.UserGuiFactory;
import pl.police.guiFactory.Workers.WorkerFactory;
import model.cases.PoliceCase;
import model.cases.PoliceCaseProperties;
import model.cases.PoliceCaseState;
import model.person.Person;
import model.person.PersonProperties;
import model.person.user.User;
import pl.police.view.login.LoginOverviewController;
import pl.police.view.menu.cases.CasesListController;
import pl.police.view.menu.main.MainWindowController;
import pl.police.view.menu.peopleListGui.PeopleListController;

/**
 *
 * @author Bartosz
 */
public class ClientFascadeImpl implements ClientFascade {

    private final MainWindowController messageBox = FrontController.getInstance().getMainWindowController();

    public ClientFascadeImpl() {

    }

    public void loginResponse(User user) {
        if (!user.getSessionId().equalsIgnoreCase(Integer.toString(0))) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    LoginOverviewController concreteController = FrontController.getInstance().getLoginController();
                    concreteController.getModel().getUser().setModel(user);
                    concreteController.login();
                }
            });
        } else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    WorkerFactory wf = new WorkerFactory();
                    UserGuiFactory.getInstance().createGui(
                            wf.createAlertDialog(
                                    "Login or password is incorrect",
                                    "Login Problem",
                                    "Login Error",
                                    null,
                                    Alert.AlertType.ERROR));
                }
            });
        }

    }

    @Override

    public void getPeopleResponse(List<Person> p) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                PeopleListController concreteController = FrontController.getInstance().getPeopleListController();
                for (Person person : p) {

                    PersonProperties prop = new PersonProperties();
                    prop.setModel(person);
                    concreteController.getModel().addPerson(prop);
                    messageBox.writeMessage("Pobralem :" + prop.getModel());
                }
                concreteController.setItems();
            }
        });
    }

    @Override
    public void getCasesReponse(List<PoliceCase> cases) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                int c = 0, i = 0, s = 0;
                CasesListController concreteController = FrontController.getInstance().getCasesListController();
                for (PoliceCase policeCase : cases) {

                    PoliceCaseProperties prop = new PoliceCaseProperties();
                    prop.setModel(policeCase);
                    concreteController.getModel().getCases().add(prop);
                    messageBox.writeMessage("Pobralem :" + prop.getModel());
                    if (prop.getState().get() == PoliceCaseState.completed) {
                        c++;
                    } else if (prop.getState().get() == PoliceCaseState.inProgress) {
                        i++;
                    } else if (prop.getState().get() == PoliceCaseState.suspended) {
                        s++;
                    }
                }
                concreteController.setItems();
                concreteController.generateChart(c, i, s);
            }
        });
    }

    @Override
    public void serverAlive() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WorkerFactory wf = new WorkerFactory();
                UserGuiFactory.getInstance().createGui(
                        wf.createAlertDialog(
                                "Server is available",
                                "Hearth Beat response",
                                "I'm alive, server said",
                                null,
                                Alert.AlertType.INFORMATION));
            }
        });
    }

}
