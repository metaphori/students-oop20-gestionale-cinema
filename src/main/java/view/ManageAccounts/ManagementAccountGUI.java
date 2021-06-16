package view.ManageAccounts;

import controller.ManageAccounts.AccountsController;

public interface ManagementAccountGUI {
    /**
     * Show a management view
     */
    void show();
    
    /**
     * Set Account controller observer
     * @param observer
     */
    void setObserver(AccountsController observer);
    
    /**
     * Update view table of list account
     */
    void update();
}
