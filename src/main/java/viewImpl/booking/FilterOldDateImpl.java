package viewImpl.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Predicate;

import model.ManageProgrammingFilms.Filter;
import utilities.Factory.ProgrammedFilm;

public class FilterOldDateImpl implements Filter<ProgrammedFilm> {

    @Override
    public Predicate<ProgrammedFilm> getPredicate() {
        return f -> f.getDate().isAfter(LocalDate.now()) 
        || f.getDate().equals(LocalDate.now()) 
        && f.getStartTime().isAfter(LocalTime.now());
        
    }

}
