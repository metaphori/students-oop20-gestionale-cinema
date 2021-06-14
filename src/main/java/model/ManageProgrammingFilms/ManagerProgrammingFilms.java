package model.ManageProgrammingFilms;

import java.time.LocalDate;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;

/** 
 * Describe a manager for programming films.
 * */
public interface ManagerProgrammingFilms {
    /** 
     * Check if a specific timeslot, date and hall are available.
     * @param timeSlotToCheck time slot to check
     * @param date date to check
     * @param hall hall to check
     * @return boolean 
     * */
    boolean isAvailableProgrammation(TimeSlot timeSlotToCheck, LocalDate date, int hall);
    /** 
     * Get used handler list.
     * @return HandlerList<ProgrammedFilm> 
     * */
    HandlerList<ProgrammedFilm> getHandlerList();
}
