package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;

import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.Sorter;
import modelImpl.ManageProgrammedFilms.FilterByDateImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import utilities.Factory.*;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import view.Booking.GUIFactoryBooking;
import view.Booking.TimeTableView;
import view.Booking.TimeTableViewObserver;
import viewImpl.ManageProgrammingFilms.factory.ProgrammingFilmsGUIfactoryImpl;

public class TimeTableViewImpl implements TimeTableView {
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGTH_PERC_FRAME = 0.5;
    private static final double WIDTH_MINIMUM_FRAME = WIDTH_PERC_FRAME /1;
    private static final double HEIGTH_MINMUM_FRAME = HEIGTH_PERC_FRAME / 0.9;
    
    private static final String TITLE = "Time Tabel Film";
    private static final String TEXT_BUTTON_SELECT = "Select";
    private static final String INFO_STRING = "Select a schedule from:";
    private static final String BTN_FILTER_STRING = "Apply";
    private static final String CHECKBOX_TITLE = "Order by:";
    private static final String CALENDAR_STRING = "Filter by date: ";
    private static final Color COLOR_STRING = Color.BLACK;
    
    private TimeTableViewObserver observer;
    private JFrame frame;
   
    
    public TimeTableViewImpl(TimeTableViewObserver observer, Set<ProgrammedFilm> setProgrammedFilm) {
        
        final String NAME = setProgrammedFilm.isEmpty() ? "No programmation for selected film" : "" + observer.getFilmByProgrammedFilm(setProgrammedFilm.stream().findAny().get()).getName();
        final GUIFactoryBooking factory = new GUIFactoryBookingImpl(); 
        this.observer = observer;
        this.frame = factory.getBaseFrame(TITLE);
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_MINIMUM_FRAME), (int) (screenSize.getHeight() * HEIGTH_MINMUM_FRAME)));

        JPanel north = factory.getInfoPanel(INFO_STRING + NAME, e -> {
            observer.showBackFromTimeTable();
            frame.dispose();
        });
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton bookBtn = new JButton(TEXT_BUTTON_SELECT);
        JTable table = factory.getTable(setProgrammedFilm);
      

       
        
        bookBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row!=-1) {
              
                LocalDate date = (LocalDate) table.getModel().getValueAt(row, 0);
                LocalTime time = (LocalTime) table.getModel().getValueAt(row, 1);
                int hall =  (int) table.getModel().getValueAt(row, 2);
                ProgrammedFilm film = setProgrammedFilm.stream()
                        .filter(f -> f.getStartTime().equals(time))
                        .filter(f -> f.getHall() == hall)
                        .filter(f-> f.getDate().equals(date))
                        .findAny().get();
                observer.bookTicketForFilm(film);
                frame.dispose();
            }else {
                this.notSelectedRow();
            }
        });
        final JScrollPane scroll = new JScrollPane(table);
        /*
         * filterPanel 
         */
        final JPanel filterPanel = new JPanel(new BorderLayout());
        final JPanel panelCalendar = new JPanel(new BorderLayout());
        final JPanel panelCheckBox = new JPanel(new BorderLayout());
        JButton filterBtn = new JButton(BTN_FILTER_STRING);
        /*
         * checkBoxGroup
         */
        ButtonGroup checkBoxGroup = new ButtonGroup();
        JCheckBox jcb1, jcb2;
        jcb1 = new JCheckBox("Data", false);
        jcb2 = new JCheckBox("Time", false);

        checkBoxGroup.add(jcb1);
        checkBoxGroup.add(jcb2);

        JPanel panelCheckBoxInternal = new JPanel();
        JLabel labelCheckBox = new JLabel(CHECKBOX_TITLE);
        labelCheckBox.setForeground(COLOR_STRING);
        panelCheckBox.add(labelCheckBox, BorderLayout.NORTH);
        panelCheckBoxInternal.add(jcb1);
        panelCheckBoxInternal.add(jcb2);

        panelCheckBox.add(panelCheckBoxInternal, BorderLayout.CENTER);

        final JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> {
           this.refresh(table, setProgrammedFilm);
        });

        final ProgrammingFilmsGUIfactoryImpl fctFilm = new ProgrammingFilmsGUIfactoryImpl();
        final Calendar calendar = fctFilm.createCalendar(); 
        panelCalendar.add(calendar, BorderLayout.CENTER);
        JLabel labelCalendar = new JLabel(CALENDAR_STRING);
        labelCalendar.setForeground(COLOR_STRING);
        panelCalendar.add(labelCalendar, BorderLayout.NORTH);

        filterPanel.add(panelCalendar, BorderLayout.NORTH);
        filterPanel.add(panelCheckBox, BorderLayout.CENTER);
        final JPanel panelButtonFilter = new JPanel();
        panelButtonFilter.add(filterBtn);
        panelButtonFilter.add(resetBtn);
        filterPanel.add(panelButtonFilter, BorderLayout.SOUTH);

        filterBtn.addActionListener(e -> {
          
            List<ProgrammedFilm> film = new ArrayList<>(setProgrammedFilm); 
            if (!calendar.getSelection().getRanges().isEmpty()) {
                final DateTime dataCalendar = calendar.getSelection().getRanges().get(0);
                LocalDate date = LocalDate.of(dataCalendar.getYear(), dataCalendar.getMonth(), dataCalendar.getDay());
                film = observer.handlerProgrammedFilm(film, new FilterByDateImpl(date));
            }
            if (jcb1.isSelected()) {
                film = observer.handlerProgrammedFilm(film, new SorterByLocalDate());
            }
            if (jcb2.isSelected()) {
                film = observer.handlerProgrammedFilm(film, new SorterByLocalTime());
            }
            this.refresh(table, film);
        });
        
        mainPanel.add(filterPanel, BorderLayout.WEST);
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(bookBtn, BorderLayout.SOUTH);
        frame.add(mainPanel);
        
    }
    
    @Override
    public void show() {
       frame.setVisible(true);
    }

    private void notSelectedRow() {
        JOptionPane.showMessageDialog(frame, "Not selected row", 
                "Incorrect Row", JOptionPane.ERROR_MESSAGE);
    }
    private void refresh(final JTable table, final Collection<ProgrammedFilm> list) {
        GUIFactoryBooking factory = new GUIFactoryBookingImpl(); 
        table.setModel(factory.getModel(list));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.fireTableDataChanged();
    }
}

