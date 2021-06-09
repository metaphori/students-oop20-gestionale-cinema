package controller.Booking;

import java.util.Set;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import utilities.Ticket;

public interface BookingController {
        void start();
        void showMenu();
        Set<Ticket> getTicket();
        void setControllerFilms(FilmsController controllerFilms);
        void setControllerProgrammingFilms(ProgrammingFilmsController controllerProgrammingFilms);
}
