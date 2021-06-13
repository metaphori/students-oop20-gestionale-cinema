package controller.ManageStatistics;

import java.time.LocalDate;
import java.util.Optional;

import utilities.Film;

public interface StatisticsController {
	
	public Optional<Film> getMostedWatchedFilm(); // in a week
	
	public Optional<LocalDate> getMostAffluentDays(); // in  a week
	
	public Double getRecessed(); // in a week
	
}
