package controllerImpl.ManageAccounts;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import controller.CinemaController;
import controller.ManageAccounts.AccountsController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import model.ManageAccounts.AccountModel;
import modelImpl.ManageAccounts.AccountModelImpl;
import utilities.ManageAccounts.Account;
import utilitiesImpl.GeneralSettings;
import view.ManageAccounts.LoginAccountGUI;
import view.ManageAccounts.ManagementAccountGUI;
import view.ManageAccounts.RegistrationAccountGUI;
import viewImpl.ManageAccounts.LoginAccountImplGUI;
import viewImpl.ManageAccounts.ManagementAccountImplGUI;
import viewImpl.ManageAccounts.RegistrationAccountImplGUI;

/**
 * Implements Account Controller.
 */
public class AccountsControllerImpl implements AccountsController {
    private AccountModel model;

    //implementes viewObserver
    private LoginAccountGUI loginView;
    private ManagementAccountGUI managementView;
    private RegistrationAccountGUI registrationView;
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

        loginView = new LoginAccountImplGUI();
        managementView = new ManagementAccountImplGUI();
        registrationView = new RegistrationAccountImplGUI();

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
