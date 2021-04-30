package modelImpl;

import java.util.Set;

import model.BookingModel;
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
    public Set<Seat<Row, Integer>> getSeat() {
        // TODO Auto-generated method stub
        return null;
    }
}
