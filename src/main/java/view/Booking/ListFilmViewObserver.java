
package view.booking;

import java.util.Set;

import utilities.Film;

public interface ListFilmViewObserver {
    void showMenu();
    Set<Film> getFilm();
    void selectedFilm(Film film);
    
}
