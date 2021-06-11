package controller.ManageStatistics;

import java.time.LocalDate;
import java.util.Calendar;

import utilities.Film;

public interface StatisticsController {
    public Film getMostedWatchedFilm(); // in a week
    public LocalDate getMostAffluentDays(); // in  a week
	public Double getRecessed(); // in a week
	
}
