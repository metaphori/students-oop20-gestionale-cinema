package viewImpl.Booking;

import java.util.Comparator;

import model.ManageProgrammingFilms.Sorter;
import utilities.Factory.ProgrammedFilm;

public class SorterByLocalTime implements Sorter<ProgrammedFilm> {
    
    public SorterByLocalTime() {
        
    }
    @Override
    public Comparator<ProgrammedFilm> getComparator() {
        // TODO Auto-generated method stub
        return (f1, f2) ->{
            return f1.getStartTime().compareTo(f2.getStartTime());
            
        };
    }

}
