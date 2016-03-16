/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.peopleListGui.Dialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.police.guiFactory.UserGuiFactory;
import pl.police.guiFactory.Workers.WorkerFactory;
import model.person.PersonProperties;

/**
 *
 * @author Bartosz
 * @param <T>
 */
public abstract class DialogController<T extends PersonProperties> implements Initializable {

    private Stage stage;
    private T person;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setDialogStage(Stage stage) {
        this.stage = stage;
        getStage().setOnCloseRequest((WindowEvent) -> {
            onClose();
        });
    }

    public abstract void onClose();

    public T getPerson() {
        return person;
    }

    public void setPersonObj(T p) {
        this.person = p;
    }

    public void setPerson(T p) {
        this.person = p;
        if (person != null) {
            if (person.getName() != null) {
                nameLabel.setText(person.getName());
            } else {
                nameLabel.setText("");
            }

            if (person.getSurname() != null) {
                surnameLabel.setText(person.getSurname());
            } else {
                surnameLabel.setText("");
            }
            if (person.getAge() != null) {
                ageLabel.setText(person.getAge().toString());
            } else {
                ageLabel.setText("");
            }
            if (person.getAddress().getCityName() != null) {
                cityLabel.setText(person.getAddress().getCityName());
            } else {
                cityLabel.setText("");
            }
            if (person.getAddress().getStreetName() != null) {
                streetLabel.setText(person.getAddress().getStreetName());
            } else {
                streetLabel.setText("");
            }
            if (person.getAddress().getApartment() != null) {
                houseLabel.setText(person.getAddress().getApartment());
            } else {
                houseLabel.setText("");
            }
            if (person.getAddress().getPostCode() != null) {
                postLabel.setText(person.getAddress().getPostCode());
            } else {
                postLabel.setText("");
            }
            if (person.getPhoneNumber().toString() != null) {
                phoneLabel.setText(person.getPhoneNumber().toString());
            } else {
                phoneLabel.setText("");
            }
        }
    }

    public void resetClicked() {
        nameLabel.setText("");
        surnameLabel.setText("");
        ageLabel.setText("");
        cityLabel.setText("");
        streetLabel.setText("");
        houseLabel.setText("");
        postLabel.setText("");
        phoneLabel.setText("");
    }

    public void cancelClicked() {
        exit();
    }

    public abstract void okClicked();

    public void exit() {
        UserGuiFactory.getInstance().closeDialog();
        stage.close();
    }

    public String isInputValid() {
        String errorMessage = "";

        if (nameLabel.getText() == null || nameLabel.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (surnameLabel.getText() == null || surnameLabel.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetLabel.getText() == null || streetLabel.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }
        if (houseLabel.getText() == null || houseLabel.getText().length() == 0) {
            errorMessage += "No valid house!\n";
        }
        if (postLabel.getText() == null || postLabel.getText().length() == 0) {
            errorMessage += "No valid post code!\n";
        }
        if (ageLabel.getText() == null || ageLabel.getText().length() == 0) {
            errorMessage += "No valid age!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(ageLabel.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid age (must be an integer)!\n";
            }
        }
        if (phoneLabel.getText() == null || phoneLabel.getText().length() == 0) {
            errorMessage += "No valid phone number!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(phoneLabel.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid phone number (must be an integer)!\n";
            }
        }
        if (cityLabel.getText() == null || cityLabel.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        return errorMessage;
    }

    public void alertMessage(String errorMessage) {
        WorkerFactory wf = new WorkerFactory();
        UserGuiFactory factory = UserGuiFactory.getInstance();
        factory.createGui(
                wf.createAlertDialog(
                        errorMessage, 
                        "Invalid Fields", 
                        "Please correct given fields", 
                        stage,
                        Alert.AlertType.ERROR));
    }

    public String getTitleLabel() {
        return titleLabel.getText();
    }

    public void setTitleLabel(String titleLabel) {
        this.titleLabel.setText(titleLabel);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getNameLabel() {
        return nameLabel.getText();
    }

    public void setNameLabel(String nameLabel) {
        this.nameLabel.setText(nameLabel);
    }

    public String getSurnameLabel() {
        return surnameLabel.getText();
    }

    public void setSurnameLabel(String surnameLabel) {
        this.surnameLabel.setText(surnameLabel);
    }

    public String getAgeLabel() {
        return ageLabel.getText();
    }

    public void setAgeLabel(String ageLabel) {
        this.ageLabel.setText(ageLabel);
    }

    public String getCityLabel() {
        return cityLabel.getText();
    }

    public void setCityLabel(String cityLabel) {
        this.cityLabel.setText(cityLabel);
    }

    public String getStreetLabel() {
        return streetLabel.getText();
    }

    public void setStreetLabel(String streetLabel) {
        this.streetLabel.setText(streetLabel);
    }

    public String getHouseLabel() {
        return houseLabel.getText();
    }

    public void setHouseLabel(String houseLabel) {
        this.houseLabel.setText(houseLabel);
    }

    public String getPostLabel() {
        return postLabel.getText();
    }

    public void setPostLabel(String postLabel) {
        this.postLabel.setText(postLabel);
    }

    public String getPhoneLabel() {
        return phoneLabel.getText();
    }

    public void setPhoneLabel(String phoneLabel) {
        this.phoneLabel.setText(phoneLabel);
    }

    @FXML
    private TextField nameLabel;
    @FXML
    private TextField surnameLabel;
    @FXML
    private TextField ageLabel;
    @FXML
    private TextField cityLabel;
    @FXML
    private TextField streetLabel;
    @FXML
    private TextField houseLabel;
    @FXML
    private TextField postLabel;
    @FXML
    private TextField phoneLabel;
    @FXML
    private Label titleLabel;
}
