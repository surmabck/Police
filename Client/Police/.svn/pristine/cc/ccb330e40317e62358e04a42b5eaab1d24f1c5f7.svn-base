/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import pl.police.Interfaces.gui.SetableDialog;
import pl.police.MainApp;
import pl.police.guiFactory.UserGuiFactory;

/**
 *
 * @author Bartosz
 */
public class AlertDialogController implements SetableDialog, Initializable {

    private Stage stage;
    private MainApp mainApp;
    private Alert alert;
    private AlertType type;
    private Button b1;
    private Button b2;
    public AlertDialogController() {
        type = AlertType.CONFIRMATION;
        alert = new Alert(type);
        b1 = new Button();
        b2 = new Button();
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("/pl/police/view/MainCss.css");
        dialogPane.getStyleClass().add("myDialog");
        ButtonBar buttonBar = (ButtonBar) alert.getDialogPane().lookup(".button-bar");
        buttonBar.getButtons().clear();
        b1.getStyleClass().add("common-button");
        b1.setText("Tak");
        b1.setOnAction((ActionEvent event) -> {
            onClose(event);
        });
        b2.getStyleClass().add("common-button");
        b2.setText("Nie");
        b2.setOnAction((ActionEvent event) -> {
            onClose(event);
        });
        buttonBar.getButtons().add(b1);
        buttonBar.getButtons().add(b2);
    }

    public void onClose(ActionEvent event) {
        if (event.getSource() == b1)
        {
            alert.setResult(ButtonType.YES);
        }
        else if (event.getSource() ==b2)
        {
            alert.setResult(ButtonType.NO);
        }
        alert.close();
    }
    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    @Override
    public void setDialog(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Stage getDialog() {
        return stage;
    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
