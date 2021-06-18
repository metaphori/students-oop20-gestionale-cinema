package model.ManageAccounts;

import java.util.Set;

import utilities.ManageAccounts.Account;

public interface AccountModel {

    /**
     * Add new Account.
     * @param newAccount
     */
    void addAccount(Account newAccount);

    /**
     * Delete specific Account. 
     * @param oldAccount
     */
    void removeAccount(Account oldAccount);

    /**
     * Recover all account from account's set.
     * @return Set<Account> set of Accounts
     */
    Set<Account> getAccounts();

    /**
     * Get Account logged in that time.
     * @return Account Logged
     */
    Account getAccountLogged();

    /**
     * Set Account logged in that time.
     * @return Account Logged
     */
    void setAccountLogged(Account accountLogged);
}
