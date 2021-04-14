package model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import utilities.Film;
import utilities.ProgrammedFilm;
public interface ProgrammedFilmsModel {
    
    public Collection<ProgrammedFilm> getProgrammedFilms();
    public Film getSelectedFilm(String film, LocalDate date, LocalTime startTime, int hallNumber); //return 
    public void deleteSelectedProgrammation();
    
    
    
}
