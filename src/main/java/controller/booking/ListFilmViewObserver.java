package controller.booking;

import java.util.Set;

import utilities.Film;
import utilities.Factory.*;

public interface ListFilmViewObserver {
    void showMenu();
    Set<Film> getFilm();
    void selectedFilm(Film film);
    
}
