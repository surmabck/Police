/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.guiFactory.Workers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.police.MainApp;
import model.person.PersonProperties;
import pl.police.view.menu.peopleListGui.Dialog.DialogController;
import pl.police.view.menu.peopleListGui.Dialog.PersonAddDialogController;
import pl.police.view.menu.peopleListGui.Dialog.PersonEditDialogController;

/**
 *
 * @author Bartosz
 */
public class DialogWorker extends Worker {

    private PersonProperties p;
    public DialogWorker(String windowName, PersonProperties p, MainApp app, Stage stage) {
        super(app);
        setName(windowName);
        this.p = p;
        this.stage = stage;
    }
    public Object getDialogController()
    {
        switch(getName()){
            case "Edytuj": return new PersonEditDialogController(); 
            case "Dodaj": return new PersonAddDialogController();
        }
        return new PersonEditDialogController();
    }
    @Override
    protected String call() throws Exception {

        setLoaderLocation("view/peopleListGui/Dialog/EditDialog.fxml");
        getLoader().setController(getDialogController());
        Parent pane = null;
        try {
            pane = load();
        } catch (IOException ex) {
            Logger.getLogger(DialogWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(pane);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Stage dialogStage = new Stage();
                dialogStage.setTitle(getName());
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(stage);
                dialogStage.setResizable(false);
                dialogStage.setScene(scene);
                DialogController controller = (DialogController) getController();
                controller.setDialogStage(dialogStage);
                controller.setPerson(p);
                dialogStage.showAndWait();
            }
        });

        return "Created";
    }

}
