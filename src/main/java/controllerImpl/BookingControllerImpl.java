package controllerImpl;

import java.io.File;
import java.util.Set;

import controller.BookingController;
import controllerImpl.InputOutput.RW;
import model.BookingModel;
import modelImpl.BookingModelImpl;
import utilities.Ticket;
import view.ListFilmView;
import view.ListFilmViewObserver;
import viewImpl.ListFilmViewImpl;

public class BookingControllerImpl implements BookingController,ListFilmViewObserver{
    private final BookingModel model;
    private final String FS = File.separator;
    private final String pathname = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "BookingFile.json";
    
    
    public BookingControllerImpl() {
      
        model = new BookingModelImpl(RW.read(Ticket.class, pathname));
        
    }
    public void showBookingView() {
      
    }
    public void showListFilmView() {
          ListFilmView viewFilm = new ListFilmViewImpl();
          viewFilm.setObserver(this);
          viewFilm.show();
    }
    public void showTimeTableView() {
        
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
    
}
