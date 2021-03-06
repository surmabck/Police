/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.login;

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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.person.user.UserProperties;
import pl.police.Interfaces.gui.CallBack;
import pl.police.Interfaces.gui.Setable;
import pl.police.MainApp;
import pl.police.communication.ServerService;
import pl.police.model.UserModel;
import pl.police.FrontController;
import pl.police.Interfaces.gui.SetableScene;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class LoginOverviewController implements Initializable, SetableScene, CallBack {

    @FXML
    private Button btn;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    private UserModel model;
    private Scene scene;
    private Node node;

    public LoginOverviewController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent pane = null;
            loader.setLocation(MainApp.class.getResource("view/login/LoginOverview.fxml"));
            loader.setController(this);
            pane = loader.load();
            setNode(pane);
        } catch (IOException ex) {
            Logger.getLogger(LoginOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserProperties user = new UserProperties("", "");
        model = new UserModel();
        model.setUser(user);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void buttonClicked(ActionEvent e) throws IOException {
        if (btn == e.getSource()) {
            model.getUser().setLogin(loginField.getText());
            model.getUser().setPassword(passwordField.getText());
            ServerService.getInstance().login(this);
        }
    }

    public void login() {
        Stage stage = (Stage) btn.getScene().getWindow();
        BorderPane p =  (BorderPane) FrontController.getInstance().getMenuController().getNode();
        p.setCenter(FrontController.getInstance().getMainWindowController().getNode());
        stage.setScene(new Scene(p));
        FrontController.getInstance().loadData();

    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }
    private MainApp mainApp;

    public Setable getController() {
        return this;
    }

    public UserModel getModel() {
        return model;
    }

    public void setModel(UserModel model) {
        this.model = model;
    }

}
