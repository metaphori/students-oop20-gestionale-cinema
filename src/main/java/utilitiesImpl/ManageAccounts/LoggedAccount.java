package utilitiesImpl.ManageAccounts;

import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.SeatTypeAccount;

public class LoggedAccount {
    private Account account;
    
    private LoggedAccount() {};
    
    //is for the first execution 
    private static final LoggedAccount SINGLETON = new LoggedAccount();
    
    public static LoggedAccount getIstance() {
        return SINGLETON;
    }
    
    public void setAccount (Account account) {
        this.account  = account;
    }
    public Account getAccount() {
        return this.account;
    }
}
