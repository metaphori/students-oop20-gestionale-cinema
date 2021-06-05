package model.ManageProgrammingFilms;

import java.util.function.Predicate;

public interface Filter<X> {
    Predicate<X> getPredicate();
}
