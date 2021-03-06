/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police;

import pl.police.view.AlertDialogController;
import pl.police.view.menu.cases.CasesListController;
import pl.police.view.login.LoginOverviewController;
import pl.police.view.menu.MenuController;
import pl.police.view.menu.cases.caseDetails.AddCaseDetailsController;
import pl.police.view.menu.cases.caseDetails.CaseDetailsController;
import pl.police.view.menu.cases.caseDetails.dialog.AddSuspectController;
import pl.police.view.menu.cases.caseDetails.dialog.AddWitnessController;
import pl.police.view.menu.cases.caseDetails.dialog.EditSuspectController;
import pl.police.view.menu.cases.caseDetails.dialog.EditWitnessController;
import pl.police.view.menu.main.MainWindowController;
import pl.police.view.menu.peopleListGui.Dialog.PersonAddDialogController;
import pl.police.view.menu.peopleListGui.Dialog.PersonEditDialogController;
import pl.police.view.menu.peopleListGui.PeopleListController;
import pl.police.view.menu.settings.SettingsController;
import pl.police.view.menu.topMenu.AuthorsController;

/**
 *
 * @author Bartosz
 */
public class FrontController {

    private LoginOverviewController loginController;
    private PeopleListController peopleListController;
    private MenuController menuController;
    private static FrontController instance;
    private CasesListController casesListController;
    private CaseDetailsController caseDetailsController;
    private PersonEditDialogController personEditDialogController;
    private PersonAddDialogController personAddDialogController;
    private EditSuspectController editSuspectController;
    private AddSuspectController addSuspectController;
    private AddWitnessController addWitnessController;
    private EditWitnessController editWitnessController;
    private AuthorsController authorsController;
    private MainWindowController mainWindowController;
    private AddCaseDetailsController addCaseDetailsController;
    private SettingsController settingsController;
    private AlertDialogController alertDialogController;
    private MainApp mainApp;

    private FrontController() {

    }

    public AlertDialogController getAlertDialogController() {
        return alertDialogController;
    }

    public void setAlertDialogController(AlertDialogController alertDialogController) {
        this.alertDialogController = alertDialogController;
    }

    public static FrontController getInstance() {
        if (instance == null) {
            instance = new FrontController();
            return instance;
        }
        return instance;
    }

    public void loadControllers() {
        settingsController = new SettingsController();

        loginController = new LoginOverviewController();
        peopleListController = new PeopleListController();
        menuController = new MenuController();
        menuController.setMainApp(mainApp);
        casesListController = new CasesListController();
        caseDetailsController = new CaseDetailsController();
        personEditDialogController = new PersonEditDialogController();
        personAddDialogController = new PersonAddDialogController();
        editSuspectController = new EditSuspectController();
        addSuspectController = new AddSuspectController();
        addWitnessController = new AddWitnessController();
        editWitnessController = new EditWitnessController();
        authorsController = new AuthorsController();
        mainWindowController = new MainWindowController();
        addCaseDetailsController = new AddCaseDetailsController();
        alertDialogController = new AlertDialogController();
    }
    public void setMainApp(MainApp app)
    {
        this.mainApp = app;
    }
    public void loadData() {
        getPeopleListController().loadContent();
        getCasesListController().loadCases();
    }

    public LoginOverviewController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginOverviewController loginController) {
        this.loginController = loginController;
    }

    public PeopleListController getPeopleListController() {
        return peopleListController;
    }

    public void setPeopleSearchController(PeopleListController searchController) {
        this.peopleListController = searchController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setCasesListController(CasesListController casesListController) {
        this.casesListController = casesListController;
    }

    public CasesListController getCasesListController() {
        return casesListController;
    }

    public CaseDetailsController getCaseDetailsController() {
        return caseDetailsController;
    }

    public void setCaseDetailsController(CaseDetailsController caseDetailsController) {
        this.caseDetailsController = caseDetailsController;
    }

    public void setPersonEditDialogController(PersonEditDialogController controller) {
        this.personEditDialogController = controller;
    }

    public PersonEditDialogController getPersonEditDialogController() {
        return personEditDialogController;
    }

    public void setPeopleListController(PeopleListController peopleListController) {
        this.peopleListController = peopleListController;
    }

    public void setPersonAddDialogController(PersonAddDialogController personAddDialogController) {
        this.personAddDialogController = personAddDialogController;
    }

    public PersonAddDialogController getPersonAddDialogController() {
        return personAddDialogController;
    }

    public void setAddSuspectController(AddSuspectController controller) {
        this.addSuspectController = controller;
    }

    public AddSuspectController getAddSuspectController() {
        return addSuspectController;
    }

    public void setEditSuspectController(EditSuspectController controller) {
        this.editSuspectController = controller;
    }

    public EditSuspectController getEditSuspectController() {
        return editSuspectController;
    }

    public AddWitnessController getAddWitnessController() {
        return addWitnessController;
    }

    public void setAddWitnessController(AddWitnessController addWitnessController) {
        this.addWitnessController = addWitnessController;
    }

    public EditWitnessController getEditWitnessController() {
        return editWitnessController;
    }

    public void setEditWitnessController(EditWitnessController editWitnessController) {
        this.editWitnessController = editWitnessController;
    }

    public void setAuthorsController(AuthorsController controller) {
        this.authorsController = controller;
    }

    public AuthorsController getAuthorsController() {
        return authorsController;
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public MainWindowController getMainWindowController() {
        return mainWindowController;
    }

    public AddCaseDetailsController getAddCaseDetailsController() {
        return addCaseDetailsController;
    }

    public void setAddCaseDetailsController(AddCaseDetailsController addCaseDetailsController) {
        this.addCaseDetailsController = addCaseDetailsController;
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public void setSettingsController(SettingsController settingsController) {
        this.settingsController = settingsController;
    }

}
