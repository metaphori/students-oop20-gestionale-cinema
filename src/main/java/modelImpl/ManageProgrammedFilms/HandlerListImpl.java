package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.ManageProgrammingFilms.Filter;
import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.Sorter;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;

public class HandlerListImpl<X> implements HandlerList<X> {
    
    @Override
    public List<X> filterBy(final List<X> list, final Filter<X> filter) {
        
        return list.stream()
                .filter(filter.getPredicate())
                .collect(Collectors.toList());
     
    }

    @Override
    public List<X> sortBy(final List<X> list, final Sorter<X> sorter) {
        return list.stream()
                .sorted(sorter.getComparator())
                .collect(Collectors.toList());
    }

}
