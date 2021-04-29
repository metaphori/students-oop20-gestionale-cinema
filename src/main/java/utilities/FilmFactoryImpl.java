package utilities;

import java.util.Optional;

import model.ContainerFilmsModel;
import modelImpl.ContainerFilmsModelImpl;

public class FilmFactoryImpl implements FilmFactory {
    ContainerFilmsModel containerFilms;
    public FilmFactoryImpl (ContainerFilmsModel containerFilms){
        this.containerFilms = containerFilms;
    }
    @Override
    public Film createBasicFilm(String name, String genre, String description, Optional<String> coverPath, int duration) {
        return new FilmBasicImpl(description, description, description, coverPath, duration, containerFilms.getManagerIdsFilms().getNewFilmID());
    }
    
    
 
}
