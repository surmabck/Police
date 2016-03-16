/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.guiFactory.Workers;

import javafx.scene.control.Alert.AlertType;
import pl.police.Interfaces.gui.guiFactory.workers.WorkerCreator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.police.MainApp;
import model.person.PersonProperties;

/**
 *
 * @author Bartosz
 */
public class WorkerFactory implements WorkerCreator{



    @Override
    public PeopleListWorker createPeopleListWorker(MainApp app,BorderPane myPane) {
        return new PeopleListWorker(app,myPane);
    }
    @Override
    public AlertDialog createAlertDialog(String errorMessage,String headerMessage, String windowName, Stage stage,AlertType type) {
        return new AlertDialog(errorMessage,headerMessage, windowName, stage,type);
    }

    @Override
    public DialogWorker createDialog(String windowName, PersonProperties p, MainApp app, Stage stage) {
        return new DialogWorker(windowName,p,app,stage);
    }

    @Override
    public CasesListWorker createCasesListWorker(MainApp app, BorderPane myPane) {
        return new CasesListWorker(app,myPane);
    }





}
