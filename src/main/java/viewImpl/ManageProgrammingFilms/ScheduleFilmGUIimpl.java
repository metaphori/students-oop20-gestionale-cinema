package viewImpl.ManageProgrammingFilms;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.Factory.FilmFactory;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import view.ManageProgrammingFilms.ScheduleFilmsGUI;
import view.ManageProgrammingFilms.Factory.ScheduleFilmsFactory;
import viewImpl.ManageProgrammingFilms.factory.DatePanel;
import viewImpl.ManageProgrammingFilms.factory.InfoProgrammationPanel;
import viewImpl.ManageProgrammingFilms.factory.ScheduleFilmsFactoryImpl;
import viewImpl.ManageProgrammingFilms.factory.TimePanel;

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
	private final FilmsController filmsController ;

	public ScheduleFilmGUIimpl() {
	    
	    final JPanel mainPanel = new JPanel(new BorderLayout());
	    final JPanel dateTimePanel = new JPanel(new BorderLayout());
	    
	    
	    //TEST init controller
	    FilmFactory filmFactory = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
	    filmsController = new FilmsControllerImpl();
	    filmsController.addFilm(filmFactory.createBasicFilm("Spiderman", "", "", Optional.ofNullable(null), 40));
	    filmsController.addFilm(filmFactory.createBasicFilm("Batman", "", "", Optional.ofNullable(null), 40));
	    filmsController.addFilm(filmFactory.createBasicFilm("Thor", "", "", Optional.ofNullable(null), 40));
	    
	   
	    
	    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	    
	    
	    bottomPanel = factory.getBottomPanel(new ScheduleButtonListener());
	    infoProgrammation =  factory.getInfoProgrammationPanel(filmsController);
		
	    mainPanel.add(infoProgrammation,BorderLayout.CENTER);
	    mainPanel.add(bottomPanel,BorderLayout.SOUTH);
	    
	    
            dateTimePanel.setBorder(BorderFactory.createCompoundBorder(
                                                            BorderFactory.createTitledBorder("Date and start time"),
                                                                    BorderFactory.createEmptyBorder(20, 20, 20, 20)));
            dateSelector = factory.getDatePanel(); // year, month , day
            timeSelector = factory.getTimePanel();
            
            dateTimePanel.add(dateSelector, BorderLayout.WEST);
            dateTimePanel.add(timeSelector, BorderLayout.EAST);
	     
	    
	    mainPanel.add(dateTimePanel,BorderLayout.NORTH);
			
	    container.add(mainPanel);
	
	    frame.setTitle("Schedule a film");
	    frame.pack();
	    frame.setSize(400, 500);
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
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
                        
                        final LocalDate selectedDate = dateSelector.getDate();
                        final LocalTime selectedTime = timeSelector.getTime();
                        final int selectedHall =  Integer.parseInt(infoProgrammation.getHall());
                        final double selectedPrice = Double.parseDouble(infoProgrammation.getPrice());
                        final Film selectedFilm = infoProgrammation.getSelectedFilm();
                        
                        
                                
                        JOptionPane.showMessageDialog(frame,"Film has been scheduled.");
                } catch (Exception e) {

                        JOptionPane.showMessageDialog(frame,e.getMessage(), "Invalid Data",JOptionPane.ERROR_MESSAGE);
                }
        }

    }

    

    
    
    

    public static void main(String [] args) {
        ScheduleFilmGUIimpl s = new ScheduleFilmGUIimpl();
    }

}



