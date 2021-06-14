package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import utilities.Factory.*;
import utilitiesImpl.GeneralSettings;
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
    private static final String STRING_SCREEN_LABEL = "SCREEN"; 
    private final ProgrammedFilm film; 
    private final Map<JButton, SeatImpl> grid = new HashMap<>();
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGTH_PERC_FRAME = 0.5;

    private static final double WIDTH_IMAGE_SEAT = WIDTH_PERC_FRAME / 15;
    private static final double HEIGHT_IMAGE_SEAT = HEIGTH_PERC_FRAME / 15;
    private static final double HEIGHT_IMAGE_LEGEND = HEIGTH_PERC_FRAME / 5;
    private static final double WIDTH_IMAGE_LEGEND = WIDTH_PERC_FRAME / 5;

    private static final double WIDTH_MINIMUM_FRAME = WIDTH_PERC_FRAME / 0.7;
    private static final double HEIGTH_MINMUM_FRAME = HEIGTH_PERC_FRAME / 0.7;

    private final int col;
    private final Row row;
    public BookingViewImpl(final BookingViewObserver observer, final ProgrammedFilm film) {

        final GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        this.film = film;
        this.frame = factory.getBaseFrame(TITLE);
        this.observer = observer;


        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_MINIMUM_FRAME), (int) (screenSize.getHeight() * HEIGTH_MINMUM_FRAME)));

        observer.newBooking();
        final JPanel mainPanel = new JPanel(new BorderLayout()); 
        final JPanel north = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showBackFromBooking(film);
            frame.dispose();
        });
        final Set<SeatImpl> setSeats = observer.getSeatsFromFilm(film);
        row = Row.Z;
        col = 10;
        final JPanel center = new JPanel(new BorderLayout());
        final JPanel gridPanel = new JPanel(new GridLayout(row.ordinal() + 1, col));
        for (int i = 0; i < row.ordinal() + 1; i++) {
            for (int j = 0; j < col; j++) {
                SeatState state;
                if (setSeats.contains(new SeatImpl(Row.values()[i], j))) {
                    state  = SeatState.TAKEN;
                } else {
                    state = SeatState.FREE;
                }
                final JButton button = factory.getButtonSeat(state, i, j);
                grid.put(button, new SeatImpl(Row.values()[i], j));
                gridPanel.add(button);
            }
        }
        grid.keySet().forEach(btn -> {
            btn.addActionListener(e -> {
                final JButton button = (JButton) e.getSource();
                observer.buttonSelected(grid.get(button), film);
                this.refresh();
            });
        });
        final JButton bookBt = new JButton(STRING_BTN_BOOK);
        bookBt.addActionListener(e -> {
            if (observer.getSeatsSelected().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No selected seaet");
            } else {
                observer.bookSeat(film);
                this.refresh();
                observer.newBooking();
            }
        });
        final JLabel label = new JLabel(STRING_SCREEN_LABEL);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        center.add(label, BorderLayout.NORTH);
        center.add(new JScrollPane(gridPanel), BorderLayout.CENTER);
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(center, BorderLayout.CENTER);
        mainPanel.add(bookBt, BorderLayout.SOUTH);

        final ImageIcon imageLegend = new ImageIcon(ClassLoader.getSystemResource(GeneralSettings.IMAGE_LEGEND));
        final int width = (int) (screenSize.getWidth() * WIDTH_IMAGE_LEGEND);
        final int height = (int) (screenSize.getHeight() * HEIGHT_IMAGE_LEGEND);
        final JLabel labelLegend = factory.getLabelImage(imageLegend, width, height);
        mainPanel.add(labelLegend, BorderLayout.EAST);
        frame.getContentPane().add(mainPanel);
    }
    @Override
    public void show() {
        frame.setVisible(true);
    }
    
    @Override
    public void refresh() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Set<SeatImpl> setSeatsTaken = observer.getSeatsFromFilm(film);
        final Set<SeatImpl> setSeatsSelected = observer.getSeatsSelected();
        for (final var bt : grid.keySet()) {
            ImageIcon imageIcon;
            if (setSeatsTaken.contains(grid.get(bt))) {
                imageIcon = new ImageIcon(ClassLoader.getSystemResource(GeneralSettings.IMAGE_SEAT_TAKEN));
            } else if (setSeatsSelected.contains(grid.get(bt))) {
                imageIcon =  new ImageIcon(ClassLoader.getSystemResource(GeneralSettings.IMAGE_SEAT_SELECTED));
            } else {
                imageIcon = new ImageIcon(ClassLoader.getSystemResource(GeneralSettings.IMAGE_SEAT_FREE));
            }
            final Image image = imageIcon.getImage(); // transform it 
            final Image newimg = image.getScaledInstance((int) (screenSize.getWidth() * WIDTH_IMAGE_SEAT), (int) (screenSize.getHeight() * HEIGHT_IMAGE_SEAT), java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);  // transform it back
            bt.setIcon(imageIcon);
        }
    }
}
