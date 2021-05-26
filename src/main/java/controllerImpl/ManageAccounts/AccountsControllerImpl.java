package controllerImpl.ManageAccounts;

import java.util.Collection;

import controller.ManageAccounts.AccountsController;
import model.ManageAccounts.AccountModel;
import utilities.ManageAccounts.Account;
import view.ManageAccounts.LoginAccountGUI;
import view.ManageAccounts.ManagementAccountGUI;
import view.ManageAccounts.RegistrationAccountGUI;

public class AccountsControllerImpl implements AccountsController{
    
    private AccountModel model;
    //implementes viewObserver
    private LoginAccountGUI loginView;
    private ManagementAccountGUI managementView;
    private RegistrationAccountGUI registrationView;
    
    public AccountsControllerImpl () {
       // model = new AccountModelimpl ();
        
    }
        
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Account login(String username, String password) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addAccount(Account newAccount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAccount(Account oldAccount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<Account> getAccounts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadAccount(Collection<Account> loadedAccounts) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void showManageAccountsView() {
        // TODO Auto-generated method stub
        
    }
}
