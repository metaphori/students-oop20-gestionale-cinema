package controllerImpl.ManageProgrammingFilms;

import java.time.LocalDate;
import java.util.Collection;

import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Factory.ProgrammedFilm;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import viewImpl.ManageProgrammingFilms.ProgrammingFilmsGUIimpl;
import viewImpl.ManageProgrammingFilms.ScheduleFilmGUIimpl;

public class ProgrammingFilmsControllerImpl implements ProgrammingFilmsController{
    
    final private ProgrammingFilmsGUI filmsProgrammation;
    final private ScheduleFilmsGUI scheduleFilm;
    final private ProgrammedFilmsModel programmedFilmsModel;
    
    
    public ProgrammingFilmsControllerImpl() {
        filmsProgrammation = new ProgrammingFilmsGUIimpl(); 
        scheduleFilm = new ScheduleFilmGUIimpl();
        programmedFilmsModel = new ProgrammedFilmsModelImpl();
        
        filmsProgrammation.setObserver(this);
       // scheduleFilm.setObserver(this);
    }

    @Override
    public Collection<ProgrammedFilm> getAllProgrammationFilms() {
        return null;
    }

    @Override
    public void addProgrammedFilm(final ProgrammedFilm newProgrammedFilm) {
        
    }

    @Override
    public void deleteProgrammedFilm(final ProgrammedFilm oldProgrammedFilm) {
        
    }

    @Override
    public void getProgrammedFilmsBySelection(String film, LocalDate date) {
        
        
    }

    @Override
    public void showProgrammedFilmView() {
        
        
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void showScheduleFilmView() {
        
        
    }

}
