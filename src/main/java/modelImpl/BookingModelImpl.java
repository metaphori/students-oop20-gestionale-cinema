package modelImpl;

import java.util.Set;

import model.BookingModel;
import utilities.Ticket;

public class BookingModelImpl implements BookingModel {
    Set<Ticket> setTicket;
    public BookingModelImpl(Set<Ticket> setTicket) {
        this.setTicket = setTicket;
    }
}
