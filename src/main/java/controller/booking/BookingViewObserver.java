package controller.booking;

import java.util.Set;

import utilities.Seat;
import utilities.Factory.*;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;

public interface BookingViewObserver {
    
    void showBackFromBooking(ProgrammedFilm film);
    Set<Seat> getSeatsFromProgrammedFilm(ProgrammedFilm film);
    void bookSeat(ProgrammedFilm film);
    void buttonSelected(SeatImpl seat, ProgrammedFilm film);
    void newBooking();
    Set<Seat> getSeatsSelected();
}