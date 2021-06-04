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
import exceptions.ProgrammationNotAvailableException;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilities.Factory.TimeSlotFactory;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotFactoryImpl;
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
	
	protected ProgrammingFilmsController observer ;
	private FilmsController filmsController ;

	public ScheduleFilmGUIimpl(final FilmsController filmsController) {
	    
	    this.filmsController = filmsController;
	    final JPanel mainPanel = new JPanel(new BorderLayout());
	    final JPanel dateTimePanel = new JPanel(new BorderLayout());
	   
	    
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
		
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	}

    @Override
    public void start() {
        //frame.setLocationByPlatform(true);
        this.update();
        frame.setVisible(true);   
    }

    @Override
    public void setObserver(final ProgrammingFilmsController observer) {
        this.observer = observer;
    }

    @Override
    public void update() {
        //devo aggiornare la lista dei film e la lista delle
        infoProgrammation.update();
    }
    
    
    
    private class ScheduleButtonListener implements ActionListener {
        
        
        final private ProgrammedFilmFactory programmedFilmFactory = new ProgrammedFilmFactoryImpl();
       

        public void actionPerformed(final ActionEvent ae) {
            Film selectedFilm;
            LocalDate selectedDate;
            LocalTime selectedTime;
            int selectedHall;
            double selectedPrice;
            
            try {
                    selectedDate = dateSelector.getDate();
                    selectedTime = timeSelector.getTime();
                    selectedHall =  Integer.parseInt(infoProgrammation.getHall());
                    selectedPrice = Double.parseDouble(infoProgrammation.getPrice());
                    selectedFilm = infoProgrammation.getSelectedFilm();
                    
                    try {     
                        
                        final ProgrammedFilm film = programmedFilmFactory.createProgrammedFilm(selectedFilm.getID(), selectedHall, selectedPrice, selectedDate, selectedTime, selectedTime.plusMinutes(selectedFilm.getDuration()));
                        observer.addProgrammedFilm(film);
                        JOptionPane.showMessageDialog(frame,"Film has been scheduled.");
                    } catch (final ProgrammationNotAvailableException e) {
                        JOptionPane.showMessageDialog(frame,e.getMessage(), "Film not scheduled",JOptionPane.ERROR_MESSAGE);
                    }
                   
             } catch (final Exception e) {
                    JOptionPane.showMessageDialog(frame,e.getMessage(), "Invalid Data",JOptionPane.ERROR_MESSAGE);
             }  
            
            

    }

    }



    @Override
    public void setFilmsController(FilmsController filmsController) {
        this.filmsController = filmsController;
        
    }

/*
    public static void main(String [] args) {
        //ScheduleFilmGUIimpl s = new ScheduleFilmGUIimpl();
    }*/

}



