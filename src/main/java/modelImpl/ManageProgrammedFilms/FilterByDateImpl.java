package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.util.function.Predicate;

import model.ManageProgrammingFilms.Filter;
import utilities.Factory.ProgrammedFilm;

public class FilterByDateImpl implements Filter<ProgrammedFilm>{
    final private  LocalDate localDate;
      
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
