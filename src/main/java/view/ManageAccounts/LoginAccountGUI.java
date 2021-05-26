package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;

public interface LoginAccountGUI {
    void show();
    void setDimensions(int x, int y);
    void setObserver(AccountsController observer );
    void showMenu();
}
