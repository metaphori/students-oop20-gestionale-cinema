package controller.ManageStatistics;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import controller.CinemaController;
import utilities.Film;

public interface StatisticsController {
    
    /**
     * Film most watched.
     * @return Film
     */
    Optional<Film> getMostedWatchedFilm();
    
    /**
     * Most affluent day.
     * @return
     */
    Optional<LocalDate> getMostAffluentDays(); 
    
    /**
     * Most affluent time.
     * @return
     */
    Optional<LocalTime> getMostAffluenceHours();
    
    /**
     * Total cinema gain.
     * @return
     */
    Double getRecessed();
    
    /**
     * Show statistics view
     */
    void showStatisticsView();
    
    /**
     * Show menu view.
     */
    void showMenu();
    
    /**
     * Set Cinema Controller.
     * @param cinemaController
     */
    void setCinemaController(CinemaController cinemaController);
    
	
}