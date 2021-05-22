package view;

import java.util.Collection;

import utilities.Account;

public interface LoginAccountGUIObserver {
    void showMenu();
    Collection<Account> getAccount();
}
