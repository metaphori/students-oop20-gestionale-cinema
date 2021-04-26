package view;

import java.util.Set;

import utilities.ProgrammedFilm;

public interface ListFilmViewObserver {
    void showMenu();
    Set<ProgrammedFilm> getFilmProgrammed();
    void selectedFilm(ProgrammedFilm film);
}
