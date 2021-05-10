package view.Booking;

import java.util.Set;

import utilities.Film;
import utilities.ProgrammedFilm;

public interface ListFilmViewObserver {
    void showMenu();
    Set<Film> getFilm();
    void selectedFilm(Film film);
}
