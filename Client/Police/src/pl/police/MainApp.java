/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police;

import pl.police.guiFactory.Workers.WorkerFactory;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.police.communication.ServerService;
import pl.police.guiFactory.*;

/**
 *
 * @author Bartosz
 */
public class MainApp extends Application {

    private String currentState;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            onClose();
        });
        WorkerFactory wf = new WorkerFactory();
        FrontController.getInstance().setMainApp(this);
        FrontController.getInstance().loadControllers();
        primaryStage.setScene(new Scene((Parent) FrontController.getInstance().getLoginController().getNode()));
        primaryStage.show();

    }

    public void setState(String s) {
        this.currentState = s;
    }

    public void onClose() {
        UserGuiFactory.getInstance().stop();
        ServerService.getInstance().stop();
        primaryStage.close();
    }

    public String getState() {
        return this.currentState;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
