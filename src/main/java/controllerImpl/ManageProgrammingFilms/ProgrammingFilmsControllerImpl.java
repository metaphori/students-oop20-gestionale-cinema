package controllerImpl.ManageProgrammingFilms;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Factory.ProgrammedFilm;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import viewImpl.ManageProgrammingFilms.ProgrammingFilmsGUIimpl;
import viewImpl.ManageProgrammingFilms.ScheduleFilmGUIimpl;

public class ProgrammingFilmsControllerImpl implements ProgrammingFilmsController{
    
    final private ProgrammingFilmsGUI filmsProgrammationView;
    final private ScheduleFilmsGUI scheduleFilmView;
    final private ProgrammedFilmsModel programmedFilmsModel;
    
    
    public ProgrammingFilmsControllerImpl() {
        filmsProgrammationView = new ProgrammingFilmsGUIimpl(); 
        scheduleFilmView = new ScheduleFilmGUIimpl();
        programmedFilmsModel = new ProgrammedFilmsModelImpl();
        
        filmsProgrammationView.setObserver(this);
        scheduleFilmView.setObserver(this);
    }

    @Override
    public List<ProgrammedFilm> getAllProgrammedFilms() {
        return programmedFilmsModel.getAllProgrammedFilm();
    }

    @Override
    public void addProgrammedFilm(final ProgrammedFilm newProgrammedFilm) {
        programmedFilmsModel.addFilmProgrammation(newProgrammedFilm);   
    }

    @Override
    public void deleteProgrammedFilm(final ProgrammedFilm oldProgrammedFilm) {
        programmedFilmsModel.deleteFilmProgrammation(oldProgrammedFilm);
    }

    @Override
    public void showProgrammedFilmView() {
        filmsProgrammationView.update();
        filmsProgrammationView.start();
    }

    @Override
    public void showMenu() {
        
        
    }

    @Override
    public void showScheduleFilmView() {
        
        
    }

    @Override
    public ManagerProgrammingFilms getManagerProgrammingFilms() {
        return this.programmedFilmsModel.getManagerProgrammingFilms();
    }

}
