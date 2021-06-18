package TestBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Booking.BookingModel;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.Booking.BookingModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.Seat;
import utilities.Ticket;
import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.Hall;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.TicketImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;

public class TestModelBooking {
    @Test
    public void testModelgetSeatsFromProgrammedFilm() {
        final LocalDate date = LocalDate.of(2021, 8, 29);
        final LocalTime timeStart = LocalTime.of(18, 45);
        final LocalTime timeEnd = LocalTime.of(19, 45);
        final Set<Seat> setSeat = new HashSet<>();
        final Set<Seat> setSeat1 = new HashSet<>();
        final Set<Ticket> setTicket = new HashSet<>();
        final Seat seat1 = new SeatImpl(Row.C, 10);
        final Seat seat2 = new SeatImpl(Row.A, 11);
        final Seat seat3 = new SeatImpl(Row.B, 12);
        setSeat.add(seat1);
        setSeat.add(seat2);
        setSeat1.add(seat1);
        setSeat1.add(seat2);
        setSeat1.add(seat3);
        final Ticket ticket = new TicketImpl(date, timeStart, setSeat, 8.0, 1, Hall.HALL_1);
        final Ticket ticket1 = new TicketImpl(date, timeStart, setSeat1, 8.0, 2, Hall.HALL_2);
        setTicket.add(ticket);
        setTicket.add(ticket1);
        final BookingModel modelBooking = new BookingModelImpl(setTicket);
        final ProgrammedFilmFactory factoryProgrammedFilm = new ProgrammedFilmFactoryImpl();
        final ProgrammedFilm filmProgrammed = factoryProgrammedFilm.createProgrammedFilm(1, Hall.HALL_1, 8.0, date, timeStart, timeEnd);
        final Set<Seat> setSeatFilter = modelBooking.getSeatsFromProgrammedFilm(filmProgrammed);
        assertEquals(setSeat, setSeatFilter);
    }

    @Test
    public void testModelDeleteFilm() {
        final LocalDate date = LocalDate.of(2021, 8, 29);
        final LocalTime timeStart = LocalTime.of(18, 45);
        final Set<Seat> setSeat = new HashSet<>();
        final Set<Seat> setSeat1 = new HashSet<>();
        final Set<Ticket> setTicket = new HashSet<>();
        final Seat seat1 = new SeatImpl(Row.C, 10);
        final Seat seat2 = new SeatImpl(Row.A, 11);
        final Seat seat3 = new SeatImpl(Row.B, 12);
        setSeat.add(seat1);
        setSeat.add(seat2);
        setSeat1.add(seat1);
        setSeat1.add(seat2);
        setSeat1.add(seat3);
        final Ticket ticket = new TicketImpl(date, timeStart, setSeat, 8.0, 1, Hall.HALL_1);
        final Ticket ticket1 = new TicketImpl(date, timeStart, setSeat1, 8.0, 1, Hall.HALL_2);
        setTicket.add(ticket);
        setTicket.add(ticket1);
        final BookingModel modelBooking = new BookingModelImpl(setTicket);
        final FilmFactory factoryFilm = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
        final Film film = factoryFilm.createBasicFilmById("Holly", "action", "Good", Optional.empty(), 120, 1);
        modelBooking.deleteTicket(film);
        assertEquals(new HashSet<>(), modelBooking.getSeats());
    }

    @Test
    public void testModelDeleteProgrammedFilm() {
        final LocalDate date = LocalDate.of(2021, 8, 29);
        final LocalTime timeStart = LocalTime.of(18, 45);
        final LocalTime timeEnd = LocalTime.of(19, 45);
        final Set<Seat> setSeat = new HashSet<>();
        final Set<Seat> setSeat1 = new HashSet<>();
        final Set<Ticket> setTicket = new HashSet<>();
        final Seat seat1 = new SeatImpl(Row.C, 10);
        final Seat seat2 = new SeatImpl(Row.A, 11);
        final Seat seat3 = new SeatImpl(Row.B, 12);
        setSeat.add(seat1);
        setSeat.add(seat2);
        setSeat1.add(seat1);
        setSeat1.add(seat2);
        setSeat1.add(seat3);
        final Ticket ticket = new TicketImpl(date, timeStart, setSeat, 8.0, 1, Hall.HALL_1);
        final Ticket ticket1 = new TicketImpl(date, timeStart, setSeat1, 8.0, 2, Hall.HALL_2);
        setTicket.add(ticket);
        setTicket.add(ticket1);
        final BookingModel modelBooking = new BookingModelImpl(setTicket);
        final ProgrammedFilmFactory factoryProgrammedFilm = new ProgrammedFilmFactoryImpl();
        final ProgrammedFilm filmProgrammed = factoryProgrammedFilm.createProgrammedFilm(1, Hall.HALL_1, 8.0, date, timeStart, timeEnd);
        modelBooking.deleteTicket(filmProgrammed);
        assertEquals(ticket1, modelBooking.getSeats().stream().findAny().get());
    }
}
