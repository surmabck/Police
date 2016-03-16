/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.cases.caseDetails;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.cases.PoliceCase;
import model.cases.PoliceCaseProperties;
import model.cases.PoliceCaseState;
import model.person.suspect.SuspectProperties;
import model.person.witness.WitnessProperties;
import pl.police.FrontController;
import pl.police.Interfaces.gui.SetableDialog;
import pl.police.MainApp;
import pl.police.view.menu.cases.caseDetails.dialog.AddSuspectController;
import pl.police.view.menu.cases.caseDetails.dialog.AddWitnessController;
import pl.police.view.menu.cases.caseDetails.dialog.EditSuspectController;
import pl.police.view.menu.cases.caseDetails.dialog.EditWitnessController;

/**
 *
 * @author Bartosz
 */
public abstract class CaseController implements Initializable, SetableDialog {

    private FilteredList<SuspectProperties> filteredSuspects;
    private FilteredList<WitnessProperties> filteredVictims;
    private SortedList<SuspectProperties> sortedSuspects;
    private SortedList<WitnessProperties> sortedVictims;
    private PoliceCaseProperties policeCase;
    @FXML
    private TableView<SuspectProperties> suspectTable;
    @FXML
    private TableColumn<SuspectProperties, String> firstSuspectNameColumn;
    @FXML
    private TableColumn<SuspectProperties, String> lastSuspectNameColumn;

    @FXML
    private TableView<WitnessProperties> victimTable;
    @FXML
    private TableColumn<WitnessProperties, String> firstVictimNameColumn;
    @FXML
    private TableColumn<WitnessProperties, String> lastVictimNameColumn;
    private Stage stage;
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private Button addVictimButton;
    @FXML
    private Button showVictimButton;
    @FXML
    private Button deleteVictimButton;
    @FXML
    private Button addSuspectButton;
    @FXML
    private Button showSuspectButton;
    @FXML
    private Button deleteSuspectButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField searchSuspects;
    @FXML
    private TextField searchVictims;
    @FXML
    private ChoiceBox statusChoiceBox;
    private PoliceCase caseModel;
    private SuspectProperties currSuspect;
    private WitnessProperties currVictim;
    private FXMLLoader loader = new FXMLLoader();

    public CaseController() {
        loader.setLocation(MainApp.class.getResource("view/menu/cases/caseDetails/CaseDetails.fxml"));
    }

    public PoliceCaseProperties getPoliceCase() {
        return policeCase;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currSuspect = null;
        currVictim = null;
        firstSuspectNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        lastSuspectNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurNameProperty());

        firstVictimNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        lastVictimNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurNameProperty());
        victimTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCurrVictim(newValue));
        statusChoiceBox.setItems(FXCollections.observableArrayList(
                "W trakcie", "Zakończona",
                "Zawieszona"));
        statusChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String b = (String) statusChoiceBox.getItems().get((Integer) number2);
                if (b.equals("W trakcie")) {
                    policeCase.getState().set(PoliceCaseState.inProgress);
                } else if (b.equals("Zakończona")) {
                    policeCase.getState().set(PoliceCaseState.completed);

                } else {
                    policeCase.getState().set(PoliceCaseState.suspended);

                }
            }

        });
        suspectTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCurrSuspect(newValue));

    }

    public void setCurrSuspect(SuspectProperties newValue) {
        this.currSuspect = newValue;

    }

    private void setCurrVictim(WitnessProperties newValue) {
        this.currVictim = newValue;

    }

    public void buttonClicked(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            onCancel();
        } else if (e.getSource() == saveButton) {
            onSave();
        } else if (e.getSource() == addVictimButton) {
            WitnessProperties p = new WitnessProperties();
            AddWitnessController controller = FrontController.getInstance().getAddWitnessController();
            controller.setPerson(p);
            controller.getStage().setTitle("Dodaj świadka");
            controller.getStage().showAndWait();
            if ((p != null) && (p.getId() != -1)) {
                policeCase.getVictims().add(p);
            }

        } else if (e.getSource() == showVictimButton) {
            if (currVictim != null) {

                WitnessProperties p = new WitnessProperties();
                p.setModel(currVictim.getModel());
                EditWitnessController controller = FrontController.getInstance().getEditWitnessController();
                controller.setPerson(p);
                controller.getStage().setTitle("Edytuj świadka");
                controller.getStage().showAndWait();
                if ((p != null) && (p.getId() != -1)) {
                    currVictim.setModel(p.getModel());
                }
            }

        } else if (e.getSource() == deleteVictimButton) {
            Alert alert = FrontController.getInstance().getAlertDialogController().getAlert();
            alert.setHeaderText("Potwierdzenie Wyboru");
            alert.setTitle("Confirmation");
            alert.setContentText("Jestes pewny?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                boolean remove = policeCase.getVictims().remove(currVictim);
            }

        } else if (e.getSource() == addSuspectButton) {
            SuspectProperties p = new SuspectProperties();
            AddSuspectController controller = FrontController.getInstance().getAddSuspectController();
            controller.setPerson(p);
            controller.getStage().setTitle("Dodaj podejrzanego");
            controller.getStage().showAndWait();
            if ((p != null) && (p.getId() != -1)) {
                System.out.println("Dodaje podejrzanego");
                policeCase.getSuspects().add(p);
            }

        } else if (e.getSource() == showSuspectButton) {
            if (currSuspect != null) {
                SuspectProperties p = new SuspectProperties();
                p.setModel(currSuspect.getModel());
                EditSuspectController controller = FrontController.getInstance().getEditSuspectController();
                controller.setPerson(p);
                controller.getStage().setTitle("Edytuj podejrzanego");
                controller.getStage().showAndWait();
                if ((p != null) && (p.getId() != -1)) {
                    currSuspect.setModel(p.getModel());
                }
            }

        } else if (e.getSource() == deleteSuspectButton) {
            Alert alert = FrontController.getInstance().getAlertDialogController().getAlert();
            alert.setHeaderText("Potwierdzenie Wyboru");
            alert.setTitle("Confirmation");
            alert.setContentText("Jestes pewny?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
                boolean remove = policeCase.getSuspects().remove(currSuspect);
            }
        }

    }

    public void setStatus() {
        if (policeCase.getState().get() == PoliceCaseState.completed) {
            statusChoiceBox.getSelectionModel().select("Zakończona");
        } else if (policeCase.getState().get() == PoliceCaseState.inProgress) {
            statusChoiceBox.getSelectionModel().select("W trakcie");
        } else {
            statusChoiceBox.getSelectionModel().select("Zawieszona");
        }
    }

    public void setPoliceCase(PoliceCaseProperties p) {
        this.policeCase = p;
        caseModel = p.getModel();
        victimTable.setItems(policeCase.getVictims());
        suspectTable.setItems(policeCase.getSuspects());
        setStatus();
        shortDescriptionField.textProperty().bindBidirectional(policeCase.getDescription());
        descriptionField.textProperty().bindBidirectional(policeCase.getLongDescription());
        filteredSuspects = new FilteredList<>(policeCase.getSuspects(), pp -> true);

        searchSuspects.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredSuspects.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (person.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });
        sortedSuspects = new SortedList<>(filteredSuspects);
        sortedSuspects.comparatorProperty().bind(suspectTable.comparatorProperty());
        suspectTable.setItems(sortedSuspects);
        filteredVictims = new FilteredList<>(policeCase.getVictims(), pp -> true);

        searchVictims.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredVictims.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (person.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                }
                return false; 
            });
        });
        sortedVictims= new SortedList<>(filteredVictims);
        sortedVictims.comparatorProperty().bind(victimTable.comparatorProperty());
        victimTable.setItems(sortedVictims);

    }

    public abstract void onSave();

    public abstract void onCancel();

    @Override
    public void setMainApp(MainApp app) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDialog(Stage stage) {
        this.stage = stage;
        this.stage.setOnCloseRequest((WindowEvent we) -> {
            onCancel();
        });
    }

    @Override
    public Stage getDialog() {
        return stage;
    }

    public PoliceCase getCaseModel() {
        return caseModel;
    }

}
