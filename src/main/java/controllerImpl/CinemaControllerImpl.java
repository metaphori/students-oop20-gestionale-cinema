package controllerImpl;

import controller.CinemaController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import utilities.ManagerWorkingDIR;
import utilitiesImpl.ManagerWorkingDIRimpl;

public class CinemaControllerImpl implements CinemaController{
    private ManagerWorkingDIR manager;
    private FilmsController filmsController; 
    ProgrammingFilmsController programmingFilmsController;
    //MenuView menu;

    @Override
    public void showMenu() {
        //menu.start();
    }

    public CinemaControllerImpl() {
        super();
       //filmsController = new FilmsControllerImpl();
      // filmsController.showContainerFilmsView();
        //manager.initWorkingDir();
        programmingFilmsController = new ProgrammingFilmsControllerImpl();
        programmingFilmsController.showProgrammedFilmView();
        
    }



}
