package model.Booking;

import java.util.Set;
import utilities.Film;
import utilities.Seat;
import utilities.Ticket;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.SeatImpl;


public interface BookingModel {
 
    Set<Ticket> getSeats();
    Set<Seat> getSeatsFromProgrammedFilm(ProgrammedFilm programmedFilm);
    void buttonSelected(Seat seat, ProgrammedFilm programmedFilm);
    void newBooking();
    Set<Seat> getSeatsSelected();
    void bookSeat(ProgrammedFilm programmedFilm);
    void deleteTicket(Film film);
    void deleteTicket(ProgrammedFilm programmedFilm);
}
