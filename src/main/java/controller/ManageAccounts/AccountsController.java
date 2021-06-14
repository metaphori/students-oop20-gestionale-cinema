package controller.ManageAccounts;

import java.util.Set;

import utilities.ManageAccounts.Account;
import utilitiesImpl.ManageAccounts.LoggedAccount;

public interface AccountsController {
	
	//public Account login(String username, String password); 
	
	public void addAccount(Account newAccount);
	public void deleteAccount(Account oldAccount);
	
	public Set <Account> getAccounts();
	
	public LoggedAccount loadAccount(Set <Account> loadedAccounts); //returns logged-in account

	public void showMenu();
	public void showRegistrationAccountView();
        public void showManagementAccountView();
        public void showLoginAccounView();
        public void showInfoAccountView(Account acc);
}
