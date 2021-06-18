package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import utilitiesImpl.Hall;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;

public interface Ticket {
    LocalTime getTime();
    LocalDate getDate();
    Set<Seat> getSetSeat();
    double getPrice();
    int getId();
    Hall getHall();
}
