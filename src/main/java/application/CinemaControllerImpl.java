package application;

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
        manager = new ManagerWorkingDIRimpl();
        this.initController();
        //manager.initWorkingDir();
        
    }

    @Override
    public void initController() {
        
        filmsController = new FilmsControllerImpl();
        programmingFilmsController = new ProgrammingFilmsControllerImpl();
        filmsController.setProgrammingFilmsController(programmingFilmsController);
        programmingFilmsController.setFilmsController(filmsController);
        
        //filmsController.showContainerFilmsView();
        programmingFilmsController.showProgrammedFilmView();
    }

}
