/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.cases;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.cases.PoliceCase;
import pl.police.Interfaces.gui.CallBack;

import pl.police.MainApp;
import pl.police.model.CasesModel;
import model.cases.PoliceCaseProperties;
import model.cases.PoliceCaseState;
import pl.police.FrontController;
import pl.police.Interfaces.gui.Setable;
import pl.police.Interfaces.gui.SetableScene;
import pl.police.communication.ServerService;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class CasesListController implements Initializable, SetableScene, CallBack {

    private MainApp mainApp;
    private CasesModel model;
    private PoliceCaseProperties currCase;
    private Scene scene;
    private Node node;

    public CasesListController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/pl/police/view/menu/cases/CasesList.fxml"));
            loader.setController(this);
            Parent pane = loader.load();
            setNode(pane);
        } catch (IOException ex) {
            Logger.getLogger(CasesListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        charte.setTitle("Rozkład proawdzonych spraw");
        charte.setClockwise(false);

        model = new CasesModel();
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().getDescription());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().getState());
        casesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCurrCase(newValue));
        casesTable.getItems().addListener(new ListChangeListener<PoliceCaseProperties>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends PoliceCaseProperties> c) {
                while (c.next()) {
                    Iterator i = c.getAddedSubList().iterator();
                    while (i.hasNext()) {
                        PoliceCaseProperties p = (PoliceCaseProperties) i.next();
                        p.getState().addListener(new ChangeListener<PoliceCaseState>() {
                            @Override
                            public void changed(ObservableValue<? extends PoliceCaseState> observable, PoliceCaseState oldValue, PoliceCaseState newValue) {
                                generateChart(oldValue, newValue);
                            }
                        });
                    }
                }
            }
        });
        model.getCases().addListener(new ListChangeListener<PoliceCaseProperties>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends PoliceCaseProperties> c) {
                while (c.next()) {
                    Iterator i = c.getAddedSubList().iterator();
                    while (i.hasNext()) {
                        PoliceCaseProperties p = (PoliceCaseProperties) i.next();
                        addCaseListener(p);
                    }
                }
            }
        });

    }

    private void addCaseListener(PoliceCaseProperties p) {
        p.getState().addListener(new ChangeListener<PoliceCaseState>() {
            @Override
            public void changed(ObservableValue<? extends PoliceCaseState> observable, PoliceCaseState oldValue, PoliceCaseState newValue) {
                generateChart(oldValue, newValue);
            }
        });
    }

    public void loadCases() {
        model.getCases().clear();
        ServerService.getInstance().getCases();
    }

    public void setItems() {

        casesTable.setItems(model.getCases());
    }

    private void setCurrCase(PoliceCaseProperties curr) {
        this.currCase = curr;
    }

    public void setMainApp(MainApp app) {
        this.mainApp = app;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void buttonClicked(ActionEvent e) {
        if (showButton == e.getSource()) {
            if (currCase != null) {
                PoliceCaseProperties p = new PoliceCaseProperties();
                p.setModel(currCase.getModel());
                FrontController.getInstance().getCaseDetailsController().setPoliceCase(p);
                FrontController.getInstance().getCaseDetailsController().getDialog().showAndWait();
                if (p.getId().get()!=-1)
                {
                    currCase.setModel(p.getModel());
                    ServerService.getInstance().updateCase(currCase.getModel());
                }
            }
        } else if (newCaseButton == e.getSource()) {
            PoliceCaseProperties p = new PoliceCaseProperties();
            FrontController.getInstance().getAddCaseDetailsController().setPoliceCase(p);
            FrontController.getInstance().getAddCaseDetailsController().getDialog().showAndWait();
            if (p.getId().get() != -1) {
                addCaseListener(p);
                generateChart(PoliceCaseState.none,p.getState().get());
                model.getCases().add(p);
                ServerService.getInstance().addCase(p.getModel());
            }
        }
    }

    public void generateChart(int i, int k, int j) {
        completedVal += i;
        inProgressVal += k;
        suspendedVal += j;
        charte.setData(FXCollections.observableArrayList(
                new PieChart.Data("Completed", completedVal),
                new PieChart.Data("In progress", inProgressVal),
                new PieChart.Data("Suspended", suspendedVal)));
    }

    public void generateChart(PoliceCaseState oldValue, PoliceCaseState newValue) {
        switch (oldValue) {
            case inProgress:
                if (inProgressVal > 0) {
                    inProgressVal--;
                }
                break;
            case completed:
                if (completedVal > 0) {
                    completedVal--;
                }
                break;
            case suspended:
                if (suspendedVal > 0) {
                    suspendedVal--;
                }
                break;
        }
        switch (newValue) {
            case inProgress:

                inProgressVal++;

                break;
            case completed:

                completedVal++;

                break;
            case suspended:

                suspendedVal++;

                break;
        }
        charte.setData(FXCollections.observableArrayList(
                new PieChart.Data("Completed", completedVal),
                new PieChart.Data("In progress", inProgressVal),
                new PieChart.Data("Suspended", suspendedVal)));
    }

    public CasesModel getModel() {
        return model;
    }

    public void setModel(CasesModel model) {
        this.model = model;
    }
    @FXML
    private Button newCaseButton;
    @FXML
    private Button showButton;
    @FXML
    private PieChart charte;
    @FXML
    private TableView<PoliceCaseProperties> casesTable;
    @FXML
    private TableColumn<PoliceCaseProperties, Integer> idColumn;
    @FXML
    private TableColumn<PoliceCaseProperties, String> descriptionColumn;
    @FXML
    private TableColumn<PoliceCaseProperties, PoliceCaseState> statusColumn;
    private int completedVal = 0;
    private int inProgressVal = 0;
    private int suspendedVal = 0;

    @Override
    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public Node getNode() {
        return node;
    }

}
