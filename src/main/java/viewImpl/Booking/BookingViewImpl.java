package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import utilities.SeatState;
import view.Booking.BookingView;
import view.Booking.BookingViewObserver;
import view.Booking.GUIFactoryBooking;

public class BookingViewImpl implements BookingView {
    private final JFrame frame;
    private final BookingViewObserver observer;
    private static final String TITLE = "BookginView";
    private static final String INFO_STRING = "Choose seats and book";
    private static final String STRING_BTN_BOOK = "Book"; 
    private ProgrammedFilm film; 
    private Map<JButton,Seat<Row,Integer>> grid = new HashMap<>();
    
    private static final String FS = File.separator;
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGHT_PERC_FRAME = 0.5;
   
    private static final String pathSeatTaken = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatTaken.png";
    private static final String pathSeatFree = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatFree.png";
    private static final String pathSeatSelected = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatSelected.png";
    private static final double WIDTH_IMAGE_SEAT = WIDTH_PERC_FRAME / 15;
    private static final double HEIGHT_IMAGE_SEAT = HEIGHT_PERC_FRAME/ 15;
    
    public BookingViewImpl(BookingViewObserver observer, ProgrammedFilm film) {
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        this.film = film;
        this.frame = factory.getBaseFrame(TITLE);
        this.observer = observer;
        
        JPanel mainPanel = new JPanel(new BorderLayout()); 
        JPanel north = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showBackFromBooking(film);
            frame.dispose();
            
        });
        Set<Seat<Row,Integer>> setSeats = observer.getSeatsFromFilm(film);
        Row row = Row.H;
        
        
        int col = 10;
        JPanel center = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(row.ordinal()+1, col) );
        
        for(int i = 0; i< row.ordinal()+1; i++) {
            for(int j = 0; j< col; j++) {
                
                JButton button = factory.getButtonSeat(SeatState.FREE, i, j);
                grid.put(button, new Seat<Row,Integer>(Row.values()[i],j));
                gridPanel.add(button);
                
                
            }
        }
        JButton bookBt = new JButton(STRING_BTN_BOOK);
        bookBt.addActionListener(e -> {
            
            observer.bookSeat();
        });
        center.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(bookBt, BorderLayout.SOUTH);
       
        
        frame.getContentPane().add(mainPanel);
        
    }
    
    @Override
    public void show() {
        frame.setVisible(true);
    }
    
    
}
