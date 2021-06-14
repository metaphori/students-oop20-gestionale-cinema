package modelImpl.ManageAccounts;

import java.util.HashSet;
import java.util.Set;

import model.ManageAccounts.AccountModel;
import utilities.ManageAccounts.Account;


public class AccountModelImpl implements AccountModel{
    private final Set<Account> collect;
    
    public AccountModelImpl(Set<Account> setAccount) {
        this.collect = setAccount; //collezioni senza duplicati
    }
    
    @Override
    public void addAccount(final Account newAccount) {
        this.collect.add(newAccount);        
    }

    @Override
    public void removeAccount(final Account oldAccount) {
        this.collect.remove(oldAccount);        
    }

    @Override
    public Set<Account> getAccounts() {
        return this.collect;
    }
    
    @Override
    public String toString() {
        return "Account " + collect ;
    }

}
