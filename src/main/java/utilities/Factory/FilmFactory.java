package utilities.Factory;

import java.util.Optional;

import utilities.Film;

public interface FilmFactory {
    Film createBasicFilm(String name, String genre, String description, Optional<String> coverPath, int duration);
    Film createBasicFilmById(String name, String genre, String description, Optional<String> coverPath, int duration, int id);
    }