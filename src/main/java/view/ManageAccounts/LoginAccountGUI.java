package view.ManageAccounts;

import java.util.Set;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;

public interface LoginAccountGUI {
    void show();
    void setObserver(AccountsController observer);
    void updateSetAccount(Set<Account> setAccount);
}
