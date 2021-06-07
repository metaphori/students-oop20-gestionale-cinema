package model.Booking;

import java.util.Set;

import utilities.Factory.*;
import utilities.Ticket;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.SeatState;

public interface BookingModel {
 
    Set<Ticket> getSeats();
    Set<SeatImpl<Row, Integer>> getSeatsFromFilm(ProgrammedFilm film);
    void buttonSelected(SeatImpl<Row, Integer> seat, ProgrammedFilm film);
    void newBooking();
    Set<SeatImpl<Row, Integer>> getSeatsSelected();
    void bookSeat(ProgrammedFilm film);
}
