package model.Booking;

import java.util.Set;

import utilities.Factory.*;
import utilities.Film;
import utilities.Ticket;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.SeatState;

public interface BookingModel {
 
    Set<Ticket> getSeats();
    Set<SeatImpl> getSeatsFromFilm(ProgrammedFilm programmedFilm);
    void buttonSelected(SeatImpl seat, ProgrammedFilm programmedFilm);
    void newBooking();
    Set<SeatImpl> getSeatsSelected();
    void bookSeat(ProgrammedFilm programmedFilm);
    void deleteTicket(Film film);
    void deleteTicket(ProgrammedFilm programmedFilm);
}
