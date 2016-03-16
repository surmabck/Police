/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.peopleListGui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import pl.police.Interfaces.gui.CallBack;
import pl.police.MainApp;
import pl.police.communication.ServerService;
import model.person.PersonProperties;
import pl.police.FrontController;
import pl.police.Interfaces.gui.Setable;
import pl.police.Interfaces.gui.SetableScene;
import pl.police.model.SearchModel;
import pl.police.view.menu.peopleListGui.Dialog.PersonAddDialogController;
import pl.police.view.menu.peopleListGui.Dialog.PersonEditDialogController;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class PeopleListController implements Initializable, SetableScene, CallBack {

    /**
     * Initializes the controller class.
     */
    private SearchModel model;
    private PersonProperties currPerson;
    private Scene scene;
    private Node node;
    private SortedList<PersonProperties> sortedData ;
    public PeopleListController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/menu/peopleListGui/PeopleList.fxml"));
            loader.setController(this);
            Parent parent = loader.load();
            setNode(parent);
        } catch (IOException ex) {
            Logger.getLogger(PeopleListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new SearchModel();
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getSurNameProperty());

        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        filteredData = new FilteredList<>(model.getPeople(), p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        personTable.setItems(sortedData);
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public void setCurrPerson(PersonProperties person) {
        this.currPerson = person;
    }

    public void loadContent() {
        model.getPeople().clear();
        ServerService.getInstance().getPeople((CallBack) FrontController.getInstance().getPeopleListController());
    }

    private void clearLabels() {
        nameLabel.setText("");
        surnameLabel.setText("");
        ageLabel.setText("");
        cityLabel.setText("");
        streetLabel.setText("");
        houseLabel.setText("");
        postLabel.setText("");
        phoneLabel.setText("");
    }

    private void showPersonDetails(PersonProperties person) {
        if (person != null) {
            StringConverter<Number> converter = new NumberStringConverter();
            this.currPerson = person;
            nameLabel.textProperty().bind(person.getNameProperty());
            surnameLabel.textProperty().bind(person.getSurNameProperty());
            ageLabel.textProperty().bind(Bindings.convert(person.getAgeProperty()));
            cityLabel.textProperty().bind(person.getAddress().getCityNameProperty());
            streetLabel.textProperty().bind(person.getAddress().getStreetNameProperty());
            houseLabel.textProperty().bind(person.getAddress().getApartmentProperty());
            postLabel.textProperty().bind(person.getAddress().getPostCodeProperty());
            phoneLabel.textProperty().bind(Bindings.convert(person.getPhoneNumberProperty()));
        }
    }

    public void editButtonHandle() {
        PersonEditDialogController controller = FrontController.getInstance().getPersonEditDialogController();
        controller.setPerson(currPerson);
        controller.getStage().setTitle("Edycja");
        controller.getStage().showAndWait();
    }

    public void createButtonHandle() {
        PersonProperties p = new PersonProperties();
        PersonAddDialogController controller = FrontController.getInstance().getPersonAddDialogController();
        controller.setPerson(p);
        controller.getStage().setTitle("Dodawanie");
        controller.getStage().showAndWait();
        if (p != null) {
            model.addPerson(p);
        }
    }

    public void deleteButtonHandle() {
        Alert alert = FrontController.getInstance().getAlertDialogController().getAlert();
        alert.setHeaderText("Potwierdzenie Wyboru");
        alert.setTitle("Confirmation");
        alert.setContentText("Jestes pewny?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            ServerService.getInstance().deletePerson(currPerson.getModel());
            model.deletePerson(currPerson);
        }

    }

    @Override
    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    public void setItems() {
        personTable.setItems(sortedData);
    }
    FilteredList<PersonProperties> filteredData;
    @FXML
    private TextField searchBox;
    @FXML
    private TableView<PersonProperties> personTable;
    @FXML
    private TableColumn<PersonProperties, String> firstNameColumn;
    @FXML
    private TableColumn<PersonProperties, String> lastNameColumn;
    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label houseLabel;
    @FXML
    private Label postLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Button editButton;
    @FXML
    private Button createButton;
    @FXML
    private Button deleteButton;
    private MainApp mainApp;

    public SearchModel getModel() {
        return model;
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
