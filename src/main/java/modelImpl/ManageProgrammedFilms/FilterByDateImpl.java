package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.util.function.Predicate;

import model.ManageProgrammingFilms.Filter;
import utilities.Factory.ProgrammedFilm;
/** 
 * Describe a filter by date on programmed film.
 * */
public final class FilterByDateImpl implements Filter<ProgrammedFilm> {
    private final  LocalDate localDate; // date to filter
    public FilterByDateImpl(final LocalDate localDate) {
        super();
        this.localDate = localDate;
    }

    @Override
    public Predicate<ProgrammedFilm> getPredicate() {
        return pf -> 
        pf.getDate().equals(localDate);
    }

}
