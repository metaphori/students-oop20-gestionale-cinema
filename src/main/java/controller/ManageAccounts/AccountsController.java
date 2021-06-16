package controller.ManageAccounts;

import java.util.Set;

import controller.CinemaController;
import utilities.ManageAccounts.Account;
import utilitiesImpl.ManageAccounts.LoggedAccount;

public interface AccountsController {
	
        /**
         * Add new Account 
         * @param newAccount
         */
	void addAccount(Account newAccount);
	
	/**
	 * Delete specific Account 
	 * @param oldAccount
	 */
	void deleteAccount(Account oldAccount);
	
	/**
	 * Recover all account from account's set
	 * @return Set<Account> set of Accounts
	 */
	Set<Account> getAccounts();
	
	/**
	 * Retrieve the account logged in at that moment
	 * @param loadedAccounts
	 * @return account logged in at that time
	 */
	LoggedAccount loadAccount(Set<Account> loadedAccounts); 

	/**
	 * Show menu view
	 */
	void showMenu();
	
	/**
	 * Show view to add a new account
	 */
	void showRegistrationAccountView();
	
	/**
	 * Show view with all account 
	 */
        void showManagementAccountView();
        
        /**
         * Show login view
         */
        void showLoginAccounView();

        /**
         * Set Cinema Controller
         * @param cinemaController
         */
        void setCinemaController(CinemaController cinemaController);
}
