package model;

import java.util.Set;

import utilities.Row;
import utilities.Seat;
import utilities.Ticket;

public interface BookingModel {
    void addTicket(Ticket ticket);
    Set<Seat<Row,Integer>> getSeat();
}
