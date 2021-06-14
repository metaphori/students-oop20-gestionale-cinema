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

    public CinemaControllerImpl() {
        super();
        final AccountsController controller = new AccountsControllerImpl();
        controller.setCinemaController(this);
        controller.showLoginAccounView();
    }

    @Override
    public void showMenu() {
        menu = new MenuViewImpl();
        menu.setObserver(this);
        menu.show();
    }

    @Override
    public void showControllerAccount() {
        final AccountsController controller = new AccountsControllerImpl();
        controller.setCinemaController(this);
        controller.showManagementAccountView();
        
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

