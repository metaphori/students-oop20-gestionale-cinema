package model.ManageProgrammingFilms;
/**
 * Filter factory to create a parameterized filter.
 * @param <X> type
 * */
public interface FilterFactory<X> {
    /** 
     * Get filter.
     * */
     Filter<X> createFilter();
}
