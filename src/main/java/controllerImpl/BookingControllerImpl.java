package controllerImpl;

import java.io.File;
import java.util.Set;

import controllerImpl.InputOutput.RW;
import model.BookingModel;
import modelImpl.BookingModelImpl;
import utilities.Ticket;

public class BookingControllerImpl {
    private BookingModel model;
    private final String FS = File.separator;
    private final String pathname = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "BookingFile.json";
   
    
    public BookingControllerImpl() {
        Set<Ticket> setTicket = RW.read(Ticket.class, pathname);
        model = new BookingModelImpl(setTicket);
        
    }
    public void showBookingView() {
        
    }
    public void showListFilmView() {
        
    }
    public void showTimeTableView() {
        
    }
    public void addTicket(Ticket ticket) {
        
    }
    
}
