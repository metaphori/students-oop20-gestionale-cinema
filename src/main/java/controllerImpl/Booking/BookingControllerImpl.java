package controllerImpl.Booking;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

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
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.SeatState;
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
    private  BookingModel model;
    private final String FS = File.separator;
    private final String pathname = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "BF.json";
    private ListFilmView viewFilm;
    private TimeTableView viewTimeTable;
    private BookingView viewBooking;
    
    private Set<Film> setFilm;
    private Set<ProgrammedFilm> setProgrammedFilm;
    
    public BookingControllerImpl() {


        RWobject<Set<Ticket>> rw = new RWobjectImpl(GeneralSettings.TICKET_FILE_PATH);
        final var type = new TypeToken<Set<Ticket>> () {}.getType();
       
        Optional<Set<Ticket>> OpSetTicket = rw.readObj(type);
        if(OpSetTicket.isEmpty()) {
            model = new BookingModelImpl(new HashSet<>());
        }else {
            model = new BookingModelImpl(OpSetTicket.get());
        }
        FilmsController controllerFilms = new FilmsControllerImpl();
        
        ProgrammingFilmsController controllerFilmProgrammed = new ProgrammingFilmsControllerImpl();
        
        setProgrammedFilm = new HashSet<>(controllerFilmProgrammed.getAllProgrammedFilms());
        setFilm = controllerFilms.getFilms();
  

        
    }
    public BookingControllerImpl(Set<Film> setF, Set<ProgrammedFilm> setP) {

        this.setFilm = setF;
        this.setProgrammedFilm = setP;

        RWobject<Set<Ticket>> rw = new RWobjectImpl(GeneralSettings.TICKET_FILE_PATH);
        final var type = new TypeToken<Set<Ticket>> () {}.getType();
       
        Optional<Set<Ticket>> opSetTicket = rw.readObj(type);
  
        if(opSetTicket.isEmpty()) {
            model = new BookingModelImpl(new HashSet<>());
        }else {
            model = new BookingModelImpl(opSetTicket.get());
        }
        Set<Ticket> setTicket = new HashSet<>();
        model = new BookingModelImpl(setTicket);

        
    }
    
    @Override
    public void start() {
        this.showListFilmView();
    }
    private void showListFilmView() {
          this.viewFilm = new ListFilmViewImpl(this);
          viewFilm.show();
          viewFilm.check();
    }
    private void showTimeTableView(Set<ProgrammedFilm> setProgrammedFilm) {
       this.viewTimeTable = new TimeTableViewImpl(this,setProgrammedFilm);
        viewTimeTable.show();
    } 
    
    private void showBookingView(ProgrammedFilm film) {
        this.viewBooking = new BookingViewImpl(this,film);
        viewBooking.show();
    }
    @Override
    public void selectedFilm(Film film) {
        //setP=this.getProgrammedFilm();
     
        Set<ProgrammedFilm> setFiltered= setProgrammedFilm.stream().filter(i -> i.getIdProgrammation() == film.getID()).collect(Collectors.toSet());
      //  Set<ProgrammedFilm> setProgrammedFilm = setP.stream().filter(i -> i.getIdProgrammation() == film.getID()).collect(Collectors.toSet());
        this.showTimeTableView(setFiltered);
  
    }
    public Set<ProgrammedFilm> getProgrammedFilm() {
        return new HashSet<ProgrammedFilm>();
    }
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Film> getFilm() {
        return setFilm;
    }

    @Override
    public void bookTicketForFilm(ProgrammedFilm film) {
        this.showBookingView(film);
        
    }
    @Override
    public Film getFilmByProgrammedFilm(ProgrammedFilm film) {
        return setFilm.stream().filter(f -> f.getID() == film.getIdProgrammation()).findAny().get();
    }
    @Override
    public void showBackFromTimeTable() {
        this.showListFilmView();
        
    }

    @Override
    public void showBackFromBooking(ProgrammedFilm film) {
        final Set<ProgrammedFilm> setPF= setProgrammedFilm.stream().filter(i -> i.getIdProgrammation() == film.getIdProgrammation()).collect(Collectors.toSet());
        this.showTimeTableView(setPF);
        
    }

    @Override
    public Set<SeatImpl<Row, Integer>> getSeatsFromFilm(final ProgrammedFilm film) {
        return this.model.getSeatsFromFilm(film);
       
    }

    @Override
    public void bookSeat(final ProgrammedFilm film) {
        model.bookSeat(film);
        Set<Ticket> set = model.getSeats();
        final var type = new TypeToken<Set<Ticket>>() {}.getType();
        RWobject rw = new RWobjectImpl(pathname);
        rw.writeObj(set,  type);
    }

    @Override
    public void buttonSelected(final SeatImpl<Row, Integer> seat, final ProgrammedFilm film) {
      model.buttonSelected(seat, film);
      
    }

    @Override
    public void newBooking() {
        model.newBooking();
    }

    @Override
    public Set<SeatImpl<Row, Integer>> getSeatsSelected() {
        return model.getSeatsSelected();
    }

    public List<ProgrammedFilm> handlerProgrammedFilm(final Collection<ProgrammedFilm> coll, final Filter<ProgrammedFilm> filter) {
        final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>();
        final List<ProgrammedFilm> listFilm = new ArrayList<>(coll);
        return handler.filterBy(listFilm, filter);
    }

    public List<ProgrammedFilm> handlerProgrammedFilm(final Collection<ProgrammedFilm> coll, final Sorter<ProgrammedFilm> sorter) {
        final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>();
        final List<ProgrammedFilm> listFilm = new ArrayList<>(coll);
        return handler.sortBy(listFilm, sorter);
    }

}
