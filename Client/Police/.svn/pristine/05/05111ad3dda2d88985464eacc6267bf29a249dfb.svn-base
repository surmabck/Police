/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.view.menu.cases.caseDetails;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bartosz
 */
public class CaseDetailsController extends CaseController {

    public CaseDetailsController() {
        try {
            Parent pane = null;
            getLoader().setController(this);
            pane = getLoader().load();
            Scene scene = new Scene(pane);
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(scene);
            setDialog(dialogStage);
        } catch (IOException ex) {
            Logger.getLogger(CaseDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onCancel() {
        System.out.println("CANCEL");
        getPoliceCase().getId().set(-1);
       // getPoliceCase().setModel(getCaseModel());
        //setStatus();
        getDialog().close();
    }

    @Override
    public void onSave() {
        //TODO DATABASe
        getDialog().close();

    }
}
