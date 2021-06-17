package controller.ManageStatistics;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import controller.CinemaController;
import utilities.Film;

public interface StatisticsController {
    Optional<Film> getMostedWatchedFilm(); 
    Optional<LocalDate> getMostAffluentDays(); 
    Double getRecessed(); 
    Optional<LocalTime> getMostAffluenceHours();
    
    void showStatisticsView();
    void showMenu();
    void setCinemaController(CinemaController cinemaController);
    
	
}