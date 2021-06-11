package controller.Booking;

import java.util.Set;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import utilities.Film;
import utilities.Ticket;
import utilities.Factory.ProgrammedFilm;

public interface BookingController {
        void start();
        void showMenu();
        Set<Ticket> getTicket();
        void deleteTicket(Film film);
        void deleteTicket(ProgrammedFilm programmedFilm);
        void setControllerFilms(FilmsController controllerFilms);
        void setControllerProgrammingFilms(ProgrammingFilmsController controllerProgrammingFilms);
}
