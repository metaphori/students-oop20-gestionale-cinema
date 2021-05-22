package controller;


import java.time.LocalDate;
import java.util.Collection;

import utilities.ProgrammedFilm;

public interface ProgrammingFilmsController {

	public Collection<ProgrammedFilm> getProgrammazioneFilm();
		
	public void addProgrammedFilm(ProgrammedFilm newProgrammedFilm);
	public void deleteProgrammedFilm(ProgrammedFilm oldProgrammedFilm);
	public void getProgrammedFilmsBySelection(String film, LocalDate date); // return programmedFilms in a certain date for a specified film
	public void showProgrammedFilmView();
	
	public void showMenu();
	
	
}
