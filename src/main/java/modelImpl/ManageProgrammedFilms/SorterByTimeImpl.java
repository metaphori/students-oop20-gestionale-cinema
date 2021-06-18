package modelImpl.ManageProgrammedFilms;

import java.util.Comparator;

import model.ManageProgrammingFilms.Sorter;
import utilities.Factory.ProgrammedFilm;
/** 
 * 
 * Describe a sorter by time on programmed film.
 * */

public final class SorterByTimeImpl implements Sorter<ProgrammedFilm> {
    /** 
     * {@inheritDoc}
     * */
    @Override
    public Comparator<ProgrammedFilm> getComparator() {
        return (pf1, pf2) -> { //a negative integer, zero, or a positive integer as pf1 is less than, equal to, or greater than pf2
            return pf1.getStartTime().compareTo(pf2.getStartTime());
        };
    }

}
