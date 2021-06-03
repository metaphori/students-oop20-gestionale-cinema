package controller.ManageFilms;


import java.util.Set;

import model.ManageFilms.ManagerIdsFilms;
import utilities.Film;
import utilities.ManagerWorkingDIR;

public interface FilmsController {
        void addFilm(Film f);
        void deleteFilm(Film f);
        Set<Film> getFilms(); //recupera i film da file
        void loadFilm(Set<Film> loadedFilms); //Carica i film sul model

        void showMenu();
        void showContainerFilmsView();
        void showInfoFilmView(Film f);
        void showNewFilmView();

        ManagerWorkingDIR getManagerWorkingDIR();
        ManagerIdsFilms getManagerIdsFilms();

}
