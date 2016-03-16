/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.police.FrontController;
import pl.police.MainApp;
import pl.police.Interfaces.gui.CallBack;
import pl.police.Interfaces.gui.Setable;
import pl.police.Interfaces.gui.SetableScene;
import pl.police.communication.ServerService;
import pl.police.guiFactory.UserGuiFactory;
import pl.police.guiFactory.Workers.WorkerFactory;
import pl.police.model.UserModel;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class MenuController implements Initializable, SetableScene, CallBack {

    private UserModel model;
    @FXML
    private Button searchButton;
    @FXML
    private Button manageCasesButton;
    @FXML
    private Button managePersonsButton;
    @FXML
    private Button settingsButton;
    private MainApp mainApp;
    private Scene scene;
    private Node node;

    public MenuController() {
        try {
            Parent pane = null;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pl/police/view/menu/Menu.fxml"));
            loader.setController(this);
            pane = loader.load();
            setNode(pane);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void buttonClicked(ActionEvent e) throws IOException {
        WorkerFactory wf = new WorkerFactory();
        if (searchButton == e.getSource()) {
            BorderPane pane = (BorderPane) manageCasesButton.getScene().getRoot();
            Node node = FrontController.getInstance().getPeopleListController().getNode();
            pane.setCenter(node);
        } else if (manageCasesButton == e.getSource()) {
            // UserGuiFactory.getInstance().createGui(wf.createCasesListWorker(mainApp, (BorderPane) manageCasesButton.getScene().getRoot()));
            BorderPane pane = (BorderPane) manageCasesButton.getScene().getRoot();
            Node node = FrontController.getInstance().getCasesListController().getNode();
            pane.setCenter(node);

        } else if (managePersonsButton == e.getSource()) {
            BorderPane pane = (BorderPane) manageCasesButton.getScene().getRoot();
            Node node = FrontController.getInstance().getMainWindowController().getNode();
            pane.setCenter(node);
        } else if (settingsButton == e.getSource()) {
            BorderPane pane = (BorderPane) settingsButton.getScene().getRoot();
            Node node = FrontController.getInstance().getSettingsController().getNode();
            pane.setCenter(node);

        }

    }

    public void topMenuRefresh() {
        FrontController.getInstance().loadData();
    }
    public void onClose()
    {
        mainApp.onClose();
    }
    public void topMenuCheckConnection() {
        ServerService.getInstance().hearthBeatProtocol();
    }
    public void topMenuShowAuthors() {
        FrontController.getInstance().getAuthorsController().getStage().showAndWait();
    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    public Setable getController() {
        return this;
    }

    public UserModel getModel() {
        return model;
    }

    public void setModel(UserModel model) {
        this.model = model;
    }

    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public Node getNode() {
        return node;
    }
}
