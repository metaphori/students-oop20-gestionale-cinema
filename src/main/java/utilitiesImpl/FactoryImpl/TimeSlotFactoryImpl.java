package utilitiesImpl.FactoryImpl;

import java.time.LocalTime;

import utilities.TimeSlot;
import utilities.Factory.TimeSlotFactory;
/** 
 * Factory to create time slot.
 * */
public final class TimeSlotFactoryImpl implements TimeSlotFactory {
    /**
     * Create a time slot.
     * @param startTime, start time
     * @param endTime, end time
     *  */
    @Override
    public TimeSlot createTimeSlot(final LocalTime startTime, final LocalTime endTime) {
       return new TimeSlotImpl(startTime, endTime);
    }

}
