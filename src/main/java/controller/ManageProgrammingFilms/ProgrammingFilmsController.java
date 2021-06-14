package controller.ManageProgrammingFilms;

import java.util.List;

import controller.CinemaController;
import controller.ManageFilms.FilmsController;
import exceptions.ProgrammationNotAvailableException;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import utilities.Film;
import utilities.Factory.ProgrammedFilm;
/**
 * This controller manages films programmation.
 * */
public interface ProgrammingFilmsController {
    /**
     * Get all programmed films.
     * @return List<ProgrammedFilm>
     */
    List<ProgrammedFilm> getAllProgrammedFilms();
    /**
     * Get manager programming films.
     * @return ManagerProgrammingFilms
     */
    ManagerProgrammingFilms getManagerProgrammingFilms();
    /**
     * Add programmedFilm.
     * @param newProgrammedFilm film programmation to add
     * @throws ProgrammationNotAvailableException throws exception when specific date, time and hall by programmedFilm isn't available.
     */
    void addProgrammedFilm(ProgrammedFilm newProgrammedFilm) throws ProgrammationNotAvailableException;
    /**
     * Delete programmedFilm.
     * @param oldProgrammedFilm film programmation to delete
     */
    void deleteProgrammedFilm(ProgrammedFilm oldProgrammedFilm);
    /**
     * Show programmed film view with all programmation.
     */
    void showProgrammedFilmView();
    /**
     * Show schedule film view to schedule a new film.
     */
    void showScheduleFilmView();
    /**
     * Show menu.
     */
    void showMenu();
    /**
     * Get film controller.
     */
    FilmsController getFilmsController();
    /**
     * Delete all programmation of specific film.
     * @param film
     */
    void deleteAllFilmProgrammation(Film film);
    /**
     * Update and refresh GUI when new data are added.
     */
    void updateGUI();
    /**
     * Set films controller.
     */
    void setFilmsController(FilmsController filmsController);
    /**
     * Set films controller.
     */
    void setCinemaController(CinemaController cinemaController);

}
