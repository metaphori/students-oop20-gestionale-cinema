package controller;

import java.util.Collection;

import utilities.FilmBasicImpl;

public interface FilmsController {
	
	public void addFilm(FilmBasicImpl f);
	public void deleteFilm(FilmBasicImpl f);
	
	public Collection<FilmBasicImpl> getFilms();//recupera i film da file
	public void loadFilm(Collection <FilmBasicImpl> loadedFilms);//Carica i film sul model
	
	public void showManageFilmsView();
	
	public void showMenu();
}
