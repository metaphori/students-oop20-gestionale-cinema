package modelImpl.ManageAccounts;

import java.util.Set;

import model.ManageAccounts.AccountModel;
import utilities.ManageAccounts.Account;

/**
 * Implements Account model.
 */

public class AccountModelImpl implements AccountModel {
    private final Set<Account> collect;

    /**
     * Construttor for the Account Model.
     */
    public AccountModelImpl(final Set<Account> setAccount) {
        this.collect = setAccount; 
    }

    @Override
    public void addAccount(final Account newAccount) {
        this.collect.add(newAccount);
    }

    @Override
    public void removeAccount(final Account oldAccount) {
        this.collect.remove(oldAccount);
    }

    @Override
    public Set<Account> getAccounts() {
        return this.collect;
    }

    @Override
    public String toString() {
        return "Account " + collect;
    }

}
