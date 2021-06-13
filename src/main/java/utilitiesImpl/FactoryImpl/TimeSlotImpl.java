package utilitiesImpl.FactoryImpl;

import java.time.LocalTime;

import utilities.TimeSlot;

public class TimeSlotImpl implements TimeSlot {
    
    private final LocalTime startTime;
    private final LocalTime endTime;
    
    
    TimeSlotImpl(final LocalTime startTime, final LocalTime endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public LocalTime getStartTime() {
        return startTime;
    }


    @Override
    public LocalTime getEndTime() {
        return endTime;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false; 
        }    
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeSlotImpl other = (TimeSlotImpl) obj;
        if (endTime == null) {
            if (other.endTime != null) {
                return false;
            }
        } else if (!endTime.equals(other.endTime)) {
            return false;
        }
        if (startTime == null) {
            if (other.startTime != null) {
                return false;
            }
        } else if (!startTime.equals(other.startTime)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "TimeSlotImpl [startTime=" + startTime + ", endTime=" + endTime + "]";
    }
    
    

}
