package controllerImpl.ManageAccounts;

import java.util.Set;

import controller.ManageAccounts.AccountsController;
import model.ManageAccounts.AccountModel;
import modelImpl.ManageAccounts.AccountModelImpl;
import utilities.ManageAccounts.Account;
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
    
    
    private Set<Account> setAccount;
    public AccountsControllerImpl () {
        model = new AccountModelImpl ();
        loginView = new LoginAccountImplGUI();
        managementView = new ManagementAccountImplGUI();
        registrationView = new RegistrationAccountImplGUI();
        
        this.loginView.setObserver(this);
        this.managementView.setObserver(this);
        this.registrationView.setObserver(this);
    }
    
    
    public AccountsControllerImpl (Set<Account> setAccount) {
        model = new AccountModelImpl ();
        loginView = new LoginAccountImplGUI();
        managementView = new ManagementAccountImplGUI();
        registrationView = new RegistrationAccountImplGUI();
        
        this.loginView.setObserver(this);
        this.managementView.setObserver(this);
        this.registrationView.setObserver(this);
        
        this.setAccount = setAccount;
    }
        
    @Override
    public void showMenu() {
      
    }

    /*
    @Override
    public Account login(String username, String password) {
        return (Account) LoggedAccount.getLoggedAccount();
    }
    */
    
    @Override
    public void addAccount(Account newAccount) {
        this.model.addAccount(newAccount);
        System.out.println("Add new account:"+ newAccount);  
        //this.write
    }

    @Override
    public void deleteAccount(Account oldAccount) {
        this.model.removeAccount(oldAccount);
        this.setAccount.remove(oldAccount);
        System.out.println("Remove old account:" + oldAccount);
    }

    @Override
    public Set <Account> getAccounts() {
        return this.setAccount;
       // return this.model.getAccounts();
    }

    @Override
    public LoggedAccount loadAccount(Set<Account> loadedAccounts) {
        return LoggedAccount.getIstance();  
    }

    @Override
    public void showInfoAccountView(Account acc) { //for click on specific account
        registrationView.show();
        registrationView.loadAccount(acc);
    }

    @Override
    public void showRegistrationAccountView() { //for add account
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

    //write account on files
}
