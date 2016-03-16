/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.model;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import pl.police.communication.ServerService;
import model.cases.PoliceCaseProperties;

/**
 *
 * @author Bartosz
 */
public class CasesModel {

    private ObservableList<PoliceCaseProperties> cases = FXCollections.observableArrayList();
    public CasesModel() {

    }

    public ObservableList<PoliceCaseProperties> getCases() {
        return cases;
    }

    public void setCases(ObservableList<PoliceCaseProperties> cases) {
        this.cases = cases;
    }
}
