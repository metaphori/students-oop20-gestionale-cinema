package controllerImpl;

import controller.CinemaController;

import controller.CinemaControllerObserver;
import controller.Booking.BookingController;
import controller.ManageAccounts.AccountsController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controller.ManageStatistics.StatisticsController;
import controllerImpl.Booking.BookingControllerImpl;
import controllerImpl.ManageAccounts.AccountsControllerImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import controllerImpl.ManageStatistics.StatisticsControllerImpl;

import utilities.ManagerWorkingDIR;
import utilitiesImpl.ManagerWorkingDIRimpl;
import view.ManageMenu.MenuView;
import viewImpl.ManageMenu.MenuViewImpl;


public class CinemaControllerImpl implements CinemaController, CinemaControllerObserver{
    private ManagerWorkingDIR manager;
    private MenuView menu;
    private AccountsController accountController;
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

    @Override
    public void showMenu() {
        menu.updateGUI(accountController.getAccountLogged());
        menu.show();
    }

    @Override
    public void showControllerAccount() {
        accountController.showManagementAccountView();
    }

    @Override
    public void showControllerTicket() {
        final BookingController controller = new BookingControllerImpl();
        controller.setCinemaController(this);
        controller.start();
    }

    @Override
    public void showControllerFilm() {
        final FilmsController controller = new FilmsControllerImpl();
        controller.setCinemaController(this);
        controller.showContainerFilmsView();
        
    }

    @Override
    public void showControllerProgrammingFilms() {
        final ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        controller.setCinemaController(this);
        controller.showProgrammedFilmView();
        
    }

    @Override
    public void showControllerStatistics() {
        final StatisticsController controller = new StatisticsControllerImpl();
       controller.setCinemaController(this);
       controller.showStatisticsView();
    }
    @Override
    public void initApplication(String path) {
        manager.initWorkingDir(path);
    }



}

