package utilitiesImpl.ManageAccounts;

import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.TypeAccount;

public class AccountImpl implements Account {
    private String name, surname, username, pass;
    private TypeAccount type;
    
    /**
     * Constructor for the class Account.
     * @param name
     * @param surname
     * @param username
     * @param pass 
     * @param type
     */
    public AccountImpl(String name, String surname, String username, String pass, TypeAccount type) {
        this.name = name; //Unique name
        this.surname = surname;
        this.username = username;
        this.pass = pass;
        this.type = type;
    }
     
    
    /**
     * Returns the account's name.
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Sets the account's name.
     * @param name
     */
    @Override
    public void setName(String name) {
        if (!name.isEmpty())
            this.name = name;
    }
    
    /**
     * Returns the account's surname.
     * @return surname
     */
    @Override
    public String getSurname() {
        return surname;
    }
    
    /**
     * Sets the account's surname.
     * @param surname
     */
    @Override
    public void setSurname(String surname) {
        if (!surname.isEmpty())
            this.surname = surname;
    }
    
    /**
     * Returns the account's username.
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the account's username.
     * @param username 
     */
    @Override
    public void setUsername(String username) {
        if (!username.isEmpty())
            this.username = username;
    }
    
    /**
     * Returns the account's password.
     * @return pass
     */
    @Override
    public String getPassword() {
        return pass;
    }
    
    /**
     * Sets the account's password.
     * @param pass 
     */
    @Override
    public void setPassword(String pass) {
        if (!pass.isEmpty() && !pass.equals(this.pass))
            this.pass = pass;
    }
    
    /**
     * Returns true if the account is an administrator.
     * @return type
     */
    @Override
    public TypeAccount isAdmin() {
        return this.type;
    }
    
    @Override
    public String toString() {
        return "Account :"
                + " Name: " + name + ", Surname: " + surname + ", Username: " + username + ", Type: " + type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pass == null) ? 0 : pass.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccountImpl other = (AccountImpl) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pass == null) {
            if (other.pass != null)
                return false;
        } else if (!pass.equals(other.pass))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (type != other.type)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }


   
}