package controller.ManageStatistics;

import java.time.LocalDate;
import java.util.Optional;

import utilities.Film;

public interface StatisticsController {
    Optional<Film> getMostedWatchedFilm(); 
    Optional<LocalDate> getMostAffluentDays(); 
    Double getRecessed(); 
    
    void showStatisticsView();
    void showMenu();
	
}