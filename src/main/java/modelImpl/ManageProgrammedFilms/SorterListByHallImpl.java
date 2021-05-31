package modelImpl.ManageProgrammedFilms;

import java.util.Comparator;

import model.ManageProgrammingFilms.Sorter;
import utilities.Factory.ProgrammedFilm;

public class SorterListByHallImpl implements Sorter<ProgrammedFilm> {

    @Override
    public Comparator<ProgrammedFilm> getComparator() {
        return (fp1, fp2) -> fp1.getHall()-fp2.getHall();
    }

}
