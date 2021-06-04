package view.ManageFilms;

import controller.ManageFilms.FilmsController;
import utilities.Film;

public interface InfoFilmsGUI {
    void start();
    void setObserver(FilmsController observer);
    void loadFilm(Film film);
    void reset();
}
