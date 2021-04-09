package controllerInterfaces;

import java.util.Calendar;

import utilities.Film;

public interface StatisticsController {
	
	public Film getMostedWatchedFilm(); // in a week
	public Calendar getMostAffluentDays(); // in  a week
	public Double getRecessed(); // in a week
	

}
