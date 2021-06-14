package utilities.Factory;

import java.time.LocalTime;

import utilities.TimeSlot;
/** 
 * Factory to create time slot with start-end time.
 */
public interface TimeSlotFactory {
    /**
     * Create a time slot.
     * @param startTime, start time
     * @param endTime, end time
     *  */
    TimeSlot createTimeSlot(LocalTime startTime, LocalTime endTime);

}
