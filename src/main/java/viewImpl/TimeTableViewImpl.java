package viewImpl;

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

import utilities.ProgrammedFilm;
import view.GUIFactoryBooking;
import view.TimeTableView;
import view.TimeTableViewObserver;

public class TimeTableViewImpl implements TimeTableView {
    private static final String TITLE = "Time Tabel Film";
    private TimeTableViewObserver observer;
    private JFrame frame;
    
    
    
    public TimeTableViewImpl(TimeTableViewObserver observer, Set<ProgrammedFilm> setProgrammedFilm) {
        GUIFactoryBooking factory = new GUIFactoryBookingImpl();
        JPanel north = factory.getInfoPanel("Select a film");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton bookBt = new JButton("Booking");
        

       
        JTable table = factory.getTable(setProgrammedFilm);
        bookBt.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row!=-1) {
                LocalDate date = (LocalDate) table.getModel().getValueAt(row, 0);
                LocalTime time = (LocalTime) table.getModel().getValueAt(row, 1);
                String hall =  (String) table.getModel().getValueAt(row, 2);
                observer.bookTicketForFilm(new ProgrammedFilm());
            }else {
                this.notSelectedRow();
            }
        });
        
        
        
        JScrollPane scroll = new JScrollPane(table);
      
        
        this.observer = observer;
        this.frame = factory.getBaseFrame(TITLE);
        
        JButton backBt = new JButton("Back");
        backBt.addActionListener(e -> {
            observer.showListView();
            frame.dispose();
        });
        north.add(backBt, BorderLayout.WEST);
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

