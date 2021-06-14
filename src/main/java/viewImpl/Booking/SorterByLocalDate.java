package viewImpl.Booking;

import java.util.Comparator;

import model.ManageProgrammingFilms.Sorter;
import utilities.Factory.ProgrammedFilm;

public class SorterByLocalDate implements Sorter<ProgrammedFilm>{
    public SorterByLocalDate() {
    }
    @Override
    public Comparator<ProgrammedFilm> getComparator() {
       return (f1, f2) -> {
            return f1.getDate().compareTo(f2.getDate());
        };
    }

}
