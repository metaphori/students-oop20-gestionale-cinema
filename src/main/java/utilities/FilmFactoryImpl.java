package utilities;

import java.util.Optional;

public class FilmFactoryImpl implements FilmFactory {

    @Override
    public Film createBasicFilm(final String name, final String genre, final String description, final Optional<String> coverPath, final int duration, final int id) {
        return new FilmBasicImpl(name, genre, description, coverPath, duration,id);
    }
 
}
