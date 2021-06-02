package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import utilities.Film;
import utilities.Factory.*;
import view.Booking.GUIFactoryBooking;
import view.Booking.ListFilmView;
import view.Booking.ListFilmViewObserver;
import view.ManageFilms.Factory.PanelFilmFactory;
import viewImpl.ManageFilms.Factory.PanelFilmFactoryImpl;

public class ListFilmViewImpl implements ListFilmView{

    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGHT_PERC_FRAME = 0.5;
    private static final double WIDTH_IMAGE_COVER = WIDTH_PERC_FRAME / 5;
    private static final double HEIGHT_IMAGE_COVER = HEIGHT_PERC_FRAME / 2;
    private static final String FS = File.separator;
    private static final String PATH = System.getProperty("user.home") +  FS + "OOPcinemaFile" + FS + "aquaman.jpg"; 
    private static final long serialVersionUID = 1L;
    private static final String FRAME_NAME = "ListFilm"; 
    private static final String INFO_STRING = "Choose film";
    private ListFilmViewObserver observer;
    private final JFrame frame;
    private final Map<JButton, Film> map = new HashMap<>();

    public ListFilmViewImpl(final ListFilmViewObserver observer) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.observer = observer;
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        final PanelFilmFactory factoryPanel = new PanelFilmFactoryImpl();
        final JPanel mainPanel = new JPanel(new BorderLayout());
        frame = factory.getBaseFrame(FRAME_NAME);
        final JPanel northPanel = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showMenu();
            frame.dispose();
        }); 
        final Set<Film> setFilm = observer.getFilm();
        final JPanel centralPanel = factoryPanel.getFilmPanel(map, setFilm);
        final JScrollPane scroller = new JScrollPane(centralPanel);
        frame.getContentPane().add(mainPanel);
        frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_IMAGE_COVER), (int) (screenSize.getHeight() * HEIGHT_IMAGE_COVER)));
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(scroller, BorderLayout.CENTER);
        for (final var bt : map.keySet()) {
            bt.addActionListener(e -> {
               final JButton btn = (JButton) e.getSource();
               observer.selectedFilm(map.get(btn));
               frame.dispose();
            });
        }
    }
    public void show() {
        frame.setVisible(true);
    }
}
