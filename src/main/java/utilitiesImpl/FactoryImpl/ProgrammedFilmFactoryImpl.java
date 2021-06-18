package utilitiesImpl.FactoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.Hall;

public final class ProgrammedFilmFactoryImpl implements ProgrammedFilmFactory {
    /**
     * {@inheritDoc}
     * */
    @Override
    public ProgrammedFilm createProgrammedFilm(final int idFilm, final Hall hall, final double price, final LocalDate date, final LocalTime startTime, final  LocalTime endTime) {
        return new ProgrammedFilmImpl(idFilm, hall, price, date, new TimeSlotImpl(startTime, endTime));
    }
 

}
