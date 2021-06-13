package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

public class ListFilmViewImpl implements ListFilmView {

    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGTH_PERC_FRAME = 0.5;
    private static final double WIDTH_MINIMUM_FRAME = WIDTH_PERC_FRAME / 3;
    private static final double HEIGTH_MINMUM_FRAME = HEIGTH_PERC_FRAME / 1;
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
        frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_MINIMUM_FRAME), (int) (screenSize.getHeight() * HEIGTH_MINMUM_FRAME)));
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

    @Override
    public void show() {
        frame.setVisible(true);
    }
    @Override
    public void checkEmptyFilm() {
        if (map.values().isEmpty()) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(frame, "there aren't any film", "No film", JOptionPane.ERROR_MESSAGE);
                }
            });

        }
    }
 
}
