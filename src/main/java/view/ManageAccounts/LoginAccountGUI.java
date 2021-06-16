package view.ManageAccounts;

import java.util.Set;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;

public interface LoginAccountGUI {

    /**
     * Show a login view
     */
    void show();

    /**
     * Set Account controller observer
     * @param observer
     */
    void setObserver(AccountsController observer);

    /**
     * Update account
     * @param setAccount
     */
    void updateSetAccount(Set<Account> setAccount);
}
