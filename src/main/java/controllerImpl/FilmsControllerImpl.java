package controllerImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import controller.FilmsController;
import model.ContainerFilmsModel;
import modelImpl.ContainerFilmsModelImpl;
import utilities.Film;
import utilities.FilmBasicImpl;
import view.ManageFilms.ContainerFilmsGUI;
import view.ManageFilms.InfoFilmsGUI;
import viewImpl.ManageFilms.ContainerFilmsGUIimpl;
import viewImpl.ManageFilms.InfoFilmsGUIimpl;

public class FilmsControllerImpl implements FilmsController {

    private final ContainerFilmsModel model;
    private final ContainerFilmsGUI viewFilms;
    private final InfoFilmsGUI infoFilms;

    public FilmsControllerImpl() { // must be invoked on the first use of application 
        model = new ContainerFilmsModelImpl();
        viewFilms = new ContainerFilmsGUIimpl(new HashSet<>()); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();

        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);

    }

    public FilmsControllerImpl(final Set<Film> set) { // IT'S A TEST !!!!!!!!!!!!!!!!!!
        model = new ContainerFilmsModelImpl();
        viewFilms = new ContainerFilmsGUIimpl(set); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();

        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);
    }
 
    @Override
    public void addFilm(final Film f) {
 
    }

    @Override
    public void deleteFilm(final FilmBasicImpl f) {
    }

    @Override
    public Collection<FilmBasicImpl> getFilms() {
        return null;
    }

    @Override
    public void showMenu() { //TODO 
        
    }

    @Override
    public void showContainerFilmsView() {
        viewFilms.start();

    }

    @Override
    public void showInfoFilmView(final Film f) {
        infoFilms.start();
        infoFilms.loadFilm(f);
    }

    @Override
    public void showNewFilmView() {
        infoFilms.start();
    }

    @Override
    public void loadFilm(final Collection<FilmBasicImpl> loadedFilms) {

    }

}
