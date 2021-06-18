package controllerImpl.ManageFilms;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import com.google.gson.reflect.TypeToken;

import controller.CinemaController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controller.booking.BookingController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import controllerImpl.booking.BookingControllerImpl;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import utilities.Film;
import utilities.ManagerWorkingDIR;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.ManagerWorkingDIRimpl;
import view.ManageFilms.ContainerFilmsGUI;
import view.ManageFilms.InfoFilmsGUI;
import viewImpl.ManageFilms.ContainerFilmsGUIimpl;
import viewImpl.ManageFilms.InfoFilmsGUIimpl;

public final class FilmsControllerImpl implements FilmsController {

    private final ContainerFilmsModel model;
    private ContainerFilmsGUI viewFilms;
    private final InfoFilmsGUI infoFilms;
    private final ManagerWorkingDIR managerWorkingDIR;
    private ProgrammingFilmsController programmingFilmsController;
    private CinemaController cinemaController;


    public FilmsControllerImpl() { // must be invoked on the first use of application 

        Optional<Set<Film>> films = this.readFilmsFromFile();
        Optional<ManagerIdsFilms> managerIdsFilm = this.readManagerIdsFilmsFromFile();
        if (films.isEmpty() || managerIdsFilm.isEmpty()) {
            model = new ContainerFilmsModelImpl();
        } else {
            model =  new ContainerFilmsModelImpl(films.get(), managerIdsFilm.get());
        }

        viewFilms = new ContainerFilmsGUIimpl(); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();
        managerWorkingDIR = new ManagerWorkingDIRimpl();
        programmingFilmsController = new ProgrammingFilmsControllerImpl(this);

        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);
    }


  /*  public FilmsControllerImpl() { // must be invoked on the first use of application 

        final Optional<Set<Film>> films = this.readFilmsFromFile();
        final Optional<ManagerIdsFilms> managerIdsFilm = this.readManagerIdsFilmsFromFile();

        if (films.isEmpty() || managerIdsFilm.isEmpty()) {
            model = new ContainerFilmsModelImpl();
        } else {
            model =  new ContainerFilmsModelImpl(films.get(), managerIdsFilm.get());
        }

        viewFilms = new ContainerFilmsGUIimpl();
        infoFilms = new InfoFilmsGUIimpl();
        managerWorkingDIR = new ManagerWorkingDIRimpl();
        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);
    }
*/
  public FilmsControllerImpl(final ProgrammingFilmsController programmingFilmsController) { // must be invoked on the first use of application 

        final Optional<Set<Film>> films = this.readFilmsFromFile();
        final Optional<ManagerIdsFilms> managerIdsFilm = this.readManagerIdsFilmsFromFile();

        if (films.isEmpty() || managerIdsFilm.isEmpty()) {
            model = new ContainerFilmsModelImpl();
        } else {
            model = new ContainerFilmsModelImpl(films.get(), managerIdsFilm.get());
        }

        viewFilms = new ContainerFilmsGUIimpl(); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();
        managerWorkingDIR = new ManagerWorkingDIRimpl();
        this.programmingFilmsController = programmingFilmsController;
        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);
    } 
    @Override
    public void addFilm(final Film f) {
        this.model.addFilm(f);
        this.writeFilmsOnFile();
        this.writeManagerIdsFilmsOnFile();
    }

    @Override
    public void deleteFilm(final Film f) {
        final BookingController bookignController = new BookingControllerImpl();
        this.model.removeFilm(f);
        this.writeFilmsOnFile();
        this.writeManagerIdsFilmsOnFile();
        bookignController.deleteTicket(f);
    }

    @Override
    public Set<Film> getFilms() {
        return this.model.getFilms();
    }

    @Override
    public void showMenu() { 
        cinemaController.showMenu();
    }

    @Override
    public void showContainerFilmsView() {
        viewFilms.update();
        viewFilms.start();
    }

    @Override
    public void showInfoFilmView(final Film f) {
        infoFilms.start();
        infoFilms.loadFilm(f);
    }

    @Override
    public void showNewFilmView() {
        infoFilms.reset();
        infoFilms.start();
    }


    @Override
    public ManagerWorkingDIR getManagerWorkingDIR() {
        return this.managerWorkingDIR;
    }

    @Override
    public ManagerIdsFilms getManagerIdsFilms() {
        return model.getManagerIdsFilms();
    }

    private void writeFilmsOnFile() {
         final RWobject<Set<Film>> rw = new RWobjectImpl<>(GeneralSettings.FILMSPATH);
         final var type = new TypeToken<Set<Film>>() { }.getType();
         rw.writeObj(model.getFilms(), type);
    }

    private void writeManagerIdsFilmsOnFile() {
        final RWobject<ManagerIdsFilms> rw = new RWobjectImpl<>(GeneralSettings.MANAGERIDSFILMSPATH);
        final var type = new TypeToken<ManagerIdsFilms>() { }.getType();
        rw.writeObj(model.getManagerIdsFilms(), type);
    }
        private Optional<Set<Film>> readFilmsFromFile() {
        final RWobject<Set<Film>> rw = new RWobjectImpl<>(GeneralSettings.FILMSPATH);
        final var type = new TypeToken<Set<Film>>() { }.getType();
        return rw.readObj(type);
   }

    private Optional<ManagerIdsFilms> readManagerIdsFilmsFromFile() {
        final RWobject<ManagerIdsFilms> rw = new RWobjectImpl<>(GeneralSettings.MANAGERIDSFILMSPATH) ;
        final var type = new TypeToken<ManagerIdsFilms>() { }.getType();
        return rw.readObj(type);
    }


    @Override
    public void deleteFilmAndProgrammation(final Film f) {
        this.deleteFilm(f);
        this.programmingFilmsController.deleteAllFilmProgrammation(f);
    }

    @Override
    public void setProgrammingFilmsController(final ProgrammingFilmsController programmingFilmsController) {
        this.programmingFilmsController = programmingFilmsController;
    }


    @Override
    public void setCinemaController(final CinemaController cinemaController) {
        this.cinemaController = cinemaController;
    }

}
