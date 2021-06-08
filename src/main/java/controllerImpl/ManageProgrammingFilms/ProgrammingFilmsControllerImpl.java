package controllerImpl.ManageProgrammingFilms;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import exceptions.ProgrammationNotAvailableException;
import model.ManageFilms.ManagerIdsFilms;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Film;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.GeneralSettings;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import viewImpl.ManageProgrammingFilms.ProgrammingFilmsGUIimpl;
import viewImpl.ManageProgrammingFilms.ScheduleFilmGUIimpl;

public class ProgrammingFilmsControllerImpl implements ProgrammingFilmsController{
    
    final private ProgrammingFilmsGUI filmsProgrammationView;
    final private ScheduleFilmsGUI scheduleFilmView;
    final private ProgrammedFilmsModel programmedFilmsModel;
    final private FilmsController filmsController;
    
    
    public ProgrammingFilmsControllerImpl() {
        
        filmsController = new FilmsControllerImpl(this);
        final Optional<List<ProgrammedFilm>> programmedFilms = this.readProgrammedFilmsFromFile();

        if(programmedFilms.isEmpty()) {
            programmedFilmsModel = new ProgrammedFilmsModelImpl();
            
        }else {
            programmedFilmsModel = new ProgrammedFilmsModelImpl(programmedFilms.get());
        }
        
        filmsProgrammationView = new ProgrammingFilmsGUIimpl(); 
        filmsProgrammationView.setFilmsController(filmsController);
        filmsProgrammationView.setObserver(this);
        
        scheduleFilmView = new ScheduleFilmGUIimpl(filmsController);
        scheduleFilmView.setObserver(this);
    }
    
    
    public ProgrammingFilmsControllerImpl(final FilmsController filmsController) {
        
        this.filmsController = filmsController;
        final Optional<List<ProgrammedFilm>> programmedFilms = this.readProgrammedFilmsFromFile();

        if(programmedFilms.isEmpty()) {
            programmedFilmsModel = new ProgrammedFilmsModelImpl();
            
        }else {
            programmedFilmsModel = new ProgrammedFilmsModelImpl(programmedFilms.get());
        }
        
        filmsProgrammationView = new ProgrammingFilmsGUIimpl(); 
        filmsProgrammationView.setFilmsController(filmsController);
        filmsProgrammationView.setObserver(this);
        
        scheduleFilmView = new ScheduleFilmGUIimpl(filmsController);
        scheduleFilmView.setObserver(this);
    }
    

    @Override
    public List<ProgrammedFilm> getAllProgrammedFilms() {
        return programmedFilmsModel.getAllProgrammedFilm();
    }

    @Override
    public void addProgrammedFilm(final ProgrammedFilm newProgrammedFilm) throws ProgrammationNotAvailableException{
        programmedFilmsModel.addFilmProgrammation(newProgrammedFilm);   
        this.writeProgrammedFilmsOnFile();
    }

    @Override
    public void deleteProgrammedFilm(final ProgrammedFilm oldProgrammedFilm) {
        programmedFilmsModel.deleteFilmProgrammation(oldProgrammedFilm);
        this.writeProgrammedFilmsOnFile();
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
        scheduleFilmView.start();
    }

    @Override
    public ManagerProgrammingFilms getManagerProgrammingFilms() {
        return this.programmedFilmsModel.getManagerProgrammingFilms();
    }


    @Override
    public FilmsController getFilmsController() {
        return this.filmsController;
    }
    
    private void writeProgrammedFilmsOnFile() {
        final RWobject<List<ProgrammedFilm>> rw = new RWobjectImpl<>(GeneralSettings.PROGRAMMEDFILMSPATH);
        final var type = new TypeToken<List<ProgrammedFilm>>() {}.getType();
        rw.writeObj(programmedFilmsModel.getAllProgrammedFilm(), type);
    }
    
    private Optional<List<ProgrammedFilm>> readProgrammedFilmsFromFile() {
        final RWobject<List<ProgrammedFilm>> rw = new RWobjectImpl<>(GeneralSettings.PROGRAMMEDFILMSPATH);
        final var type = new TypeToken<List<ProgrammedFilm>>() {}.getType();
        return rw.readObj(type);
    }


    @Override
    public void deleteAllFilmProgrammation(final Film film) {
        this.programmedFilmsModel.deleteAllFilmProgrammation(film);
        this.writeProgrammedFilmsOnFile();
        
    }


    @Override
    public void updateGUI() {
        filmsProgrammationView.update();
    }

}
