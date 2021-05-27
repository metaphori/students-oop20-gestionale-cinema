package model.Booking;

import java.util.Set;

import utilities.Factory.*;
import utilities.Ticket;
import utilitiesImpl.Row;
import utilitiesImpl.Seat;
import utilitiesImpl.SeatState;

public interface BookingModel {
    void addTicket(Ticket ticket);
    Set<Seat<Row,Integer>> getSeats();
    Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
    void buttonSelected(Seat<Row,Integer> seat, ProgrammedFilm film);
    void newBooking();
    Set<Seat<Row,Integer>> getSeatsSelected();
    void bookSeat();
}
