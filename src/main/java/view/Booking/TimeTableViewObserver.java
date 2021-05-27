package view.Booking;

import utilities.Film;
import utilities.Factory.*;

public interface TimeTableViewObserver {
    void bookTicketForFilm(ProgrammedFilm film);
   void showBackFromTimeTable();
    
}
