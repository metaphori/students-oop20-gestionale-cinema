package modelImpl;

import java.util.HashSet;
import java.util.Set;

import model.BookingModel;
import utilities.ProgrammedFilm;
import utilities.Ticket;
import utilitiesImpl.Row;
import utilitiesImpl.Seat;
import utilitiesImpl.SeatState;

public class BookingModelImpl implements BookingModel {
    private Set<Ticket> setTicket;
    private Set<Seat<Row,Integer>> seatSelected;
    
    public BookingModelImpl(Set<Ticket> setTicket) {
        seatSelected = new HashSet<>();
        this.setTicket = setTicket;
        
    }
    public void addTicket(Ticket ticket) {
        
    }
    @Override
    public Set<Seat<Row, Integer>> getSeats() {
        // TODO Auto-generated method stub
        return null;
    }
    public Set<Seat<Row,Integer>> getSeatsFromFilm(ProgrammedFilm film){
        return new HashSet<>();
    }
    
    public void buttonSelected(Seat<Row,Integer> seat, ProgrammedFilm film) {
     
       if(seatSelected.contains(seat)) {
        
            seatSelected.remove(seat);
        }else {
            
            seatSelected.add(seat);
        }
            
        
     
    }
    public void newBooking() {
        seatSelected = new HashSet<>();
        
    }
    @Override
    public Set<Seat<Row, Integer>> getSeatsSelected() {
        
        return seatSelected;
    }
    @Override
    public void bookSeat() {
       
        
    }
}
