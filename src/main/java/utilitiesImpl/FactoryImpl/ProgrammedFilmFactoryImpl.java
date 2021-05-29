package utilitiesImpl.FactoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;

public class ProgrammedFilmFactoryImpl implements ProgrammedFilmFactory {

    @Override
    public ProgrammedFilm creteProgrammedFilm(final int idFilm, final int hall, final double price, final LocalDate date, final LocalTime startTime,final  LocalTime endTime) {
        return new ProgrammedFilmImpl(idFilm,hall,price,date,startTime,endTime);
    }

}
