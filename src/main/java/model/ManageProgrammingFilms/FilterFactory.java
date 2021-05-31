package model.ManageProgrammingFilms;

import java.util.function.Predicate;

public interface FilterFactory<X> {
    
    Filter createFilter();

}
