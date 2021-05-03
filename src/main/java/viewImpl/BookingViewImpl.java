package viewImpl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.ProgrammedFilm;
import utilities.Row;
import utilities.Seat;
import view.BookingView;
import view.BookingViewObserver;
import view.GUIFactoryBooking;

public class BookingViewImpl implements BookingView {
    private final JFrame frame;
    private final BookingViewObserver observer;
    private static final String TITLE = "BookginView";
    private ProgrammedFilm film; 
    private Map<JButton,Seat<Row,Integer>> grid = new HashMap<>();
    
    
    public BookingViewImpl(BookingViewObserver observer, ProgrammedFilm film) {
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        this.film = film;
        this.frame = factory.getBaseFrame(TITLE);
        this.observer = observer;
        
        JPanel mainPanel = new JPanel(new BorderLayout()); 
        JPanel north = factory.getInfoPanel("Choose seats and book", e -> {
            observer.showTableView(film);
            frame.dispose();
            
        });
        Set<Seat<Row,Integer>> setSeats = observer.getSeatsFromFilm(film);
        Row row = Row.H;
        
        
        int col = 10;
        JPanel center = new JPanel(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(row.ordinal()+1, col) );
        
        for(int i = 0; i< row.ordinal()+1; i++) {
            for(int j = 0; j< col; j++) {
                JButton button = new JButton(i + "");
                grid.put(button, new Seat<Row,Integer>(Row.values()[i],j));
                gridPanel.add(button);
                
                
            }
        }
       
        center.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        JButton bookBt = new JButton("Book");
        
        frame.getContentPane().add(mainPanel);
        
    }
    
    @Override
    public void show() {
        frame.setVisible(true);
    }
    
    
}
