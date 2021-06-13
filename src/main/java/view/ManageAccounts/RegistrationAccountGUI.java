package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;

public interface RegistrationAccountGUI {
    void show();
    void setObserver(AccountsController observer);
    void setDimensions(int x, int y);
    void loadAccount(Account account);
}
