package testbooking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.booking.BookingModel;
import modelimpl.booking.BookingModelImpl;
import utilities.Seat;
import utilities.Ticket;
import utilitiesimpl.Hall;
import utilitiesimpl.Row;
import utilitiesimpl.SeatImpl;
import utilitiesimpl.TicketImpl;

public class TestModelBooking {
  
    
    @Test
    public void testModelgetSeatsFromProgrammedFilm() {
        
        final LocalDate date = LocalDate.of(2021, 8, 29);
        final LocalTime time = LocalTime.of(18, 45);
        final Set<Seat> setSeat = new HashSet<>();
        final Set<Ticket> setTicket = new HashSet<>();
        final SeatImpl seat1 = new SeatImpl(Row.C, 10);
        final SeatImpl seat2 = new SeatImpl(Row.A, 11);
        setSeat.add(seat1);
        setSeat.add(seat2);
        final Ticket ticket = new TicketImpl(date, time, setSeat, 8.0, 1, Hall.HALL_1);
        final Ticket ticket1 = new TicketImpl(date, time, setSeat, 8.0, 1, Hall.HALL_1);
        setTicket.add(ticket);
        setTicket.add(ticket1);
        final BookingModel modelBooking = new BookingModelImpl(setTicket);
        
        
        
    }
    
}
