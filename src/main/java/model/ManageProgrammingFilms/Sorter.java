package model.ManageProgrammingFilms;

import java.util.Comparator;
/** 
 * Describe a parameterized sorter.
 * @param <X> type to sorter.
 * */
public interface Sorter<X> {
    /** 
     * Get used comparator.
     * @param X type used in comparator.
     * @return comparator
     * */ 
    Comparator<X> getComparator();

}
