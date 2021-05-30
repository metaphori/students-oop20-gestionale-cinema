package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.TimeSlotImpl;

public class ProgrammedFilmsModelImpl implements ProgrammedFilmsModel{
    
    List <ProgrammedFilm> programmedFilms = new ArrayList<>();
    

    @Override
    public void addFilmProgrammation(final ProgrammedFilm programmedFilm) {
        programmedFilms.add(programmedFilm);
    }

    @Override
    public void deleteFilmProgrammation(final ProgrammedFilm programmedFilm) {
        
    }
    
    
    
    
    
    public boolean isAvailableProgrammation(final TimeSlot timeSlotToCheck, final LocalDate date, final int hall) { // check if timeslot is available for specific date and hall 
   
        return !this.filterListByDateHall(date, hall)
        .stream()
        .anyMatch(pf -> {
           if( this.isAvailableTimeSlot(new TimeSlotImpl(pf.getStartTime(), pf.getEndTime()), timeSlotToCheck)) { // if it's available it means that there isn't any match , so return false
               return false;
           } 
           return true;
        }
        );           
    }
    
    private  boolean isAvailableTimeSlot(final TimeSlot inserted , final TimeSlot toCheck) {
        
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
        
    public List<ProgrammedFilm> getALlPorgrammedFilms() {
        return this.programmedFilms;
    }
    
    public List<ProgrammedFilm> filterListByDateHall(final LocalDate date , int hall) { // create 
       
       return  programmedFilms.stream().filter(pf -> {
               return (pf.getHall() == hall && pf.getDate().equals(date));})
               .collect(Collectors.toList());
       
    }

}
