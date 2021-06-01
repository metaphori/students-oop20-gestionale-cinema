package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
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

import utilities.Factory.*;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import view.Booking.GUIFactoryBooking;
import view.Booking.TimeTableView;
import view.Booking.TimeTableViewObserver;
import viewImpl.ManageProgrammingFilms.factory.ProgrammingFilmsGUIfactoryImpl;

public class TimeTableViewImpl implements TimeTableView {
    private static final String TITLE = "Time Tabel Film";
    private static final String TEXT_BUTTON_SELECT = "Select";
    private static final String INFO_STRING = "Select a schedule from:";
   
    private TimeTableViewObserver observer;
    private JFrame frame;
   
    
    public TimeTableViewImpl(TimeTableViewObserver observer, Set<ProgrammedFilm> setProgrammedFilm) {
        
        String NAME = setProgrammedFilm.isEmpty() ? "No programmation for selected film" : "" + observer.getFilmByProgrammedFilm(setProgrammedFilm.stream().findAny().get()).getName();
        GUIFactoryBooking factory = new GUIFactoryBookingImpl(); 
        this.observer = observer;
        this.frame = factory.getBaseFrame(TITLE);
            
        JPanel north = factory.getInfoPanel(INFO_STRING + NAME, e -> {
            observer.showBackFromTimeTable();
            frame.dispose();
        });
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton bookBtn = new JButton(TEXT_BUTTON_SELECT);
        

       
        JTable table = factory.getTable(setProgrammedFilm);
        bookBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            System.out.println("RIGA SELECTED" + row);
            if(row!=-1) {
                LocalDate date = (LocalDate) table.getModel().getValueAt(row, 0);
                LocalTime time = (LocalTime) table.getModel().getValueAt(row, 1);
                int hall =  (int) table.getModel().getValueAt(row, 2);
                ProgrammedFilmFactory fP = new ProgrammedFilmFactoryImpl();
                ProgrammedFilm p1 = fP.creteProgrammedFilm(1, 1, 5.5, date, time,time) ;
                observer.bookTicketForFilm(p1);
                frame.dispose();
            }else {
                this.notSelectedRow();
            }
        });
        JScrollPane scroll = new JScrollPane(table);
        
     
    
        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            ProgrammedFilmFactory fP = new ProgrammedFilmFactoryImpl();
            ProgrammedFilm p1 = fP.creteProgrammedFilm(50, 11, 1.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
            setProgrammedFilm.add(p1);
            
            table.setModel(factory.getModel(setProgrammedFilm));
            DefaultTableModel m = (DefaultTableModel) table.getModel();
            m.fireTableDataChanged();
       
            
            
        });
        
        
        JPanel filterPanel = new JPanel(new BorderLayout()); 
        JPanel panelCheckBox = new JPanel(new FlowLayout());
        JButton filterBtn = new JButton("Filter");
        
        ButtonGroup checkBoxGroup = new ButtonGroup();
        JCheckBox jcb1, jcb2, jcb3;
        jcb1 = new JCheckBox("Data", false);
        jcb2 = new JCheckBox("Time", false);
        jcb3 = new JCheckBox("Australia", false);
        
        checkBoxGroup.add(jcb1);
        checkBoxGroup.add(jcb2);
        checkBoxGroup.add(jcb3);
        panelCheckBox.add(jcb1);
        panelCheckBox.add(jcb2);
        panelCheckBox.add(jcb3);
        ProgrammingFilmsGUIfactoryImpl fctFilm = new ProgrammingFilmsGUIfactoryImpl();
    
        Calendar calendar = fctFilm.createCalendar(); 
        filterPanel.add(calendar, BorderLayout.NORTH);
        filterPanel.add(panelCheckBox,BorderLayout.CENTER);
        filterPanel.add(filterBtn, BorderLayout.SOUTH);
        
        filterBtn.addActionListener(e -> {
            if(!calendar.getSelection().getRanges().isEmpty()) {
                DateTime dataCalendar= calendar.getSelection().getRanges().get(0);
                LocalDate date = LocalDate.of(dataCalendar.getYear(), dataCalendar.getMonth(), dataCalendar.getDay());
            }
         
        });
        
        mainPanel.add(filterPanel, BorderLayout.WEST);
        mainPanel.add(add,BorderLayout.EAST);
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
    
  
}

