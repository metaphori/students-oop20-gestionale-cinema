package controllerInterfaces;

import java.util.Collection;

import utilities.Film;

public interface FilmsController {
	
	public void addFilm(Film f);
	public void deleteFilm(Film f);
	
	public Collection<Film> getFilms();//recupera i film da file
	public void loadFilm(Collection <Film> loadedFilms);//Carica i film sul model
	
	public void showManageFilmsView();
	
	public void showMenu();
}
