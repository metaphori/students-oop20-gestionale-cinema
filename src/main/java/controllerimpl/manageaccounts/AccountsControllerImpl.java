package controllerimpl.manageaccounts;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import controller.CinemaController;
import controller.inputoutput.RWobject;
import controller.manageaccounts.AccountsController;
import controllerimpl.inputoutput.RWobjectImpl;
import model.manageaccounts.AccountModel;
import modelimpl.manageaccounts.AccountModelImpl;
import utilities.Account;
import utilitiesimpl.GeneralSettings;
import view.manageaccounts.LoginAccountView;
import view.manageaccounts.ManagementAccountView;
import view.manageaccounts.RegistrationAccountView;
import viewimpl.manageaccounts.LoginAccountImplView;
import viewimpl.manageaccounts.ManagementAccountImplView;
import viewimpl.manageaccounts.RegistrationAccountImplView;

/**
 * Implements Account Controller.
 */
public class AccountsControllerImpl implements AccountsController {
    private AccountModel model;

    //implementes viewObserver
    private LoginAccountView loginView;
    private ManagementAccountView managementView;
    private RegistrationAccountView registrationView;
    private CinemaController controllerCinema;

    private Set<Account> setAccount;

    /**
     * Constructor for the Account Controller.
     */
    public AccountsControllerImpl() {
        Optional<Set<Account>> optionalRead = this.readAccount();
        if (optionalRead.isPresent()) {
            model = new AccountModelImpl(optionalRead.get());
        } else {
            model = new AccountModelImpl(new HashSet<>());
        }

        loginView = new LoginAccountImplView();
        managementView = new ManagementAccountImplView();
        registrationView = new RegistrationAccountImplView();

        this.loginView.setObserver(this);
        this.managementView.setObserver(this);
        this.registrationView.setObserver(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMenu() {
        controllerCinema.showMenu();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addAccount(final Account newAccount) {
        this.model.addAccount(newAccount);
        this.writeAccount(this.getAccounts());
        System.out.println("Add new account:" + newAccount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAccount(final Account oldAccount) {
        this.model.removeAccount(oldAccount);
        this.writeAccount(this.getAccounts());
        System.out.println("Remove old account:" + oldAccount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Account> getAccounts() {
        return this.model.getAccounts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getAccountLogged() {
       return this.model.getAccountLogged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccountLogged(final Account accountLogged) {
        this.model.setAccountLogged(accountLogged);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showRegistrationAccountView() { //for add account
        registrationView.reset();
        registrationView.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showManagementAccountView() {
        managementView.show();
        managementView.update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoginAccounView() {
        loginView.updateSetAccount(this.getAccounts());
        loginView.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCinemaController(CinemaController cinemaController) {
        this.controllerCinema = cinemaController;
    }

    /**
     * Read object in the Account file.
     * @return readAccount
     */
    private Optional<Set<Account>> readAccount() {
        final RWobject<Set<Account>> rw = new RWobjectImpl<>(GeneralSettings.ACCOUNT_FILE_PATH);
        final var type = new TypeToken<Set<Account>>() { }.getType();
        return rw.readObj(type);
    }

    /**
     * Write object in the Account file.
     * @param writeAccount
     */
    private void writeAccount(final Set<Account> writeAccount) {
        final Set<Account> setToWrite = this.getAccounts();
        final var type = new TypeToken<Set<Account>>() { }.getType();
        final RWobject<Set<Account>> rw = new RWobjectImpl<>(GeneralSettings.ACCOUNT_FILE_PATH);
        rw.writeObj(setToWrite, type);
    }

}
