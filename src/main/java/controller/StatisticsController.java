package controller;

import java.util.Calendar;

import utilities.FilmBasicImpl;

public interface StatisticsController {
	
	public FilmBasicImpl getMostedWatchedFilm(); // in a week
	public Calendar getMostAffluentDays(); // in  a week
	public Double getRecessed(); // in a week
	
}
