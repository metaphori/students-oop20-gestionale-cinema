package model.ManageProgrammingFilms;

import java.util.List;

/** Describe an handler that can filter and sorted a generic list. 
 * @param <X> type to handled.
 * */
public interface HandlerList<X> {
    /** 
     * Filter a specific list with a specific filter.
     * @param list list to filter
     * @param filter filter to use
     * @return List<X> filtered list
     * */
    List<X> filterBy(List<X> list, Filter<X> filter);
    /** 
     * Sort a specific list with a specific sorter.
     * @param list list to sort
     * @param sorter sorter to use
     * @return List<X> sorted list
     * */
    List<X> sortBy(List<X> list, Sorter<X> sorter);
}
