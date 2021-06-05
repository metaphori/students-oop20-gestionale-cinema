package utilitiesImpl.FactoryImpl;

import java.time.LocalTime;

import utilities.TimeSlot;
import utilities.Factory.TimeSlotFactory;

public class TimeSlotFactoryImpl implements TimeSlotFactory {

    @Override
    public TimeSlot createTimeSlot(final LocalTime startTime, final LocalTime endTime) {
       return new TimeSlotImpl(startTime,endTime);
    }

}
