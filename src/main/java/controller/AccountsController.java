package controller;
import java.util.Collection;

import utilities.Account;
import utilities.Film;

public interface AccountsController {
	
	public Account login(String username, String psw); // returns logged-in account
	
	public void addAccount(Account newAccount);
	public void deleteAccount(Account oldAccount);
	
	public Collection <Account> getAccounts();
	public void loadAccount(Collection <Account> loadedAccounts);

	public void showManageAccountsView();
	
	public void showMenu();
	
}