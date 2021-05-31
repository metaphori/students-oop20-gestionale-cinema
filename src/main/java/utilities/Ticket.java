package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;

public interface Ticket {
    LocalTime getTime();
    LocalDate getData();
    Set<SeatImpl<Row, Integer>> getSetSeat();
    double getPrice();
    int getId();
    int getHall();
}
