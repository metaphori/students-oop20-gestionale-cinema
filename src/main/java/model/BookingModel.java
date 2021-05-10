package model;

import java.util.Set;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import utilities.Ticket;

public interface BookingModel {
    void addTicket(Ticket ticket);
    Set<Seat<Row,Integer>> getSeats();
    Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
}
