package model.ManageAccounts;

import java.util.Set;

import utilities.ManageAccounts.Account;

public interface AccountModel {

    /**
     * Add new Account.
     * @param new Account to add
     */
    void addAccount(Account newAccount);

    /**
     * Delete specific Account. 
     * @param old Account to remove
     */
    void removeAccount(Account oldAccount);

    /**
     * Recover all account from account's set.
     * @return set of Accounts
     */
    Set<Account> getAccounts();

    /**
     * Get Account logged in that time.
     * @return Account Logged
     */
    Account getAccountLogged();

    /**
     * Set Account logged in that time.
     * @return Account
     */
    void setAccountLogged(Account accountLogged);
}
