package utilities.Factory;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Describe a factory to create a programmed film.
 * */
public interface ProgrammedFilmFactory {
    ProgrammedFilm createProgrammedFilm(int idFilm, int hall, double price, LocalDate date, LocalTime startTime, LocalTime endTime);
}
