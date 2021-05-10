package controllerImpl;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import controller.BookingController;
import controllerImpl.InputOutput.RW;
import model.BookingModel;
import modelImpl.BookingModelImpl;
import utilities.Film;
import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import utilities.Ticket;
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
    private final BookingModel model;
    private final String FS = File.separator;
    private final String pathname = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "BookingFile.json";
    Set<Seat<Row,Integer>> seatSelected;
    
    public BookingControllerImpl() {
        seatSelected = new HashSet<>();
        model = new BookingModelImpl(RW.read(Ticket.class, pathname));
        
    }
    
    @Override
    public void start() {
        this.showListFilmView();
    }
    private void showListFilmView() {
          final ListFilmView viewFilm = new ListFilmViewImpl(this);
          viewFilm.show();
    }
    private void showTimeTableView(Film film) {
        final TimeTableView viewTimeTable = new TimeTableViewImpl(this,new HashSet<>());
        viewTimeTable.show();
    } 
    
    private void showBookingView(ProgrammedFilm film) {
        final BookingView viewBooking = new BookingViewImpl(this,film);
        viewBooking.show();
    }
    @Override
    public void selectedFilm(Film film) {
        this.showTimeTableView(film);
  
    }
    public void test() {
        this.showBookingView(new ProgrammedFilm());
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
        Set<Film> film = new HashSet<>();
        return film;
    }


    @Override
    public void bookTicketForFilm(ProgrammedFilm film) {
        this.showBookingView(film);
        
    }

    @Override
    public void showBackFromTimeTable() {
        this.showListFilmView();
        
    }

    @Override
    public void showBackFromBooking(ProgrammedFilm film) {
        Film film1 = new Film();
       this.showTimeTableView(film1);
        
    }

    @Override
    public Set<Seat<Row, Integer>> getSeatsFromFilm(ProgrammedFilm film) {
        return this.model.getSeatsFromFilm(film);
       
    }

    @Override
    public void bookSeat() {
        // TODO Auto-generated method stub
        
    }




 
   
    
}
