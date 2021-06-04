package utilities.Factory;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ProgrammedFilm {
    int getIdProgrammation();
    int getHall();
    double getProgrammationPrice();
    LocalDate getDate();
    LocalTime getStartTime();
    LocalTime getEndTime();    
}
