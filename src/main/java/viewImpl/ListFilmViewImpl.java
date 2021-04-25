package viewImpl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GUIFactoryBooking;
import view.ListFilmView;
import view.ListFilmViewObserver;

public class ListFilmViewImpl implements ListFilmView{
    //private BookingViewObserver observer;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String FRAME_NAME = "ListFilm"; 
    private ListFilmViewObserver observer;
    private JFrame frame;
    
    public ListFilmViewImpl() {
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton homeBt = new JButton("home");
        frame = factory.getBaseFrame(FRAME_NAME);
        frame.getContentPane().add(mainPanel);
        
        mainPanel.add(northPanel,BorderLayout.NORTH);
        northPanel.add(homeBt);
        
    }
    public void setObserver(ListFilmViewObserver observer) {
        this.observer=observer;
    }
    
    
    public void show() {
        frame.setVisible(true);
    }
}
