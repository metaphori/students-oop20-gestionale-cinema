package view;

import java.util.Set;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;

public interface BookingViewObserver {
    void showTableView(ProgrammedFilm film);
    Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film);
}
