package utilities;

import java.util.Optional;

public interface Film {
    int getID();
    String getName();
    String getGenre();
    int getDuration();
    Optional<String> getCoverPath(); // returns an optional coverFilmPath
    String getDescription(); 
}
