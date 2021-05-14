package view.ManageFilms;

import controller.FilmsController;
import utilities.Film;

public interface InfoFilmsGUI {
    void start();
    void setObserver(FilmsController observer);
    void loadFilm(Film film);
}
