package controllerImpl.ManageAccounts;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import controller.CinemaController;
import controller.ManageAccounts.AccountsController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import model.ManageAccounts.AccountModel;
import modelImpl.ManageAccounts.AccountModelImpl;
import utilities.ManageAccounts.Account;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.ManageAccounts.LoggedAccount;
import view.ManageAccounts.LoginAccountGUI;
import view.ManageAccounts.ManagementAccountGUI;
import view.ManageAccounts.RegistrationAccountGUI;
import viewImpl.ManageAccounts.LoginAccountImplGUI;
import viewImpl.ManageAccounts.ManagementAccountImplGUI;
import viewImpl.ManageAccounts.RegistrationAccountImplGUI;

public class AccountsControllerImpl implements AccountsController{
    private AccountModel model;
    
    //implementes viewObserver
    private LoginAccountGUI loginView;
    private ManagementAccountGUI managementView;
    private RegistrationAccountGUI registrationView;
    private CinemaController controllerCinema;
    
    
    private Set<Account> setAccount;
    public AccountsControllerImpl () {
        Optional <Set<Account>> optionalRead = this.readAccount();
        if(optionalRead.isPresent()) {
            model = new AccountModelImpl (optionalRead.get());
        } else {
            model = new AccountModelImpl (new HashSet<>());
        }
        
        loginView = new LoginAccountImplGUI();
        managementView = new ManagementAccountImplGUI();
        registrationView = new RegistrationAccountImplGUI();
        
        this.loginView.setObserver(this);
        this.managementView.setObserver(this);
        this.registrationView.setObserver(this);
    }


    @Override
    public void showMenu() {
        controllerCinema.showMenu();
    }

    @Override
    public void addAccount(Account newAccount) {
        this.model.addAccount(newAccount);
        this.writeAccount(this.getAccounts());
        System.out.println("Add new account:"+ newAccount);  
    }

    @Override
    public void deleteAccount(Account oldAccount) {
        this.model.removeAccount(oldAccount);
       // this.setAccount.remove(oldAccount);
        this.writeAccount(this.getAccounts());
        System.out.println("Remove old account:" + oldAccount);
    }

    @Override
    public Set <Account> getAccounts() {
       // return this.setAccount;
        return this.model.getAccounts();
    }

    @Override
    public LoggedAccount loadAccount(Set<Account> loadedAccounts) {
        return LoggedAccount.getIstance();  
    }

    @Override
    public void showRegistrationAccountView() { //for add account
        registrationView.reset();
        registrationView.show();
    }
    
    @Override
    public void showManagementAccountView() {
        managementView.show();
        managementView.update();
    }

    @Override
    public void showLoginAccounView() {
        loginView.updateSetAccount(this.getAccounts());
        loginView.show();
        
    }
    
    public void setCinemaController(CinemaController cinemaController) {
        this.controllerCinema = cinemaController;
    }
    
    private Optional<Set<Account>> readAccount () {
        final RWobject<Set<Account>> rw = new RWobjectImpl<>(GeneralSettings.ACCOUNT_FILE_PATH);
        final var type = new TypeToken<Set<Account>>() { }.getType();
        return rw.readObj(type);
    }
    
    private void writeAccount (Set<Account> writeAccount) {
        
        final Set<Account> setToWrite = this.getAccounts();
        final var type = new TypeToken<Set<Account>>() { }.getType();
        final RWobject<Set<Account>> rw = new RWobjectImpl<>(GeneralSettings.ACCOUNT_FILE_PATH);
        rw.writeObj(setToWrite, type);
    }
}
