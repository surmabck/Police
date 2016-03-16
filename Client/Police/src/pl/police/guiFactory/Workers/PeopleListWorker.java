/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.guiFactory.Workers;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import pl.police.FrontController;
import pl.police.Interfaces.gui.Setable;
import pl.police.MainApp;
import pl.police.view.menu.peopleListGui.PeopleListController;

/**
 *
 * @author Bartosz
 */
public class PeopleListWorker extends Worker {

    private BorderPane myPane;

    public PeopleListWorker(MainApp app, BorderPane myPane) {
        super(app);
        setName("Search");
        this.myPane = myPane;
    }

    @Override
    protected String call() throws Exception {
        setLoaderLocation("/pl/police/view/peopleListGui/PeopleList.fxml");
        Parent parent = load();
        FrontController.getInstance().setPeopleSearchController((PeopleListController) getController());
        Setable n = (Setable) getController();
        n.setMainApp(getApp());
        Platform.runLater(() -> {
            myPane.setCenter(parent);
        });
        return "Created";
    }

}
