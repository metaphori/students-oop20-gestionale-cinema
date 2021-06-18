package controllerImpl.ManageProgrammingFilms;

import java.util.List;
import java.util.Optional;

import com.google.gson.reflect.TypeToken;

import controller.CinemaController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controller.booking.BookingController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.booking.BookingControllerImpl;
import exceptions.ProgrammationNotAvailableException;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Film;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.GeneralSettings;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import viewImpl.ManageProgrammingFilms.ProgrammingFilmsGUIimpl;
import viewImpl.ManageProgrammingFilms.ScheduleFilmGUIimpl;
/**
 * This controller manages films programmation.
 *  */
public final class ProgrammingFilmsControllerImpl implements ProgrammingFilmsController {

    private final ProgrammingFilmsGUI filmsProgrammationView;
    private ScheduleFilmsGUI scheduleFilmView;
    private final ProgrammedFilmsModel programmedFilmsModel;
    private FilmsController filmsController;
    private CinemaController cinemaController;

    public ProgrammingFilmsControllerImpl() {
        filmsController = new FilmsControllerImpl(this);
        final Optional<List<ProgrammedFilm>> programmedFilms = this.readProgrammedFilmsFromFile();

        if (programmedFilms.isEmpty()) {
            programmedFilmsModel = new ProgrammedFilmsModelImpl();
        } else {
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

        if (programmedFilms.isEmpty()) {
            programmedFilmsModel = new ProgrammedFilmsModelImpl();
        } else {
            programmedFilmsModel = new ProgrammedFilmsModelImpl(programmedFilms.get());
        }
        filmsProgrammationView = new ProgrammingFilmsGUIimpl(); 
        filmsProgrammationView.setFilmsController(filmsController);
        filmsProgrammationView.setObserver(this);
        scheduleFilmView = new ScheduleFilmGUIimpl(filmsController);
        scheduleFilmView.setObserver(this);
    }

    /** 
     * {@inheritDoc}
     * */
    @Override
    public List<ProgrammedFilm> getAllProgrammedFilms() {
        return programmedFilmsModel.getAllProgrammedFilm();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void addProgrammedFilm(final ProgrammedFilm newProgrammedFilm) throws ProgrammationNotAvailableException {
        programmedFilmsModel.addFilmProgrammation(newProgrammedFilm);
        this.writeProgrammedFilmsOnFile();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void deleteProgrammedFilm(final ProgrammedFilm oldProgrammedFilm) {
        final BookingController bookingController = new BookingControllerImpl();
        programmedFilmsModel.deleteFilmProgrammation(oldProgrammedFilm);
        this.writeProgrammedFilmsOnFile();
        bookingController.deleteTicket(oldProgrammedFilm);
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void showProgrammedFilmView() {
        filmsProgrammationView.update();
        filmsProgrammationView.start();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void showMenu() {
        cinemaController.showMenu();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void showScheduleFilmView() {
        scheduleFilmView.start();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public ManagerProgrammingFilms getManagerProgrammingFilms() {
        return this.programmedFilmsModel.getManagerProgrammingFilms();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public FilmsController getFilmsController() {
        return this.filmsController;
    }

    /**
     * Write all programmed films on file where there are some changes.
     */
    private void writeProgrammedFilmsOnFile() {
        final RWobject<List<ProgrammedFilm>> rw = new RWobjectImpl<>(GeneralSettings.PROGRAMMEDFILMSPATH);
        final var type = new TypeToken<List<ProgrammedFilm>>() { }.getType();
        rw.writeObj(programmedFilmsModel.getAllProgrammedFilm(), type);
    }
    /**
     * Read, if there's data, all programmed films from file. Otherwise return an empty optional.
     * @return list of programmed films
     */
    private Optional<List<ProgrammedFilm>> readProgrammedFilmsFromFile() {
        final RWobject<List<ProgrammedFilm>> rw = new RWobjectImpl<>(GeneralSettings.PROGRAMMEDFILMSPATH);
        final var type = new TypeToken<List<ProgrammedFilm>>() { }.getType();
        return rw.readObj(type);
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void deleteAllFilmProgrammation(final Film film) {
        this.programmedFilmsModel.deleteAllFilmProgrammation(film);
        this.writeProgrammedFilmsOnFile();
    }

    /** 
     * {@inheritDoc}
     * */
    @Override
    public void updateGUI() {
        filmsProgrammationView.update();
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void setFilmsController(final FilmsController filmsController) {
        this.filmsController = filmsController;
        filmsProgrammationView.setFilmsController(filmsController);
        this.initScheduleGUI();
    }
    /** 
     * Complete initialization of programming films controller. It creates a new schedule film view and sets itself as observer of this gui.
     * */
    private void initScheduleGUI() {
        scheduleFilmView = new ScheduleFilmGUIimpl(this.filmsController);
        scheduleFilmView.setObserver(this);
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public void setCinemaController(final CinemaController cinemaController) {
        this.cinemaController = cinemaController;
    }


}
