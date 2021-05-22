package utilitiesImpl.FactoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;

public class ProgrammedFilmFactoryImpl implements ProgrammedFilmFactory {

    @Override
    public ProgrammedFilm creteProgrammedFilm(int idFilm, int hall, double price, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return new ProgrammedFilmImpl(idFilm,hall,price,date,startTime,endTime);
    }

}
