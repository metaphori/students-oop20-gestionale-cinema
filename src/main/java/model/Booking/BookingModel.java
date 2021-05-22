package model.Booking;

import java.util.Set;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import utilities.SeatState;
import utilities.Ticket;

public interface BookingModel {
    void addTicket(Ticket ticket);
    Set<Seat<Row,Integer>> getSeats();
    Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
    void buttonSelected(Seat<Row,Integer> seat, ProgrammedFilm film);
    void newBooking();
    Set<Seat<Row,Integer>> getSeatsSelected();
    void bookSeat();
}
