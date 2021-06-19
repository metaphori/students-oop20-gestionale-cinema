package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;

public interface RegistrationAccountGUI {
    /**
     * Show a management view.
     */
    void show();

    /**
     * Set Account controller observer.
     * @param observer that is Account controller
     */
    void setObserver(AccountsController observer);

    /**
     * Reset registartion view.
     */
    void reset();
}
