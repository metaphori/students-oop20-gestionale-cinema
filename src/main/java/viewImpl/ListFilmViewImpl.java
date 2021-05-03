package viewImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import utilities.ProgrammedFilm;
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
    private Map<JButton, ProgrammedFilm> map;

    public ListFilmViewImpl(final ListFilmViewObserver observer) {
        this.observer = observer;
        map = new HashMap<>();
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        final JPanel mainPanel = new JPanel(new BorderLayout());
        
        final JPanel northPanel = factory.getInfoPanel("Choose film", e -> {
            observer.showMenu();
            frame.dispose();
        });
        final JPanel centralPanel = new JPanel(new WrapLayout());
        final JScrollPane scroller = new JScrollPane(centralPanel);
        final Set<ProgrammedFilm> setFilmProgrammed = observer.getFilmProgrammed();
      
        
        frame = factory.getBaseFrame(FRAME_NAME);
        frame.getContentPane().add(mainPanel);
      
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scroller, BorderLayout.CENTER);
       
        for (var elem : setFilmProgrammed) {
           // map.put(factory.getButtonImage(elem.getTitle, elem.getUrl), elem);
        }
        for (var bt : map.keySet()) {
            centralPanel.add(bt);
            
            bt.addActionListener(e -> {
                final JButton btn = (JButton) e.getSource(); 
               
                observer.selectedFilm(map.get(btn));
            });
        }

        
        
    }
    
 
    
    public void show() {
        frame.setVisible(true);
    }
}
