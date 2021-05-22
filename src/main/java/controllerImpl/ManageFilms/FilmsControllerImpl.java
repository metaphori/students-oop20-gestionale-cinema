package controllerImpl.ManageFilms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.SwingUtilities;

import controller.FilmsController;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.ManagerWorkingDIR;
import utilitiesImpl.FilmBasicImpl;
import utilitiesImpl.ManagerWorkingDIRimpl;
import view.ManageFilms.ContainerFilmsGUI;
import view.ManageFilms.InfoFilmsGUI;
import viewImpl.ManageFilms.ContainerFilmsGUIimpl;
import viewImpl.ManageFilms.InfoFilmsGUIimpl;

public class FilmsControllerImpl implements FilmsController {

    private final ContainerFilmsModel model;
    private ContainerFilmsGUI viewFilms;
    private final InfoFilmsGUI infoFilms;
    private final ManagerWorkingDIR managerWorkingDIR;

    public FilmsControllerImpl() { // must be invoked on the first use of application 
        model = new ContainerFilmsModelImpl();
        viewFilms = new ContainerFilmsGUIimpl(new HashSet<>()); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();
        managerWorkingDIR = new ManagerWorkingDIRimpl();

        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);

    }

    public FilmsControllerImpl(final Set<Film> set, final ManagerIdsFilms managerIdsFilm) { // IT'S A TEST !!!!!!!!!!!!!!!!!!
        model = new ContainerFilmsModelImpl(set, managerIdsFilm);
        viewFilms = new ContainerFilmsGUIimpl(this.model.getFilms()); // Empty set, there aren't films
        infoFilms = new InfoFilmsGUIimpl();
        managerWorkingDIR = new ManagerWorkingDIRimpl();

        this.viewFilms.setObserver(this);
        this.infoFilms.setObserver(this);
    }

 
    @Override
    public void addFilm(final Film f) {
        this.model.addFilm(f);
        System.out.println("Add new film:"+ f);
    }

    @Override
    public void deleteFilm(final Film f) {
        this.model.removeFilm(f);
        System.out.println("Delete film:"+ f);
    }

    @Override
    public Set<Film> getFilms() {
        return this.model.getFilms();
    }

    @Override
    public void showMenu() { //TODO 
        
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
        System.out.println("Load specific film"+ f);
    }

    @Override
    public void showNewFilmView() {
        infoFilms.reset();
        infoFilms.start();
    }

    @Override
    public void loadFilm(final Set<Film> loadedFilms) {

    }

    @Override
    public ManagerWorkingDIR getManagerWorkingDIR() {
        return this.managerWorkingDIR;
    }

    @Override
    public ManagerIdsFilms getManagerIdsFilms() {
        return model.getManagerIdsFilms();
    }

}
