package modelImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import model.ContainerFilmsModel;
import model.ManagerIdsFilms;
import utilities.Film;

public final class ContainerFilmsModelImpl implements ContainerFilmsModel {
    private final Collection<Film> container;
    private final ManagerIdsFilms manager; // verrà utilizzato dal controller per poter istanziare il film e passarlo con l'id disponibile richiesto al manager
    public ContainerFilmsModelImpl() {
        container = new HashSet<>();
        manager = new ManagerIdsFilmImpl(new ProgressiveIdsGeneratorImpl(Optional.ofNullable(null)), new HashSet<>());
    }
    public ContainerFilmsModelImpl(final Collection<Film> container, final ManagerIdsFilms manager) {
        this.container = container;
        this.manager = manager;
    }
    @Override
    public void addFilm(final Film newFilm) {
        this.container.add(newFilm);
    }
    @Override
    public void removeFilm(final Film oldFilm) {
       this.container.remove(oldFilm);
    }
    @Override
    public Collection<Film> getFilms() {
        return this.container;
    }
    @Override
    public ManagerIdsFilms getManagerIdsFilms() {
        return this.manager;
    }

}
