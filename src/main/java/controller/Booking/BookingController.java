package controller.Booking;

import java.util.Set;

import utilities.Ticket;

public interface BookingController {
        void start();
        void showMenu();
        Set<Ticket> getTicket();
}
