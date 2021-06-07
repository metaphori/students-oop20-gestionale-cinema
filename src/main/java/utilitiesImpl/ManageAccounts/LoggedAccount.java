package utilitiesImpl.ManageAccounts;

public class LoggedAccount {
    private static final LoggedAccount SINGLETON = new LoggedAccount();
    private LoggedAccount() {};
    
    public static LoggedAccount getLoggedAccount() {
        return SINGLETON;
    }
}
