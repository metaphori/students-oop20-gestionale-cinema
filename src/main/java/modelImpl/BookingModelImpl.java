package modelImpl;

import java.util.HashSet;
import java.util.Set;

import model.BookingModel;
import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import utilities.Ticket;

public class BookingModelImpl implements BookingModel {
    private Set<Ticket> setTicket;
    public BookingModelImpl(Set<Ticket> setTicket) {
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
}
