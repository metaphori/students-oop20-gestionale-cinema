package controllerImpl.Booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.google.gson.reflect.TypeToken;
import controller.CinemaController;
import controller.Booking.BookingController;
import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import model.Booking.BookingModel;
import model.ManageProgrammingFilms.Filter;
import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.Sorter;
import modelImpl.Booking.BookingModelImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import utilities.Film;
import utilities.Ticket;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.SeatImpl;
import view.Booking.BookingView;
import view.Booking.BookingViewObserver;
import view.Booking.ListFilmView;
import view.Booking.ListFilmViewObserver;
import view.Booking.TimeTableView;
import view.Booking.TimeTableViewObserver;
import viewImpl.Booking.BookingViewImpl;
import viewImpl.Booking.ListFilmViewImpl;
import viewImpl.Booking.TimeTableViewImpl;

public class BookingControllerImpl implements BookingController, ListFilmViewObserver, TimeTableViewObserver, BookingViewObserver {
    private BookingModel modelBooking;
    private final Set<Film> setFilm;
    private final Set<ProgrammedFilm> setProgrammedFilm;
    private CinemaController observer;
    private BookingView viewBooking; 

    public BookingControllerImpl() {
        final Optional<Set<Ticket>> opSetTicket = this.readTicketOnFile();
        final FilmsController controllerFilms = new FilmsControllerImpl();
        final ProgrammingFilmsController controllerFilmProgrammed = new ProgrammingFilmsControllerImpl();

        if (opSetTicket.isEmpty()) {
            modelBooking = new BookingModelImpl(new HashSet<>());
        } else {
            modelBooking = new BookingModelImpl(opSetTicket.get());
        }
        setProgrammedFilm = new HashSet<>(controllerFilmProgrammed.getAllProgrammedFilms());
        setFilm = controllerFilms.getFilms();
    }

    @Override
    public void start() {
        this.showListFilmView();
    }

    @Override
    public void selectedFilm(final Film film) {
        final Set<ProgrammedFilm> setFiltered = setProgrammedFilm.stream()
                .filter(i -> i.getIdProgrammation() == film.getID())
                .collect(Collectors.toSet());
        this.showTimeTableView(setFiltered, film);
    }

    @Override
    public void showMenu() {
        this.observer.showMenu();
    }

    @Override
    public Set<Film> getFilm() {
        return setFilm;
    }

    @Override
    public void bookTicketForFilm(final ProgrammedFilm film) {
        this.showBookingView(film);
        viewBooking.refresh();
    }

    @Override
    public Film getFilmByProgrammedFilm(final ProgrammedFilm film) {
        return setFilm.stream().filter(f -> f.getID() == film.getIdProgrammation()).findAny().get();
    }

    @Override
    public void showBackFromTimeTable() {
        this.showListFilmView();
    }

    @Override
    public void showBackFromBooking(final ProgrammedFilm programmedFilm) {
        final Set<ProgrammedFilm> setPF = setProgrammedFilm.stream()
                .filter(i -> i.getIdProgrammation() == programmedFilm.getIdProgrammation())
                .collect(Collectors.toSet());
        final Film film = setFilm.stream().filter(f -> f.getID() == programmedFilm.getIdProgrammation())
                .findAny()
                .get();
        this.showTimeTableView(setPF, film);
    }

    @Override
    public Set<SeatImpl> getSeatsFromFilm(final ProgrammedFilm film) {
        return this.modelBooking.getSeatsFromFilm(film);
    }

    @Override
    public void bookSeat(final ProgrammedFilm film) {
        modelBooking.bookSeat(film);
        this.writeTicketOnFile(modelBooking.getSeats());
        viewBooking.refresh();
    }

    @Override
    public void buttonSelected(final SeatImpl seat, final ProgrammedFilm film) {
        modelBooking.buttonSelected(seat, film);
        viewBooking.refresh();
    }

    @Override
    public void newBooking() {
        modelBooking.newBooking();
    }

    @Override
    public Set<SeatImpl> getSeatsSelected() {
        return modelBooking.getSeatsSelected();
    }

    @Override
    public List<ProgrammedFilm> handlerProgrammedFilm(final Collection<ProgrammedFilm> coll, final Filter<ProgrammedFilm> filter) {
        final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>();
        List<ProgrammedFilm> listFilm = new ArrayList<>(coll);
        listFilm = handler.filterBy(listFilm, filter);
        return listFilm;
    }

    @Override
    public List<ProgrammedFilm> handlerProgrammedFilm(final Collection<ProgrammedFilm> coll, final Sorter<ProgrammedFilm> sorter) {
        final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>();
        List<ProgrammedFilm> listFilm = new ArrayList<>(coll);
        listFilm = handler.sortBy(listFilm, sorter);
        return listFilm;
    }

    @Override
    public Set<Ticket> getTicket() {
        return modelBooking.getSeats();
    }

    @Override
    public void deleteTicket(final Film film) {
        this.modelBooking.deleteTicket(film);
        this.writeTicketOnFile(modelBooking.getSeats());
    }

    @Override
    public void deleteTicket(final ProgrammedFilm programmedFilm) {
        this.modelBooking.deleteTicket(programmedFilm);
        this.writeTicketOnFile(modelBooking.getSeats());
    }

    @Override
    public void setCinemaController(final CinemaController observer) {
        this.observer = observer;
    }

    private void writeTicketOnFile(final Set<Ticket> set) {
        final Set<Ticket> setToWrite = set;
        final var type = new TypeToken<Set<Ticket>>() {
        }.getType();
        final RWobject<Set<Ticket>> rw = new RWobjectImpl<>(GeneralSettings.TICKET_FILE_PATH);
        rw.writeObj(setToWrite, type);
    }

    private Optional<Set<Ticket>> readTicketOnFile() {
        final RWobject<Set<Ticket>> rw = new RWobjectImpl<>(GeneralSettings.TICKET_FILE_PATH);
        final var type = new TypeToken<Set<Ticket>>() {
        }.getType();
        return rw.readObj(type);
    }

    private void showListFilmView() {
        final ListFilmView viewFilm = new ListFilmViewImpl(this);
        viewFilm.show();
        viewFilm.checkEmptyFilm();
    }

    private void showTimeTableView(final Set<ProgrammedFilm> setProgrammedFilm, final Film film) {
        final TimeTableView viewTimeTable = new TimeTableViewImpl(this, setProgrammedFilm, film);
        viewTimeTable.show();
        viewTimeTable.checkEmptyProgrammation(setProgrammedFilm);
    }

    private void showBookingView(final ProgrammedFilm film) {
        this.viewBooking = new BookingViewImpl(this, film);
        viewBooking.show();
    }
}
