package model;
import java.util.Collection;

import utilities.Film;
public interface ContainerFilmsModel {
    void addFilm(Film newFilm);
    void removeFilm(Film oldFilm);
    Collection<Film> getFilms();
    ManagerIdsFilms getManagerIdsFilms();

}
