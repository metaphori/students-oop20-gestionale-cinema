package modelImpl;

import java.util.Collection;
import java.util.HashSet;

import model.ContainerFilmsModel;

import utilities.Film;

public class ContainerFilmsModelImpl implements ContainerFilmsModel {
    private final Collection<Film> container;
    private final ManagerIdsFilms manager;
    public ContainerFilmsModelImpl() {
        container = new HashSet<>();
        manager = new ManagerIdsFilmImpl(new ProgressiveIdsGenerator(null));
    }
    @Override
    public void addNewFilm(Film newFilm) {
       
        
    }

    @Override
    public void removeFilm(Film oldFilm) {
       
        
    }

}
