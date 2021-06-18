package controller.ManageAccounts;

import java.util.Set;

import controller.CinemaController;
import utilities.ManageAccounts.Account;

public interface AccountsController {
	
        /**
         * Add new Account.
         * @param new Account to add
         */
	void addAccount(Account newAccount);
	
	/**
	 * Delete specific Account. 
	 * @param old Account to remove
	 */
	void deleteAccount(Account oldAccount);
	
	/**
	 * Recover all account from account's set.
	 * @return set of Accounts
	 */
	Set<Account> getAccounts(); 

	/**
	 * Show menu view.
	 */
	void showMenu();
	
	/**
	 * Show view to add a new account.
	 */
	void showRegistrationAccountView();
	
	/**
	 * Show view with all account.
	 */
        void showManagementAccountView();

        /**
         * Show login view.
         */
        void showLoginAccounView();

        /**
         * Set Cinema Controller.
         * @param cinemaController
         */
        void setCinemaController(CinemaController cinemaController);

        /**
         * Set Account logged in that time.
         * @param accountLogged
         */
        void setAccountLogged(Account accountLogged);

        /**
         * Get Account logged in that time.
         * @param account
         */
        Account getAccountLogged();
}
