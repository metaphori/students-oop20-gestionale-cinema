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
<<<<<<< HEAD
import controllerImpl.InputOutput.RWobject;
import controllerImpl.InputOutput.RWobjectImpl;
=======
>>>>>>> master
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
    
    Set<Film> setF;
    Set<ProgrammedFilm> setP;
    
    public BookingControllerImpl() {

<<<<<<< HEAD
        RWobject<Set<Ticket>> rw = new RWobjectImpl(pathname);
        final var type = new TypeToken<Set<Ticket>> () {}.getType();
       
        Optional<Set<Ticket>> OpSetTicket = rw.readObj(type);
        if(OpSetTicket.isEmpty()) {
            model = new BookingModelImpl(new HashSet<>());
        }else {
            model = new BookingModelImpl(OpSetTicket.get());
        }
     
        //model = new BookingModelImpl(RW.read(Ticket.class, pathname));

        
    }
    public BookingControllerImpl(Set<Film> setF, Set<ProgrammedFilm> setP) {

        this.setF = setF;
        this.setP = setP;

        RWobject<Set<Ticket>> rw = new RWobjectImpl(pathname);
        final var type = new TypeToken<Set<Ticket>> () {}.getType();
       
        Optional<Set<Ticket>> OpSetTicket = rw.readObj(type);
        System.out.println("LETTURA:   "  + OpSetTicket);
        if(OpSetTicket.isEmpty()) {
            System.out.println("LETTURA:   "  + OpSetTicket);
            model = new BookingModelImpl(new HashSet<>());
        }else {
            model = new BookingModelImpl(OpSetTicket.get());
        }
=======
        //RWcollection<Ticket> rw = new RWfile(pathname);
        //rw.readCollection(Ticket.class)
        Set<Ticket> setTicket = new HashSet<>();
        model = new BookingModelImpl(setTicket);
>>>>>>> master
        //model = new BookingModelImpl(RW.read(Ticket.class, pathname));

        
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
        Set<ProgrammedFilm> setProgrammedFilm = setP.stream().filter(i -> i.getIdProgrammation() == film.getID()).collect(Collectors.toSet());
        this.showTimeTableView(setProgrammedFilm);
  
    }
    public Set<ProgrammedFilm> getProgrammedFilm() {
        return new HashSet<ProgrammedFilm>();
    }
    public void test() {
       // ProgrammedFilmFactory f = new 
        //this.showBookingView(new ProgrammedFilm());
    }
    public void addTicket(Ticket ticket) {
        
    }
    @Override
    public void getSpecifiedBooking() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    
    
    @Override
    public Set<Film> getFilm() {
      //  Set<Film> film = new HashSet<>();
        
        //return film;
        return setF;
    }


    @Override
    public void bookTicketForFilm(ProgrammedFilm film) {
        this.showBookingView(film);
        
    }
    @Override
    public Film getFilmByProgrammedFilm(ProgrammedFilm film) {
        return setF.stream().filter(f -> f.getID() == film.getIdProgrammation()).findAny().get();
    }
    @Override
    public void showBackFromTimeTable() {
        this.showListFilmView();
        
    }

    @Override
    public void showBackFromBooking(ProgrammedFilm film) {
        final Set<ProgrammedFilm> setProgrammedFilm = setP.stream().filter(i -> i.getIdProgrammation() == film.getIdProgrammation()).collect(Collectors.toSet());
        this.showTimeTableView(setProgrammedFilm);
        
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
