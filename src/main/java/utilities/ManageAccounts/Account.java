package utilities.ManageAccounts;

public interface Account {
    String getName();
    void setName(String name);
    
    String getSurname();
    void setSurname(String surname);
    
    String getUsername();
    void setUsername(String username);
    
    String getPassword();
    void setPassword(String pass);
    
    LoggedAccount isAdmin();
    
    String toString();
    
}

