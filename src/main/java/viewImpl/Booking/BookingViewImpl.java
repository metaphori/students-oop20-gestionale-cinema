package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.Factory.*;
import utilitiesImpl.Row;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.SeatState;
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
    private Map<JButton,SeatImpl<Row,Integer>> grid = new HashMap<>();
    
    private static final String FS = File.separator;
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGHT_PERC_FRAME = 0.5;
   
    private static final String pathSeatTaken = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatTaken.png";
    private static final String pathSeatFree = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatFree.png";
    private static final String pathSeatSelected = System.getProperty("user.home") + FS + "OOPcinemaFile" + FS + "imageSeatSelected.png";
    private static final double WIDTH_IMAGE_SEAT = WIDTH_PERC_FRAME / 15;
    private static final double HEIGHT_IMAGE_SEAT = HEIGHT_PERC_FRAME/ 15;
    
    private int col;
    private Row row;
    public BookingViewImpl(BookingViewObserver observer, ProgrammedFilm film) {
        System.out.println("Film" + film);
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        this.film = film;
        this.frame = factory.getBaseFrame(TITLE);
        this.observer = observer;
        observer.newBooking();
        JPanel mainPanel = new JPanel(new BorderLayout()); 
        JPanel north = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showBackFromBooking(film);
            frame.dispose();
            
        });
        Set<SeatImpl<Row,Integer>> setSeats = observer.getSeatsFromFilm(film);
        row = Row.H;
        System.out.print("AfterGet" + setSeats);
        col = 10;
        JPanel center = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(row.ordinal()+1, col) );
        
        for(int i = 0; i< row.ordinal()+1; i++) {
            for(int j = 0; j< col; j++) {
                SeatState state;
                if(setSeats.contains(new SeatImpl<Row,Integer>(Row.values()[i],j))){
                    state  = SeatState.TAKEN;
                }else {
                    state = SeatState.FREE;
                }
                JButton button = factory.getButtonSeat(state, i, j);
                grid.put(button, new SeatImpl<Row,Integer>(Row.values()[i],j));
                gridPanel.add(button);
            }
        }
        grid.keySet().forEach(btn -> {
            btn.addActionListener( e ->{
                JButton button = (JButton) e.getSource();
                observer.buttonSelected(grid.get(button),film);
                this.refresh();
            });
        });
        JButton bookBt = new JButton(STRING_BTN_BOOK);
        bookBt.addActionListener(e -> {
            
            observer.bookSeat(film);
            this.refresh();
            observer.newBooking();
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

    @Override
    public void refresh() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Set<SeatImpl<Row,Integer>> setSeatsTaken = observer.getSeatsFromFilm(film);
        Set<SeatImpl<Row,Integer>> setSeatsSelected = observer.getSeatsSelected();
        
        final URL urlTaken = ClassLoader.getSystemResource("images/imageSeatTaken.png");
        final URL urlSelected = ClassLoader.getSystemResource("images/imageSeatSelected.png");
        final URL urlFree = ClassLoader.getSystemResource("images/imageSeatFree.png");
                        
              for(var bt : grid.keySet()) {       
                    ImageIcon imageIcon;
                     if(setSeatsTaken.contains(grid.get(bt))){
                        imageIcon = new ImageIcon(urlTaken);
                     }else if (setSeatsSelected.contains(grid.get(bt))) {
                         imageIcon =  new ImageIcon(urlSelected);
                     }else {
                         imageIcon = new ImageIcon(urlFree);
                     }
                     Image image = imageIcon.getImage(); // transform it 
                     Image newimg = image.getScaledInstance((int) (screenSize.getWidth() * WIDTH_IMAGE_SEAT), (int) (screenSize.getHeight() * HEIGHT_IMAGE_SEAT),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                     imageIcon = new ImageIcon(newimg);  // transform it back
                   bt.setIcon(imageIcon);
                     
              }  
                
                
            
        
    }
    
    
}
