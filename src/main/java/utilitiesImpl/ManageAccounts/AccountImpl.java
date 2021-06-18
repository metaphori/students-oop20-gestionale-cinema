package utilitiesImpl.ManageAccounts;

import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.TypeAccount;

public class AccountImpl implements Account {
    private String name, surname, username, pass;
    private TypeAccount type;

    /**
     * Constructor for the class Account.
     * @param account's name
     * @param account's surname
     * @param account's username
     * @param account's password
     * @param account's type
     */
    public AccountImpl(final String name, final String surname, final String username, final String pass, final TypeAccount type) {
        this.name = name; //Unique name
        this.surname = surname;
        this.username = username;
        this.pass = pass;
        this.type = type;
    }

    /**
     * @return account's name 
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the account's name.
     * @param account's name
     */
    @Override
    public void setName(final String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    /**
     * @return account' surname
     */
    @Override
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the account's surname.
     * @param account' surname
     */
    @Override
    public void setSurname(final String surname) {
        if (!surname.isEmpty()) {
            this.surname = surname;
        }
    }

    /**
     * @return account's username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Sets the account's username.
     * @param account's username 
     */
    @Override
    public void setUsername(final String username) {
        if (!username.isEmpty()) {
            this.username = username;
        }
    }

    /**
     * @return account's password
     */
    @Override
    public String getPassword() {
        return pass;
    }

    /**
     * Sets the account's password.
     * @param account's password 
     */
    @Override
    public void setPassword(final String pass) {
        if (!pass.isEmpty() && !pass.equals(this.pass)) {
            this.pass = pass;
        }
    }

    /**
     * @return the account's type. Administrator or operator.
     */
    @Override
    public TypeAccount type() {
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