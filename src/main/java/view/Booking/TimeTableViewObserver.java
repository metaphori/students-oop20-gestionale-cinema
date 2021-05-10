package view.Booking;

import utilities.Film;
import utilities.ProgrammedFilm;

public interface TimeTableViewObserver {
    void bookTicketForFilm(ProgrammedFilm film);
   void showBackFromTimeTable();
    
}
