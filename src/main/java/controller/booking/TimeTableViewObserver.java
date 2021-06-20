package controller.booking;

import java.util.Collection;
import java.util.List;
import model.ManageProgrammingFilms.Filter;
import model.ManageProgrammingFilms.Sorter;
import utilities.Film;
import utilities.Factory.ProgrammedFilm;

public interface TimeTableViewObserver {
    /**
     * Show next view for booking a seat for a specific film programmed.
     * @param film programmed for book seat
     */
    void bookTicketForFilm(ProgrammedFilm film);
    /**
     * Show the TimeTableView.
     */
    void showBackFromTimeTable();
    /**
     * Return Film of ProgrammedFilm.
     * @param film programmed
     * @return film 
     */
    Film getFilmByProgrammedFilm(ProgrammedFilm film);
    /**
     * Method to filter a collection using a specific filter.
     * @param coll to filter
     * @param filter used to filter
     * @return list filtered
     */
    List<ProgrammedFilm> handlerProgrammedFilm(Collection<ProgrammedFilm> coll, Filter<ProgrammedFilm> filter);
    /**
     * Method to sorter a collection using a specific sorter.
     * @param coll to sorter
     * @param sorter used to sort
     * @return list sorted
     */
    List<ProgrammedFilm> handlerProgrammedFilm(Collection<ProgrammedFilm> coll, Sorter<ProgrammedFilm> sorter);
}
