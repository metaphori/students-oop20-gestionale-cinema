package utilitiesImpl.FactoryImpl;

import java.util.Optional;

import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import utilities.Film;
import utilities.Factory.FilmFactory;
import utilitiesImpl.FilmBasicImpl;

public class FilmFactoryImpl implements FilmFactory {

    private final ManagerIdsFilms managerIds;

    public FilmFactoryImpl(final ManagerIdsFilms managerIds) {
        this.managerIds = managerIds;
    }

    @Override
    public Film createBasicFilm(final String name, final String genre, final  String description, final Optional<String> coverPath, final  int duration) {
        return new FilmBasicImpl(name, genre, description, coverPath, duration, managerIds.getNewFilmID());
    }

    @Override
    public Film createBasicFilmById(final String name, final String genre, final String description, final Optional<String> coverPath,
            final int duration, final int id) {
        return new FilmBasicImpl(name, genre, description, coverPath, duration, id);
    }


 
}
