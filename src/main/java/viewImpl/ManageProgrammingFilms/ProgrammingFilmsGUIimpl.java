package viewImpl.ManageProgrammingFilms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


import com.mindfusion.common.ChangeListener;
import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.ThemeType;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import modelImpl.ManageProgrammedFilms.FilterByDateImpl;
import modelImpl.ManageProgrammedFilms.SorterByTimeImpl;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import view.ManageProgrammingFilms.Factory.ProgrammingFilmsGUIfactory;
import viewImpl.ManageProgrammingFilms.factory.ProgrammingFilmsGUIfactoryImpl;

public class ProgrammingFilmsGUIimpl implements ProgrammingFilmsGUI {
        
        private static final long serialVersionUID = 7114066347061701832L;
        
        private static final String firstColumnName = "Film";
        private static final String secondColumnName = "Hall";
        private static final String thirdColumnName = "Start time";
        private static final String fourthColumnName = "End time";
        private static final int columnsNumber = 4;
        private static final String[] columnNames = new String[] {firstColumnName,secondColumnName,thirdColumnName,fourthColumnName};
        
        private static final String FRAME_NAME = "Programming  film";
        private static final double PROPORTION = 1.15;
        private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        private final JFrame frame = new JFrame(FRAME_NAME);
        private final Container container = frame.getContentPane();
        private final ProgrammingFilmsGUIfactory factory = new ProgrammingFilmsGUIfactoryImpl() ;
        
        //real dimension of the screen
        private final int screenWidth = (int) screen.getWidth();
        private final int screenHeight = (int) screen.getHeight();
        //real dimension of my frame
        private final int frameWidth = (int) (screenWidth / PROPORTION);
        private final int frameHeight = (int) (screenHeight / PROPORTION);
        
        private final JButton home = factory.createButton("Home");
        private final JButton addProgrammation = factory.createButton("Add programmation");
        private final JButton filterBy = factory.createButton("Filter by");
        private final Calendar calendar;
        private final JTable table;
        private ProgrammingFilmsController observer;
        private FilmsController filmsController;
        
        private Map<Integer,ProgrammedFilm> map ;// map row number to ProgrammedFilm
        

        public ProgrammingFilmsGUIimpl() {    
        
        final JPanel mainPanel = factory.createPanel(new BorderLayout());
        
        final JPanel centerPanel = factory.createPanel(new BorderLayout());
        final JPanel northPanel = factory.createPanel(new BorderLayout());
        final JPanel westPanel = factory.createPanel(new BorderLayout());
        
        final JPanel optionPanel = factory.createPanel(null);
        map = new HashMap<>();
           
        final Object[][] data = new Object[1][4]; // row columns        
      
        table = factory.createTable(columnNames, data);
        
        
        
        final JScrollPane scrollPane = new JScrollPane(table);
        
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        calendar = factory.createCalendar();
        
        calendar.getSelection().addChangeListener(new ChangeListener(){
            @Override
            public void changed(final EventObject e) {
                    System.out.println(getCalendarSelectionDate());
                    onSelectionChanged();	
                }
            }
        );
		
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(westPanel,BorderLayout.WEST);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
		
        northPanel.add(home,BorderLayout.EAST);
        optionPanel.setLayout(new BoxLayout(optionPanel,BoxLayout.Y_AXIS));
        westPanel.add(optionPanel,BorderLayout.SOUTH); // add panel in south of west panel
        westPanel.add(calendar, BorderLayout.NORTH);
        calendar.setPreferredSize(new Dimension(250,300));
        optionPanel.add(addProgrammation);
	addProgrammation.setMaximumSize(new Dimension(250,100)); //width , height
	addProgrammation.setPreferredSize(new Dimension(250,100));
	optionPanel.add(filterBy,BorderLayout.CENTER);
	filterBy.setMaximumSize(new Dimension(250,100)); //width,height 
	filterBy.setPreferredSize(new Dimension(250,100));
	container.add(mainPanel);
	
	
	addProgrammation.addActionListener(event -> {
	    
	    observer.showScheduleFilmView();	    
	});
	
	
	
	table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                final JTable table =(JTable) mouseEvent.getSource();
                final int clickCount = mouseEvent.getClickCount() ;
                final int selectedRow = table.getSelectedRow();
                if (clickCount == 2 && selectedRow != -1) {
                   
                    final int option = JOptionPane.showConfirmDialog(frame,"Do you want delete this selected programmation?","Deleting",JOptionPane.YES_NO_OPTION);
                    if(option == 0) { // yes 0 option , no 1 option 
                       observer.deleteProgrammedFilm(map.get(selectedRow)); 
                       onSelectionChanged();
                    } 
                }
            }   
        });
        	
		
        frame.pack();
        frame.setMinimumSize(new Dimension(screenWidth/2,screenHeight/2));
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(final WindowEvent winEvent) {
               //((JFrame)winEvent.getSource()).dispose();
                update();
            }
        });
        
        }
        

        private void onSelectionChanged() { // when user clicks on specific date, table must be updated
              
            final LocalDate selectedDate = this.getCalendarSelectionDate();
            final List<ProgrammedFilm> list = observer.getAllProgrammedFilms();
            final HandlerList<ProgrammedFilm> handler = observer.getManagerProgrammingFilms().getHandlerList();
            final List<ProgrammedFilm> filtByDate = handler.filterBy(list, new FilterByDateImpl(selectedDate)); // filter for selected date
            final List<ProgrammedFilm> sortByTime = handler.sortBy(filtByDate, new SorterByTimeImpl());            
            this.fillDataTable(sortByTime);	
            
    	}
        
        private LocalDate getCalendarSelectionDate() {
            if (calendar.getSelection().getIsEmpty()){    
                    return LocalDate.now();
            }
            final int day = calendar.getSelection().getRanges().get(0).getDay();
            final int month = calendar.getSelection().getRanges().get(0).getMonth();
            final int year = calendar.getSelection().getRanges().get(0).getYear();
            return LocalDate.of(year, month , day);
            
        }
        
        private void fillDataTable(final List<ProgrammedFilm> manipulatedList ) {
            /*ProgrammingFilmsController controller; // CREO UN'ISTANZA CON TUTTI I DATI DEI FILM
            //DO A RESEARCH TO FIND CORRELATE NAME
            */
            map.clear(); // empty map
            final Object [][] data = new Object[manipulatedList.size()][columnsNumber];
            for(int i=0; i< manipulatedList.size();i++) {
                
                //data[i][0] = manipulatedList.get(i).getIdProgrammation(); // QUI VA INSERITO IL NOME DEL FILM CORRISPONDENTE AL FILM
                final int id =  manipulatedList.get(i).getIdProgrammation();
                data[i][0] = filmsController.getFilms().stream().filter(film -> film.getID() == id).collect(Collectors.toList()).get(0).getName();
                data[i][1] = manipulatedList.get(i).getHall();
                data[i][2] = manipulatedList.get(i).getStartTime();
                data[i][3] = manipulatedList.get(i).getEndTime();
                map.put(i, manipulatedList.get(i));
                
            }
            
            final DefaultTableModel modelNew = new DefaultTableModel(data, columnNames);
            table.setModel(modelNew);
            final DefaultTableModel dfm = (DefaultTableModel) table.getModel();
            dfm.fireTableDataChanged();      
            
        }
        
       
        
        @Override
        public void start() {
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            /*if(observer.getFilms().isEmpty()) {
                this.showNoFilmsDialog();
            }*/
            
        }


        @Override
        public void setObserver(final ProgrammingFilmsController observer) {
            this.observer = observer;
        }

        
        @Override
        public void update() {
            this.onSelectionChanged(); //update table
            
        }


        @Override
        public void setFilmsController(final FilmsController filmsController) {
            this.filmsController = filmsController;
        }
        
        
        
}
