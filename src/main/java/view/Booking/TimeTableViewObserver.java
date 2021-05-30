package view.Booking;

import java.util.Optional;

import utilities.Film;
import utilities.Factory.*;

public interface TimeTableViewObserver {
    void bookTicketForFilm(ProgrammedFilm film);
   void showBackFromTimeTable();
    Film getFilmByProgrammedFilm(ProgrammedFilm film);
   
}
