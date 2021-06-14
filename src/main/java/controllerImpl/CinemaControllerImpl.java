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
    private FilmsController filmsController; 
    ProgrammingFilmsController programmingFilmsController;
    private MenuView menu;

    public CinemaControllerImpl() {
        super();
        menu = new MenuViewImpl();
        menu.setObserver(this);
       //filmsController = new FilmsControllerImpl();
      // filmsController.showContainerFilmsView();
        //manager.initWorkingDir();
        //programmingFilmsController = new ProgrammingFilmsControllerImpl();
       // programmingFilmsController.showProgrammedFilmView();
        
    }

    @Override
    public void showMenu() {
        menu.show();
    }

    @Override
    public void showControllerAccount() {
        final AccountsController controller = new AccountsControllerImpl();
        controller.showManagementAccountView();
        
    }

    @Override
    public void showControllerTicket() {
        final BookingController controller = new BookingControllerImpl();
        controller.start();
    }

    @Override
    public void showControllerFilm() {
        final FilmsController controller = new FilmsControllerImpl();
        controller.showContainerFilmsView();
        
    }

    @Override
    public void showControllerProgrammingFilms() {
        final ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        controller.showProgrammedFilmView();
        
    }

    @Override
    public void showControllerStatistics() {
        final StatisticsController controller = new StatisticsControllerImpl();
      //  controller.
    }
    @Override
    public void initApplication(String path) {
        manager.initWorkingDir(path);
        
    }



}

