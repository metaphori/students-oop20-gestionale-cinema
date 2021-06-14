package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;

public interface RegistrationAccountGUI {
    void show();
    void setObserver(AccountsController observer);
    void loadAccount(Account account);
    void reset();
}
