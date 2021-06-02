package utilities.Factory;

import java.time.LocalTime;

import utilities.TimeSlot;

public interface TimeSlotFactory {
    TimeSlot createTimeSlot(LocalTime startTime, LocalTime endTime);

}
