package model.ManageProgrammingFilms;
/**
 * Filter factory to create a parameterized filter.
 * @param <X> type
 * */
public interface FilterFactory<X> {
    /** 
     * Get filter.
     * @return return created filter
     * */
     Filter<X> createFilter();
}
