package utilitiesImpl.ManageAccounts;

public class LoggedAccount {
    private LoggedAccount() {};
    
    //is for the first execution 
    private static final LoggedAccount SINGLETON = new LoggedAccount();
    
    public static LoggedAccount getLoggedAccount() {
        return SINGLETON;
    }
}
