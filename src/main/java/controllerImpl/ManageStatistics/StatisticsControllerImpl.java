package controllerImpl.ManageStatistics;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.border.TitledBorder;

import controller.Booking.BookingController;
import controller.ManageFilms.FilmsController;
import controller.ManageStatistics.StatisticsController;
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
    
    private StatisticsGUI statisticsView;
    
    public StatisticsControllerImpl() {
        statisticsView = new StatisticsImplGUI();
        this.statisticsView.setObserver(this);
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

        Set <Ticket> set = controllerBooking.getTicket();
        
        Set<LocalDate> dates = set.stream().map(t -> t.getDate()).collect(Collectors.toSet());
        LocalDate mostAffluentDate = null;
        
        int val = 0;

        
        for(var date: dates) {
            int temp = set.stream().filter(t -> t.getDate().equals(date)).reduce(0, (partialRes,t) -> partialRes+t.getSetSeat().size() , (res1,res2) -> res1+res2);
            
            if(val<temp) {
                mostAffluentDate = date;   
            }
        } 
        return Optional.of(mostAffluentDate);
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
    
    @Override
    public void showStatisticsView() {
        statisticsView.update();
        statisticsView.show();
    }
    
    @Override
    public void showMenu() {
        
    }
}
