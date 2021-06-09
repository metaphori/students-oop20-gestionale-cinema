package view.ManageFilms;

import controller.ManageFilms.FilmsController;
import utilities.Film;

public interface InfoFilmsGUI {
    /**
        Show a view with film info.
     */
    void start();
    /**
        Set GUI films controller observer.
        @param observer observer to set.
     */
    void setObserver(FilmsController observer);
    /**
        Load film info.
        @param film film to load.
     */
    void loadFilm(Film film);
    /**
       Reset all fields in GUI.
     */
    void reset();
}
