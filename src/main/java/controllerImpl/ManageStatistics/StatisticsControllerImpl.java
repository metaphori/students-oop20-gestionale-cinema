package controllerImpl.ManageStatistics;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.border.TitledBorder;

import controller.CinemaController;
import controller.Booking.BookingController;
import controller.ManageFilms.FilmsController;
import controller.ManageStatistics.StatisticsController;
import controllerImpl.Booking.BookingControllerImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import model.Booking.BookingModel;
import modelImpl.Booking.BookingModelImpl;
import utilities.Film;
import utilities.Ticket;
import utilitiesImpl.TicketImpl;
import view.ManageStatistics.StatisticsGUI;
import viewImpl.ManageStatistics.StatisticsImplGUI;

public class StatisticsControllerImpl implements StatisticsController{
    private BookingModel modelBooking;

    private BookingController controllerBooking;
    private FilmsController controllerFilm;
    private CinemaController controllerCinema;

    private StatisticsGUI statisticsView;

    public StatisticsControllerImpl() {
        this.statisticsView = new StatisticsImplGUI();
        this.statisticsView.setObserver(this);

        this.controllerBooking = new BookingControllerImpl();
        this.controllerFilm = new FilmsControllerImpl();
        System.out.println();
        System.out.println("Film" + controllerFilm.getFilms());
    }

    @Override
    public Optional<Film> getMostedWatchedFilm() {
        Optional<Ticket> ticketOptional = this.controllerBooking.getTicket().stream().max((t1, t2) -> {
            return t1.getSetSeat().size() - t2.getSetSeat().size();
        });
        if (ticketOptional.isPresent()) {
            return controllerFilm.getFilms().stream().filter(f -> f.getID() == ticketOptional.get().getId()).findFirst();
        }

        return Optional.empty();
    }

    @Override
    public Optional<LocalDate> getMostAffluentDays() {

        Set<Ticket> set = controllerBooking.getTicket();

        Set<LocalDate> dates = set.stream().map(t -> t.getDate()).distinct().collect(Collectors.toSet());
        Optional<LocalDate> mostAffluentDate = Optional.empty();

        int val = 0;

        for (var date: dates) {
            int temp = set.stream().filter(t -> t.getDate().equals(date)).reduce(0, (partialRes,t) -> partialRes+t.getSetSeat().size() , (res1,res2) -> res1+res2);

            if (val<temp) {
                mostAffluentDate = Optional.of(date);
                val = temp;
            }
        } 
        return mostAffluentDate;
    }

    @Override
    public Double getRecessed() {
        double tot = 0;
        for (var ticket : this.controllerBooking.getTicket()) {
           tot = tot + ticket.getSetSeat().size() * ticket.getPrice();
        }

        return tot;

    }

    @Override
    public void showStatisticsView() {
        statisticsView.show();
        statisticsView.update();
    }

    @Override
    public void showMenu() {
        controllerCinema.showMenu();
    }

    @Override
    public void setCinemaController(CinemaController cinemaController) {
        this.controllerCinema = cinemaController;
    }

}
