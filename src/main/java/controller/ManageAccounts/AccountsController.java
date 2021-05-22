package controller.ManageAccounts;
import java.util.Collection;

import utilities.ManageAccounts.Account;
import utilitiesImpl.FilmBasicImpl;

public interface AccountsController {
	
	public Account login(String username, String password); //returns logged-in account
	
	public void addAccount(Account newAccount);
	public void deleteAccount(Account oldAccount);
	
	public Collection <Account> getAccounts();
	
	public void loadAccount(Collection <Account> loadedAccounts);

	public void showManageAccountsView();
	
	public void showMenu();
	
}
