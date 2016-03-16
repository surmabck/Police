/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.cases.caseDetails.dialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.person.suspect.SuspectProperties;
import pl.police.FrontController;
import pl.police.MainApp;
import pl.police.communication.ServerService;
import pl.police.view.menu.peopleListGui.Dialog.DialogController;

/**
 *
 * @author Bartosz
 */
public class AddSuspectController extends DialogController<SuspectProperties> {

    @FXML
    private TextField amountOfCasesAgainstField;
    @FXML
    private TextField credibilityField;
    private SuspectProperties suspect;

    public AddSuspectController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/menu/cases/caseDetails/dialog/EditSuspectDialog.fxml"));
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
            Logger.getLogger(AddSuspectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTitleLabel("Dodaj Podejrzanego");
    }

    @Override
    public void setPerson(SuspectProperties person) {
        this.suspect = person;
        super.setPerson(person);
        if (person.getAmountOfCasesAgainst() != null) {
            amountOfCasesAgainstField.setText(person.getAmountOfCasesAgainst().toString());
        } else {
            amountOfCasesAgainstField.setText("");
        }
        if (person.getCredibility() != null) {
            credibilityField.setText(person.getCredibility().toString());
        } else {
            credibilityField.setText("");
        }
    }

    @Override
    public String isInputValid() {
        String errorMessage = super.isInputValid();
        if (errorMessage.length() == 0) {
            if (amountOfCasesAgainstField.getText() == null || amountOfCasesAgainstField.getText().length() == 0) {
                errorMessage += "No valid amount of cases against!\n";
            } else {
                try {
                    Integer.parseInt(amountOfCasesAgainstField.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "No valid cases against (must be an integer)!\n";
                }
            }
            if (credibilityField.getText() == null || credibilityField.getText().length() == 0) {
                errorMessage += "No valid credibility!\n";
            } else {
                try {
                    int i = Integer.parseInt(credibilityField.getText());
                    if ((i < 0) || (i > 100)) {
                        errorMessage += "Credibility value in 0-100!\n";

                    }
                } catch (NumberFormatException e) {
                    errorMessage += "No valid credibility (must be an integer)!\n";
                }

            }
        }

        return errorMessage;

    }

    @Override
    public void cancelClicked() {
        onClose();
    }

    @Override
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
            suspect.setCredibility(Integer.parseInt(credibilityField.getText()));
            suspect.setAmountOfCasesAgainst(Integer.parseInt(amountOfCasesAgainstField.getText()));
            //   ServerService.getInstance().addPerson(getPerson().getModel());
            exit();
        } else {
            alertMessage(errorMessage);
        }
    }

    @Override
    public void setDialogStage(Stage stage) {
        super.setDialogStage(stage);

    }

    @Override
    public void onClose() {
        super.getPerson().setId(-1);
        exit();
    }

}
