/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.settings;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.police.Interfaces.gui.SetableScene;
import pl.police.MainApp;
import pl.police.view.login.LoginOverviewController;

/**
 *
 * @author Bartosz
 */
public class SettingsController implements SetableScene, Initializable {

    private Node node;
    private MainApp mainApp;
    @FXML
    private TextField serverNameField;
    @FXML
    private TextField serverPortField;
    @FXML
    private TextField refreshField;
    @FXML
    private TextField caretField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    private String serverName;
    private String serverPort;
    private String serverRefresh;
    private String serverCaret;

    public SettingsController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            Parent pane = null;
            loader.setLocation(MainApp.class.getResource("view/menu/settings/Settings.fxml"));
            loader.setController(this);
            pane = loader.load();
            setNode(pane);
        } catch (IOException ex) {
            Logger.getLogger(LoginOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InputStream in = null;
        try {
            Properties props = new Properties();
            in = getClass().getClassLoader().getResourceAsStream("properties/client.properties");
            props.load(in);
            serverName = props.getProperty("server.name");
            serverPort = props.getProperty("server.port");
            serverRefresh = props.getProperty("server.refresh");
            serverCaret = props.getProperty("server.caret");
            serverNameField.setText(serverName);
            serverPortField.setText(serverPort);
            refreshField.setText(serverRefresh);
            caretField.setText(serverCaret);
        } catch (IOException ex) {
            Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Boolean validate() {
        //TODO
        return true;
    }

    public void buttonClicked(ActionEvent e) {
        if (saveButton == e.getSource()) {
            if (validate()) {
               try {

                    Properties props = new Properties();
                    //  in = getClass().getClassLoader().getResourceAsStream("pl/police/properties/client.properties");
                    props.setProperty("server.name", serverNameField.getText());
                    props.setProperty("server.port", serverPortField.getText());
                    props.setProperty("server.refresh", refreshField.getText());
                    props.setProperty("server.caret", caretField.getText());
                    System.out.println(getClass().getClassLoader().getResource("properties/client.properties").getPath());
                    FileOutputStream pp = new FileOutputStream(getClass().getClassLoader().getResource("properties/client.properties").getPath());
                   props.store(pp, "Saved");
                   pp.close();
                } catch (IOException ex) {
                    Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                   
                }
            }

        } else if (cancelButton == e.getSource()) {
            serverNameField.setText("");
            serverPortField.setText("");
            refreshField.setText("");
            caretField.setText("");
        }
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getServerRefresh() {
        return serverRefresh;
    }

    public void setServerRefresh(String serverRefresh) {
        this.serverRefresh = serverRefresh;
    }

    public String getServerCaret() {
        return serverCaret;
    }

    public void setServerCaret(String serverCaret) {
        this.serverCaret = serverCaret;
    }

}
