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

import utilities.Film;
import utilities.ProgrammedFilm;
import view.GUIFactoryBooking;
import view.ListFilmView;
import view.ListFilmViewObserver;
import view.PanelFilmFactory;

public class ListFilmViewImpl implements ListFilmView{
    //private BookingViewObserver observer;
    
    /**
     * 
     */
  
    private static final String FS = File.separator;
    private static final String PATH = System.getProperty("user.home") +  FS + "OOPcinemaFile" + FS + "aquaman.jpg"; 
    private static final long serialVersionUID = 1L;
    private static final String FRAME_NAME = "ListFilm"; 
    private static final String INFO_STRING = "Choose film";
    private ListFilmViewObserver observer;
    private JFrame frame;
    private Map<JButton, Film> map;

    public ListFilmViewImpl(final ListFilmViewObserver observer) {
        this.observer = observer;
        map = new HashMap<>();
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        final PanelFilmFactory factoryPanel = new PanelFilmFactoryImpl();
        final JPanel mainPanel = new JPanel(new BorderLayout());
        
        final JPanel northPanel = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showMenu();
            frame.dispose();
        }); 
        final Set<Film> setFilm = observer.getFilm();
        final JPanel centralPanel = factoryPanel.getFilmPanel(map, setFilm);
        final JScrollPane scroller = new JScrollPane(centralPanel);
       
      
        
        frame = factory.getBaseFrame(FRAME_NAME);
        frame.getContentPane().add(mainPanel);
      
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scroller, BorderLayout.CENTER);
        
        
        for (var bt : map.keySet()) {
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
