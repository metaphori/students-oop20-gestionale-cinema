package model.ManageProgrammingFilms;

import java.util.Comparator;
/** 
 * Describe a parameterized sorter.
 * @param <X> type to sorter.
 * */
public interface Sorter<X> {
    /** 
     * Get used comparator.
     * @param <X> tyoe used in comparator.
     * @return Comparator<X>
     * */ 
    Comparator<X> getComparator();

}
