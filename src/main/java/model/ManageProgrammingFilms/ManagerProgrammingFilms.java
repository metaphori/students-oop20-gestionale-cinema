package model.ManageProgrammingFilms;

import java.time.LocalDate;
import java.util.List;

import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;

public interface ManagerProgrammingFilms {
    boolean isAvailableProgrammation(TimeSlot timeSlotToCheck, LocalDate date, int hall);
    List<ProgrammedFilm> filterListByDateHall(LocalDate date , int hall);
}
