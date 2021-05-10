package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface Ticket {
    LocalTime getTime();
    LocalDate getData();
    Set<Seat<Row, Integer>> getSetSeat();
    double getPrice();
    int getId();
    String getHall();
}
