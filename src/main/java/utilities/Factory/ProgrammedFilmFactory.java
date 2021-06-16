package utilities.Factory;

import java.time.LocalDate;
import java.time.LocalTime;

import utilitiesImpl.Hall;
/**
 * Describe a factory to create a programmed film.
 * */
public interface ProgrammedFilmFactory {
    ProgrammedFilm createProgrammedFilm(int idFilm, Hall hall, double price, LocalDate date, LocalTime startTime, LocalTime endTime);
}
