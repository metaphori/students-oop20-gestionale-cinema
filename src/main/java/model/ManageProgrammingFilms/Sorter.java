package model.ManageProgrammingFilms;

import java.util.Comparator;

public interface Sorter <X> {
    Comparator<X> getComparator();

}
