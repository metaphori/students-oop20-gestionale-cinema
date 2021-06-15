package model.ManageAccounts;

import java.util.Set;

import utilities.ManageAccounts.Account;

public interface AccountModel {

    void addAccount(Account newAccount);
    void removeAccount(Account oldAccount);
    Set<Account> getAccounts();
}
