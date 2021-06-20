package controllerImpl;

import controller.CinemaController;

import controller.CinemaControllerObserver;
import controller.ManageAccounts.AccountsController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controller.ManageStatistics.StatisticsController;
import controller.booking.BookingController;
import controllerImpl.ManageAccounts.AccountsControllerImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import controllerImpl.ManageStatistics.StatisticsControllerImpl;
import controllerImpl.booking.BookingControllerImpl;
import utilities.ManagerWorkingDIR;
import utilitiesImpl.ManagerWorkingDIRimpl;
import view.ManageMenu.MenuView;
import viewImpl.ManageMenu.MenuViewImpl;


public class CinemaControllerImpl implements CinemaController, CinemaControllerObserver {
    private final ManagerWorkingDIR manager;
    private final MenuView menu;
    private final AccountsController accountController;

    public CinemaControllerImpl() {
        super();
        manager = new ManagerWorkingDIRimpl();
        this.menu = new MenuViewImpl();
        this.menu.setObserver(this);
        this.initApplication(System.getProperty("user.home"));
        this.accountController = new AccountsControllerImpl();
        this.accountController.setCinemaController(this);
        this.accountController.showLoginAccounView();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showMenu() {
        menu.updateGUI(accountController.getAccountLogged());
        menu.show();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showControllerAccount() {
        accountController.showManagementAccountView();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showControllerTicket() {
        final BookingController controller = new BookingControllerImpl();
        controller.setCinemaController(this);
        controller.start();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showControllerFilm() {
        final FilmsController controller = new FilmsControllerImpl();
        controller.setCinemaController(this);
        controller.showContainerFilmsView();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showControllerProgrammingFilms() {
        final ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        controller.setCinemaController(this);
        controller.showProgrammedFilmView();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void showControllerStatistics() {
        final StatisticsController controller = new StatisticsControllerImpl();
       controller.setCinemaController(this);
       controller.showStatisticsView();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initApplication(final String path) {
        manager.initWorkingDir(path);
    }
}

