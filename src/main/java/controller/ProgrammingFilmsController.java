package controller;


import java.util.Collection;

import utilities.ProgrammedFilm;

public interface ProgrammingFilmsController {

	public Collection<ProgrammedFilm> getProgrammazioneFilm();
		
	public void addProgrammazioneFilm(ProgrammedFilm pr);
	public void deleteProgrammazioneFilm(ProgrammedFilm pr);
	
	public void showProgrammazioneFilmView();
	
	public void showMenu();
	
	
}
