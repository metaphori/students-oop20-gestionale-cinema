package utilities.Factory;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ProgrammedFilmFactory {
    ProgrammedFilm createProgrammedFilm(int idFilm, int hall, double price, LocalDate date, LocalTime startTime, LocalTime endTime);
    
}
