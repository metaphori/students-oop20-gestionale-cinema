package controllerImpl.ManageStatistics;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import javax.swing.border.TitledBorder;

import controller.Booking.BookingController;
import controller.ManageFilms.FilmsController;
import controller.ManageStatistics.StatisticsController;
import model.Booking.BookingModel;
import utilities.Film;
import utilities.Ticket;

public class StatisticsControllerImpl implements StatisticsController{
    private BookingController controllerBooking;
    private FilmsController controllerFilm;
    public StatisticsControllerImpl() {
    }
    
    @Override
    public Optional<Film> getMostedWatchedFilm() {
        Optional<Ticket> ticketOptional = this.controllerBooking.getTicket().stream().max( (t1, t2) -> {
            return t1.getSetSeat().size() - t2.getSetSeat().size();
        });
        if(ticketOptional.isPresent()) {
            return controllerFilm.getFilms().stream().filter(f -> f.getID() == ticketOptional.get().getId()).findFirst();
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<LocalDate> getMostAffluentDays() {
        Set<Ticket> ticketDay = this.controllerBooking.getTicket();
        for(var ticket : ticketDay) {
            
        }
        return null;
    }

    @Override
    public Double getRecessed() {
        return this.controllerBooking.getTicket().stream().mapToDouble(f -> f.getPrice()).sum();

    }
    
    public void setControllerBooking(BookingController controllerBooking) {
        this.controllerBooking = controllerBooking;
    }

    public void setControllerFilms(FilmsController controllerFilm) {
        this.controllerFilm = controllerFilm;
    }
}
