package controller.ManageProgrammingFilms;


import java.time.LocalDate;
import java.util.Collection;

import utilities.Factory.ProgrammedFilm;

public interface ProgrammingFilmsController {
        
        Collection<ProgrammedFilm> getAllProgrammationFilms();
	void addProgrammedFilm(ProgrammedFilm newProgrammedFilm);
	void deleteProgrammedFilm(ProgrammedFilm oldProgrammedFilm);
	void getProgrammedFilmsBySelection(String film, LocalDate date); // return programmedFilms in a certain date for a specified film
	void showProgrammedFilmView();
	void showScheduleFilmView();
	void showMenu();	
}
