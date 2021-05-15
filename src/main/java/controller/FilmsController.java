package controller;

import java.util.Collection;

import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.ManagerWorkingDIR;

public interface FilmsController {
        void addFilm(Film f);
        void deleteFilm(FilmBasicImpl f);
        Collection<FilmBasicImpl> getFilms(); //recupera i film da file
        void loadFilm(Collection<FilmBasicImpl> loadedFilms); //Carica i film sul model

        void showMenu();
        void showContainerFilmsView();
        void showInfoFilmView(Film f);
        void showNewFilmView();
        
        ManagerWorkingDIR getManagerWorkingDIR();

}
