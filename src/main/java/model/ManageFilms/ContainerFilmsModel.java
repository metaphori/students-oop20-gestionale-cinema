package model.ManageFilms;
import java.util.Set;

import utilities.Film;
public interface ContainerFilmsModel {
    void addFilm(Film newFilm);
    void removeFilm(Film oldFilm);
    Set<Film> getFilms();
    ManagerIdsFilms getManagerIdsFilms();

}
