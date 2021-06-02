package modelImpl.Booking;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import model.Booking.BookingModel;
import utilities.Factory.*;
import utilities.Ticket;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.SeatState;
import utilitiesImpl.TicketImpl;

public class BookingModelImpl implements BookingModel {
    private Set<Ticket> setTicket;
    private Set<SeatImpl<Row, Integer>> seatSelected;
    
    public BookingModelImpl(final Set<Ticket> setTicket) {
        seatSelected = new HashSet<>();
        this.setTicket = setTicket;
        System.out.print("MODEL" + setTicket);
    }
    public void addTicket(Ticket ticket) {
    }
    @Override
    public Set<Ticket> getSeats() {
        
        return setTicket;
    }
    public Set<SeatImpl<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film){
        System.out.println("TicketGet" + setTicket);
        System.out.print("Film" + film);
        System.out.print(film.getStartTime());
        setTicket.stream()
        .filter(f -> f.getId() == film.getIdProgrammation())
        .filter(f -> f.getData().equals(film.getDate()))
        .filter(f -> f.getTime().equals(film.getStartTime()))
        .filter(f -> f.getHall() == film.getHall())
        .forEach(i -> System.out.println("el:" + i));
        return setTicket.stream()
                .filter(f -> f.getId() == film.getIdProgrammation())
                .filter(f -> f.getData().equals(film.getDate()))
                .filter(f -> f.getTime().equals(film.getStartTime()))
                .filter(f -> f.getHall() == film.getHall())
                .flatMap(f -> f.getSetSeat().stream())
                .collect(Collectors.toSet());
    }
    
    public void buttonSelected(SeatImpl<Row,Integer> seat, ProgrammedFilm film) {
        Set<SeatImpl<Row,Integer>> set = this.getSeatsFromFilm(film);
        if(!set.contains(seat)) {
            if(seatSelected.contains(seat)) {
                seatSelected.remove(seat);
            }else {
            
                seatSelected.add(seat);
            }
        }   
        
     
    }
    public void newBooking() {
        seatSelected = new HashSet<>();
        
    }
    @Override
    public Set<SeatImpl<Row, Integer>> getSeatsSelected() {
        
        return seatSelected;
    }
    @Override
    public void bookSeat(ProgrammedFilm film) {
       if(!seatSelected.isEmpty()) { 
           Optional<Ticket> ticket = setTicket.stream()
           .filter(f -> f.getId() == film.getIdProgrammation())
           .filter(f -> f.getData().equals(film.getDate()))
           .filter(f -> f.getTime().equals(film.getStartTime()))
           .filter(f -> f.getHall()==film.getHall()).findAny();
           if(ticket.isPresent()){
               ticket.get().getSetSeat().addAll(seatSelected);
           }else {
               Ticket newTicket = new TicketImpl(film.getDate(),film.getStartTime(),seatSelected,film.getProgrammationPrice(),film.getIdProgrammation(),film.getHall());
               setTicket.add(newTicket);
           }
       }
           
       //System.out.println("SetTicket:" + setTicket);    
      // System.out.println("TicketSelected" + seatSelected);
    }
}
