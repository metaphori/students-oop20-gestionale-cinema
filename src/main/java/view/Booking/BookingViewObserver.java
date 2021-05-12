package view.Booking;

import java.util.Set;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;

public interface BookingViewObserver {
    void showBackFromBooking(ProgrammedFilm film);
    Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
    void bookSeat();
    void buttonSelected(Seat<Row,Integer> seat, ProgrammedFilm film);
    void newBooking();
    Set<Seat<Row,Integer>> getSeatsSelected();
}
