package view.Booking;

import java.util.Set;

import utilities.Factory.*;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;

public interface BookingViewObserver {
    void showBackFromBooking(ProgrammedFilm film);
    Set<SeatImpl<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
    void bookSeat(ProgrammedFilm film);
    void buttonSelected(SeatImpl<Row,Integer> seat, ProgrammedFilm film);
    void newBooking();
    Set<SeatImpl<Row,Integer>> getSeatsSelected();
}