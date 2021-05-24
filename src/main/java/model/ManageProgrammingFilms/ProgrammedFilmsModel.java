package model.ManageProgrammingFilms;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;

public interface ProgrammedFilmsModel{
    
    void addFilmProgrammation(ProgrammedFilm programmedFilm);
    void deleteFilmProgrammation(ProgrammedFilm programmedFilm);
       
    
}