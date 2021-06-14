package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;

public interface ManagementAccountGUI {
    void show();
    void setObserver(AccountsController observer);
    void update();
}
