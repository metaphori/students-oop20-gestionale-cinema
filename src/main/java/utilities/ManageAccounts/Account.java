package utilities.ManageAccounts;

public interface Account {
    
    /**
     * Returns the account's name.
     * @return name
     */
    String getName();
    
    /**
     * Sets the account's name.
     * @param name
     */
    void setName(String name);

    /**
     * Returns the account's surname.
     * @return surname
     */
    String getSurname();
    
    /**
     * Sets the account's surname.
     * @param surname
     */
    void setSurname(String surname);

    /**
     * Returns the account's username.
     * @return username
     */
    String getUsername();
    
    /**
     * Sets the account's username.
     * @param username 
     */
    void setUsername(String username);

    /**
     * Returns the account's password.
     * @return pass
     */
    String getPassword();
    
    /**
     * Sets the account's password.
     * @param pass 
     */
    void setPassword(String pass);

    /**
     * Returns the account's type. Administrator or operator.
     * @return type
     */
    TypeAccount type();


}

