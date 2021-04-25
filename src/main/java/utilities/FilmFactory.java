package utilities;

import java.util.Optional;

public interface FilmFactory {
    Film createBasicFilm(String name, String genre, String description, Optional<String> coverPath, int duration, int id);    
}    