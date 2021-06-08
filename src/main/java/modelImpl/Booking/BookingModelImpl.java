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
    private final Set<Ticket> setTicket;
    private Set<SeatImpl<Row, Integer>> seatSelected;

    public BookingModelImpl(final Set<Ticket> setTicket) {
        seatSelected = new HashSet<>();
        this.setTicket = setTicket;
    }

    @Override
    public Set<Ticket> getSeats() {
        return setTicket;
    }
    public Set<SeatImpl<Row,Integer>> getSeatsFromFilm(final ProgrammedFilm film){
        return setTicket.stream()
                .filter(f -> f.getId() == film.getIdProgrammation())
                .filter(f -> f.getData().equals(film.getDate()))
                .filter(f -> f.getTime().equals(film.getStartTime()))
                .filter(f -> f.getHall() == film.getHall())
                .flatMap(f -> f.getSetSeat().stream())
                .collect(Collectors.toSet());
    }
    
    public void buttonSelected(final SeatImpl<Row,Integer> seat, final ProgrammedFilm film) {
        final Set<SeatImpl<Row, Integer>> set = this.getSeatsFromFilm(film);
        if (!set.contains(seat)) {
            if (seatSelected.contains(seat)) {
                seatSelected.remove(seat);
            } else {
                seatSelected.add(seat);
            }
        }

    }
    @Override
    public void newBooking() {
        seatSelected = new HashSet<>();
    }
    @Override
    public Set<SeatImpl<Row, Integer>> getSeatsSelected() {
        return seatSelected;
    }
    @Override
    public void bookSeat(final ProgrammedFilm film) {
       if (!seatSelected.isEmpty()) { 
           Optional<Ticket> ticket = setTicket.stream()
           .filter(f -> f.getId() == film.getIdProgrammation())
           .filter(f -> f.getData().equals(film.getDate()))
           .filter(f -> f.getTime().equals(film.getStartTime()))
           .filter(f -> f.getHall() == film.getHall()).findAny();
           if (ticket.isPresent()) {
               ticket.get().getSetSeat().addAll(seatSelected);
           } else {
               final Ticket newTicket = new TicketImpl(film.getDate(), film.getStartTime(), seatSelected, film.getProgrammationPrice(), film.getIdProgrammation(), film.getHall());
               setTicket.add(newTicket);
           }
       }

    }
}
