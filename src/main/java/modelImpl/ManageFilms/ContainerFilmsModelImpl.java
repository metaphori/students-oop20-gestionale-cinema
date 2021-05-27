package modelImpl.ManageFilms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.ManagerIdsFilms;
import utilities.Film;

public final class ContainerFilmsModelImpl implements ContainerFilmsModel {
    protected String type = getClass().getName();
    private final Set<Film> containerFilms;
    private final ManagerIdsFilms manager; // verrà utilizzato dal controller per poter istanziare il film e passarlo con l'id disponibile richiesto al manager

    // must be invoked on the first use of application because no date must be load
    public ContainerFilmsModelImpl() { 
        containerFilms = new HashSet<>();
        manager = new ManagerIdsFilmImpl(new IdsGeneratorImpl(Optional.ofNullable(null)), new HashSet<>());
    }
    // always must be invoked apart on  the first use (in case of Container cant't be written on file)
    public ContainerFilmsModelImpl(final Set<Film> container, final ManagerIdsFilms manager) {
        this.containerFilms = container;
        this.manager = manager;
    }


    @Override
    public void addFilm(final Film newFilm) {
        this.containerFilms.add(newFilm);
    }
    @Override
    public void removeFilm(final Film oldFilm) {
       this.containerFilms.remove(oldFilm);
    }
    @Override
    public Set<Film> getFilms() {
        return this.containerFilms;
    }
    @Override
    public ManagerIdsFilms getManagerIdsFilms() {
        return this.manager;
    }
    @Override
    public String toString() {
        return "" + containerFilms + "" + manager;
    }

}
