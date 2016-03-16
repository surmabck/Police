/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.guiFactory;

import pl.police.Interfaces.gui.guiFactory.GuiCreator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import pl.police.FrontController;
import pl.police.MainApp;
import pl.police.guiFactory.Workers.Worker;

/**
 *
 * @author Bartosz
 */
public class UserGuiFactory implements GuiCreator {

    private String currStage;
    private String prevStage;
    private static UserGuiFactory instance;
    private ExecutorService service;
    private MainApp mainApp;

    public UserGuiFactory() {
        start();
        currStage = "load";
        prevStage = currStage;
    }

    public MainApp getMainApp() {
        return mainApp;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public static UserGuiFactory getInstance() {
        if (instance == null) {
            instance = new UserGuiFactory();
            return instance;
        } else {
            return instance;
        }
    }

    public void start() {
        this.service = Executors.newCachedThreadPool();

    }

    public void stop() {
        this.service.shutdownNow();
    }

    public void submit(Worker t) {
        Future<String> s = (Future<String>) service.submit(t);
        setCurrStage(t.getName());

    }
    public void createGui(Worker t) {
        if (!t.getName().equalsIgnoreCase(getCurrStage())) {
            submit(t);
        }
    }

    public String getCurrStage() {
        return currStage;
    }

    public void setCurrStage(String currStage) {
        prevStage = this.currStage;
        this.currStage = currStage;
    }

    public void closeDialog() {
        this.currStage = prevStage;
    }

}
