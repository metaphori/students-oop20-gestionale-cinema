package viewImpl.Booking;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import utilities.Factory.*;
import view.Booking.GUIFactoryBooking;
import view.Booking.TimeTableView;
import view.Booking.TimeTableViewObserver;

public class TimeTableViewImpl implements TimeTableView {
    private static final String TITLE = "Time Tabel Film";
    private static final String TEXT_BUTTON_SELECT = "Select";
    private static final String INFO_STRING = "Select a film";
    private TimeTableViewObserver observer;
    private JFrame frame;
    
    
    
    public TimeTableViewImpl(TimeTableViewObserver observer, Set<ProgrammedFilm> setProgrammedFilm) {
        GUIFactoryBooking factory = new GUIFactoryBookingImpl(); 
        this.observer = observer;
        this.frame = factory.getBaseFrame(TITLE);
        
        JPanel north = factory.getInfoPanel(INFO_STRING, e -> {
            observer.showBackFromTimeTable();
            frame.dispose();
        });
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton bookBt = new JButton(TEXT_BUTTON_SELECT);
        

       
        JTable table = factory.getTable(setProgrammedFilm);
        bookBt.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row!=-1) {
                LocalDate date = (LocalDate) table.getModel().getValueAt(row, 0);
                LocalTime time = (LocalTime) table.getModel().getValueAt(row, 1);
                String hall =  (String) table.getModel().getValueAt(row, 2);
                //observer.bookTicketForFilm(new ProgrammedFilm());
            }else {
                this.notSelectedRow();
            }
        });
        
        
        
        JScrollPane scroll = new JScrollPane(table);
      
        
      
    
        mainPanel.add(north, BorderLayout.NORTH);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(bookBt, BorderLayout.SOUTH);
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

