package controllerImpl;

import java.io.File;
import java.util.Set;

import controller.BookingController;
import controllerImpl.InputOutput.RW;
import model.BookingModel;
import modelImpl.BookingModelImpl;
import utilities.ProgrammedFilm;
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
  
    public void showListFilmView() {
          final ListFilmView viewFilm = new ListFilmViewImpl(this);
          
          viewFilm.show();
    }
    public void showTimeTableView() {
       // final TimeTableView viewTime = new TimeTalbleViewImpl();
    } 
    public void showBookingView() {
      
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
    public void selectedFilm(ProgrammedFilm film) {
        // TODO Auto-generated method stub
        
    }
    
}
