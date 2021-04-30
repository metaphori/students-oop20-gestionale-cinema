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
import utilities.Ticket;
import view.ListFilmView;
import view.ListFilmViewObserver;
import view.TimeTableView;
import view.TimeTableViewObserver;
import viewImpl.ListFilmViewImpl;
import viewImpl.TimeTableViewImpl;

public class BookingControllerImpl implements BookingController, ListFilmViewObserver, TimeTableViewObserver {
    private final BookingModel model;
    private final String FS = File.separator;
    private final String pathname = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "BookingFile.json";
    
    
    public BookingControllerImpl() {
      
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
    private void showTimeTableView(ProgrammedFilm film) {
        final TimeTableView viewTimeTable = new TimeTableViewImpl(this,new HashSet<>());
        viewTimeTable.show();
    } 
    private void showBookingView() {
       // final BookingView viewBokking = new BookingVIewImpl();
    }
    @Override
    public void selectedFilm(ProgrammedFilm film) {
        this.showTimeTableView(film);
  
    }
    public void test() {
        this.showTimeTableView(new ProgrammedFilm());
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
    public Set<ProgrammedFilm> getFilmProgrammed() {
        
        return null;
    }


    @Override
    public void bookTicketForFilm(ProgrammedFilm film) {
        
        
    }


 
   
    
}
