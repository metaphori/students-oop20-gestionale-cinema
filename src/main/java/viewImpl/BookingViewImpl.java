package viewImpl;

import javax.swing.JFrame;

import utilities.ProgrammedFilm;
import view.BookingView;
import view.BookingViewObserver;
import view.GUIFactoryBooking;

public class BookingViewImpl implements BookingView {
    private JFrame frame;
    private BookingViewObserver observer;
    private static final String TITLE = "BookginView";
    public BookingViewImpl(BookingViewObserver observer, ProgrammedFilm film) {
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        this.observer = observer;
        this.frame = factory.getBaseFrame(TITLE);
        
        
    }
    
    @Override
    public void show() {
        frame.setVisible(true);
    }
    
    
}
