/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.peopleListGui.Dialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.police.FrontController;
import pl.police.MainApp;
import pl.police.communication.ServerService;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class PersonAddDialogController extends DialogController {

    public PersonAddDialogController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/menu/peopleListGui/Dialog/EditDialog.fxml"));
            loader.setController(this);
            Parent pane = null;
            pane = loader.load();
            Scene scene = new Scene(pane);
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setResizable(false);
            dialogStage.setScene(scene);
            setDialogStage(dialogStage);
        } catch (IOException ex) {
            Logger.getLogger(PersonAddDialogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        setTitleLabel("Dodaj");
    }

    public void cancelClicked() {
        setPerson(null);
        exit();
    }

    public void okClicked() {
        String errorMessage = isInputValid();
        if (errorMessage.length() == 0) {
            getPerson().setName(getNameLabel());
            getPerson().setAge(Integer.parseInt(getAgeLabel()));
            getPerson().setSurname(getSurnameLabel());
            getPerson().getAddress().setApartment(getHouseLabel());
            getPerson().getAddress().setCityName(getCityLabel());
            getPerson().getAddress().setPostCode(getPostLabel());
            getPerson().getAddress().setStreetName(getStreetLabel());
            getPerson().setPhoneNumber(Integer.parseInt(getPhoneLabel()));
            ServerService.getInstance().addPerson(getPerson().getModel());
            exit();
        } else {
            alertMessage(errorMessage);
        }
    }

    @Override
    public void onClose() {
        cancelClicked();
    }

}
