package utilities.ManageAccounts;

public class AccountOpImpl implements Account {
    private String name, surname, username, password;
    private boolean type;
    
    /**
     * Constructor for the class Account.
     * @param name
     * @param surname
     * @param username
     * @param password 
     * @param type
     */
    public AccountOpImpl(String name, String surname, String username, String password, boolean type) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
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
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the account's password.
     * @param password 
     */
    @Override
    public void setPassword(String password) {
        if (!password.isEmpty() && !password.equals(this.password))
            this.password = password;
    }
    
    /**
     * Returns False if the account is an operator.
     * @return type
     */
    @Override
    public boolean isAdmin() {
        return type = false;
    }
    
    @Override
    public String toString() {
        return "Account Operator:"
                + " Name:" + name + ", Surname:" + surname + ", Username:" + username + ", Is an administrator" + type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + (type ? 1231 : 1237);
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
        AccountOpImpl other = (AccountOpImpl) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
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
