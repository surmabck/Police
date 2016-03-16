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
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.police.MainApp;


/**
 *
 * @author Bartosz
 */
public abstract class Worker extends Task<String> {

    Stage stage;
    private MainApp app;
    private FXMLLoader loader;
    private Stage st;
    private String name;

    public Worker() {
        this(null, null);
    }
    public Worker(Stage stage)
    {
        this(stage,null);
    }
    public Worker(MainApp app) {
        this(null, app);
    }
    public Worker(Stage stage,MainApp app)
    {
        this(stage,app,"load");
    }
    public Worker(Stage stage, MainApp app,String name) {
        this.stage = stage;
        this.app = app;
        st = new Stage();
        loader = new FXMLLoader();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainApp getApp() {
        return app;
    }

    public void setApp(MainApp app) {
        this.app = app;
    }
    public void setController(Object controller)
    {
        loader.setController(controller);
    }
    public void setLoaderLocation(String url) {
        loader.setLocation(MainApp.class.getResource(url));
    }

    public Parent load() throws IOException {
        return loader.load();
    }

    public Object getController() {
        return loader.getController();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public Stage getSt() {
        return st;
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    @Override
    protected abstract String call() throws Exception;
}
