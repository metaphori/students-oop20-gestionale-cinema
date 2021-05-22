package view.ManageAccounts;

import java.util.Collection;

import utilities.ManageAccounts.Account;

public interface LoginAccountGUIObserver {
    void showMenu();
    Collection<Account> getAccount();
}
