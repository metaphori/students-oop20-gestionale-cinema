package controller.booking;


import java.util.Set;
import utilities.Seat;
import utilities.Factory.*;
import utilitiesImpl.SeatImpl;

public interface BookingViewObserver {
    /**
<<<<<<< HEAD
     * Method that show back frame from 
=======
     * Show back frame from BookingView 
>>>>>>> master
     * @param film
     */
    void showBackFromBooking(ProgrammedFilm film);
    Set<Seat> getSeatsFromProgrammedFilm(ProgrammedFilm film);
    void bookSeat(ProgrammedFilm film);
    void buttonSelected(SeatImpl seat, ProgrammedFilm film);
    void newBooking();
    Set<Seat> getSeatsSelected();
}