package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.TimeSlotFactory;
import utilitiesImpl.FactoryImpl.TimeSlotFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;

public class ManagerProgrammingFilmsImpl implements ManagerProgrammingFilms{
    private final  List<ProgrammedFilm> listToManage;
    private final  HandlerList<ProgrammedFilm> handlerList;   
    
 public ManagerProgrammingFilmsImpl(List<ProgrammedFilm> listToManage) {
        this.listToManage = listToManage;
        this.handlerList = new HandlerListImpl<>();
    }

@Override
 public boolean isAvailableProgrammation(final TimeSlot timeSlotToCheck, final LocalDate date, final int hall) { // check if timeslot is available for specific date and hall 
        TimeSlotFactory timeSlotFactory= new TimeSlotFactoryImpl();
        //return !this.filterListByDateHall(date, hall)
        
        /*return !this.handlerList.filterListByDateHall(listToManage, date, hall)
        .stream()
        .anyMatch(pf -> {
           if( this.isAvailableTimeSlot(timeSlotFactory.createTimeSlot(pf.getStartTime(), pf.getEndTime()), timeSlotToCheck)) { // if it's available it means that there isn't any match , so return false
               return false;
           } 
           return true;
        }
        );   */
        return !this.handlerList.filterBy(listToManage, new FilterByDateHallImpl(date,hall))
                .stream()
                .anyMatch(pf -> {
                   if( this.isAvailableTimeSlot(timeSlotFactory.createTimeSlot(pf.getStartTime(), pf.getEndTime()), timeSlotToCheck)) { // if it's available it means that there isn't any match , so return false
                       return false;
                   } 
                   return true;
                }
        ); 
    }
       
 private  boolean isAvailableTimeSlot(final TimeSlot inserted , final TimeSlot toCheck) { // check if specifif time slot is available compare to another time slot
        
        final LocalTime insertedStartTime = inserted.getStartTime();
        final LocalTime insertedEndTime = inserted.getEndTime();
        
        final LocalTime toCheckStartTime = toCheck.getStartTime();
        final LocalTime toCheckEndTime = toCheck.getEndTime();
        
        if(   // if toCheckStartTime is between  timeslot
              (((toCheckStartTime.isAfter(insertedStartTime)) || toCheckStartTime.equals(insertedStartTime)) &&
              ((toCheckStartTime.isBefore(insertedEndTime)) || toCheckStartTime.equals(insertedEndTime))
              ) 
              ||//if toCheckStartTime is between  timeslot
              (((toCheckEndTime.isAfter(insertedStartTime)) || toCheckEndTime.equals(insertedStartTime)) &&
              ((toCheckEndTime.isBefore(insertedEndTime)) || toCheckEndTime.equals(insertedEndTime))
              ) 
                
          ) {
            return false;
          }
        
        if(toCheckStartTime.isBefore(insertedStartTime) && !toCheckEndTime.isBefore(insertedStartTime)) {
            return false;
        }
        if(toCheckStartTime.isAfter(insertedStartTime) && !toCheckStartTime.isAfter(insertedEndTime)) {
            return false;
        }
        
        return true;
        
        }

@Override
public HandlerList<ProgrammedFilm> getHandlerList() {
    return this.handlerList;
}

 




 
 
}
