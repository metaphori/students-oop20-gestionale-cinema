package model.ManageProgrammingFilms;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface HandlerList<X> {     
    List<X> filterBy(List<X> list ,Filter <X> filter);
    List<X> sortBy( List<X> list, Sorter <X> sorter);
}
