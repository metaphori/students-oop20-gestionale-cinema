package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.util.function.Predicate;

import model.ManageProgrammingFilms.Filter;
import utilities.Factory.ProgrammedFilm;

public class FilterByDateHallImpl implements Filter <ProgrammedFilm> {
    final private  LocalDate localDate;
    final private  int hall;
    
    public FilterByDateHallImpl(final LocalDate localDate, final int hall) {
        super();
        this.localDate = localDate;
        this.hall = hall;
    }

    @Override
    public Predicate<ProgrammedFilm> getPredicate() {
        return pf ->  pf.getHall() == hall && pf.getDate().equals(localDate);
    }

}
