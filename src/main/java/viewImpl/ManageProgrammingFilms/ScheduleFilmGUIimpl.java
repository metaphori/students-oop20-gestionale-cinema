package viewImpl.ManageProgrammingFilms;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import view.ManageProgrammingFilms.Factory.ScheduleFilmsFactory;
import viewImpl.ManageProgrammingFilms.factory.InfoProgrammationPanel;
import viewImpl.ManageProgrammingFilms.factory.ScheduleFilmsFactoryImpl;

public class ScheduleFilmGUIimpl implements ScheduleFilmsGUI {

	private static final long serialVersionUID = 1L;
	private DatePanel dateSelector;
	private TimePanel timeSelector;
	
	private final InfoProgrammationPanel infoProgrammation;
	private final JPanel bottomPanel;
	private final JFrame frame = new JFrame();
	private final Container container = frame.getContentPane();
	
	private final ScheduleFilmsFactory factory = new ScheduleFilmsFactoryImpl();
	
	private ProgrammingFilmsController observer ;

	public ScheduleFilmGUIimpl() {
	    
	    final JPanel mainPanel = new JPanel(new BorderLayout());
	    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    ArrayList <Integer> arr = new ArrayList<>();
	    arr.add(new Integer(1));
	    arr.add(new Integer(2));
	    arr.add(new Integer(3));
	    arr.add(new Integer(4));  
	    
	    bottomPanel = factory.getBottomPanel(new ScheduleButtonListener());
	    infoProgrammation = (InfoProgrammationPanel) factory.getInfoProgrammationPanel(arr);
		
	    mainPanel.add(infoProgrammation,BorderLayout.CENTER);
	    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
	    mainPanel.add(this.getDateAndTimePanel(),BorderLayout.NORTH);
			
	    container.add(mainPanel);
	
	    frame.setTitle("Schedule a film");
	    frame.pack();
	    frame.setSize(400, 500);
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}

	private JPanel getDateAndTimePanel() {
		// date and time panel selection
		JPanel dateTimePanel = new JPanel(new BorderLayout());
		dateTimePanel.setBorder(BorderFactory.createCompoundBorder(
								BorderFactory.createTitledBorder("Date and start time"),
									BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		dateSelector = new DatePanel(LocalDate.of(2021,1,5)); // year, month , day
		timeSelector = new TimePanel();
		dateTimePanel.add(dateSelector, BorderLayout.WEST);
		dateTimePanel.add(timeSelector, BorderLayout.EAST);
		
		return dateTimePanel;
	}


    @Override
    public void start() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);   
    }

    @Override
    public void setObserver(final ProgrammingFilmsController observer) {
        this.observer = observer;
    }

    @Override
    public void update() {
       
        
    }
    
    
    
    private class ScheduleButtonListener implements ActionListener {
        public void actionPerformed(final ActionEvent ae) {
            
           
                try {

                        // check if all required fields have been entered
                        if (infoProgrammation.getPrice().equals("") ) {
                                JOptionPane.showMessageDialog(frame,
                                                "You must enter all fields",
                                                "Invalid Data", JOptionPane.ERROR_MESSAGE);
                        } else {
                                final LocalDate date = dateSelector.getDate();
                                
                                System.out.println(infoProgrammation.getHall());
                                
                                JOptionPane.showMessageDialog(frame,"Film has been scheduled.");
                        }

                } catch (Exception e) {

                        JOptionPane.showMessageDialog(frame,e.getMessage(), "Invalid Data",JOptionPane.ERROR_MESSAGE);
                }
        }

}


    public static void main(String [] args) {
        ScheduleFilmGUIimpl s = new ScheduleFilmGUIimpl();
    }

}



