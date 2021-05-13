package controllerImpl;

import java.util.Collection;
import java.util.HashSet;

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
        this.viewFilms.start();
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
    public void loadFilm(final Collection<FilmBasicImpl> loadedFilms) {

    }

    @Override
    public void showManageFilmsView() {

    }

    @Override
    public void showMenu() {
    }

}
