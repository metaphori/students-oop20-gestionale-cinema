package controller.ManageAccounts;

import java.util.Set;

import controller.CinemaController;
import utilities.ManageAccounts.Account;
import utilitiesImpl.ManageAccounts.LoggedAccount;

public interface AccountsController {
	
	//public Account login(String username, String password); 
	
	void addAccount(Account newAccount);
	void deleteAccount(Account oldAccount);
	
	Set <Account> getAccounts();
	
	LoggedAccount loadAccount(Set <Account> loadedAccounts); //returns logged-in account

	void showMenu();
	void showRegistrationAccountView();
        void showManagementAccountView();
        void showLoginAccounView();
        void setCinemaController(CinemaController cinemaController);
}
