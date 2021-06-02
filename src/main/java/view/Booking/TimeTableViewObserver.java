package view.Booking;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import model.ManageProgrammingFilms.Filter;
import model.ManageProgrammingFilms.Sorter;
import utilities.Film;
import utilities.Factory.*;

public interface TimeTableViewObserver {
    void bookTicketForFilm(ProgrammedFilm film);
   void showBackFromTimeTable();
    Film getFilmByProgrammedFilm(ProgrammedFilm film);
    List<ProgrammedFilm> handlerProgrammedFilm( Collection<ProgrammedFilm> coll, Filter<ProgrammedFilm> filter);
    List<ProgrammedFilm> handlerProgrammedFilm( Collection<ProgrammedFilm> coll, Sorter<ProgrammedFilm> sorter);
}
