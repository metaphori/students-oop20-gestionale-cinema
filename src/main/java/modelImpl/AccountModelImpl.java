package modelImpl;

import java.util.Collection;
import java.util.HashSet;

import model.AccountModel;
import utilities.Account;


public class AccountModelImpl implements AccountModel{
    private final Collection<Account> collect;
    
    public AccountModelImpl() {
        collect = new HashSet<>(); //collezioni senza duplicati
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
    public Collection<Account> getAccounts() {
        return this.collect;
    }

}
