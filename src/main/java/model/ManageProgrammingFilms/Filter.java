package model.ManageProgrammingFilms;

import java.util.function.Predicate;
/** 
 * Describe a generic filter.
 * @param <X> type to filter 
 * */
public interface Filter<X> {
    /** 
     * Get used predicate.
     * @return Predicate<X>
     * */
    Predicate<X> getPredicate();
}
