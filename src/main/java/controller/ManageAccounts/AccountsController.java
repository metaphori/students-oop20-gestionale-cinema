package controller.ManageAccounts;

import java.util.Set;

import utilities.ManageAccounts.Account;

public interface AccountsController {
	
	public Account login(String username, String password); //returns logged-in account
	
	public void addAccount(Account newAccount);
	public void deleteAccount(Account oldAccount);
	
	public Set <Account> getAccounts();
	
	public void loadAccount(Set <Account> loadedAccounts);

	public void showMenu();
	public void showRegistrationAccountView(Account acc);
        public void showManagementAccountView();
        public void showLoginAccounView();
	
}
