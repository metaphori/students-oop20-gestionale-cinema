package viewImpl.ManageStatistics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import controller.ManageStatistics.StatisticsController;
import utilities.Film;
import view.ManageStatistics.StatisticsGUI;


public class StatisticsImplGUI implements StatisticsGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT
    
    private static final String FRAME_NAME = "Statistics";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame;
    
    final JLabel title = new JLabel("Weekly Statistics"); 
    final JLabel movie = new JLabel ("Most watched movie :");
    final JLabel money = new JLabel ("Weekly money collection : ");
    final JLabel people = new JLabel ("Day with the most people of the week : ");
    
    //img
    final URL imgURL = ClassLoader.getSystemResource("images/filmStandardIco.png");
    ImageIcon icon = new ImageIcon(imgURL);
    final JButton pic = new JButton(icon);
    
    final JButton home = new JButton("Home");
    //final JButton update = new JButton("Update Statistics");
    
    public static final int SPACE = 5;
    public static final int SP = 90;
    public static final int SC = 3;
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);
        
    private StatisticsController observer;
    
    public StatisticsImplGUI () {
        
        //I create the frame and set the title and other properties
        this.frame = new JFrame();
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel pWestInternal = new JPanel ( new GridBagLayout ()); // Griglia flessibile
        final GridBagConstraints cnst = new GridBagConstraints ();
        cnst.gridy = 0;
        cnst.insets = new Insets (SPACE, SPACE, SPACE, SPACE);
        cnst.fill = GridBagConstraints.HORIZONTAL;

        //I create the secondary panels for the various parts and add the components
        final JPanel pNorthInternal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNorthInternal.add(home, cnst);
        final JPanel pNorth = new JPanel (new FlowLayout (FlowLayout.CENTER));
        pNorth.add(title, cnst);
        cnst.gridy ++; // next line
        
        pWestInternal.add(movie, cnst); 
        cnst.gridy ++; 
        
        pic.setMargin(new Insets(SC, SC, SC, SC));
        pWestInternal.add(pic, cnst);
        cnst.gridy ++; 
        
        final JPanel pWest = new JPanel (new FlowLayout ());
        pWest.add( pWestInternal, cnst );
        cnst.gridy ++; 
        
        final JPanel pEastInternal = new JPanel ( new GridBagLayout ());
        final GridBagConstraints cnt = new GridBagConstraints ();
        cnt.gridy = 0;
        cnt.insets = new Insets (SP, SP, SP, SP);
        cnt.fill = GridBagConstraints.HORIZONTAL;
        pEastInternal.add(money, cnt);
        cnt.gridy ++;
        pEastInternal.add(people, cnt);
        cnst.gridy ++;
        
        final JPanel pEast = new JPanel (new FlowLayout (FlowLayout.LEFT));
        pEast.add( pEastInternal, cnst );
        cnst.gridy ++; 
        
        /*
        final JPanel pSouth = new JPanel();
        pSouth.add(update,cnst);
        cnst.gridy ++;
        */
               
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pWest, BorderLayout.WEST);
        frame.add (pEast, BorderLayout.CENTER);
        frame.add (pNorthInternal, BorderLayout.EAST);
        //frame.add(pSouth, BorderLayout.SOUTH);
       
        
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.validate();
     
        
        home.addActionListener(event -> {
            observer.showMenu();
            frame.setVisible(false);
        });
        
        /*
        update.addActionListener(event -> {
            update();
        });
        */
    }
    
    @Override
    public void show () {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      }
     
    /*
    public static void main(String[] args) {
        StatisticsImplGUI view = new StatisticsImplGUI();
        view.show();
    }
    */
    
    @Override
    public void setObserver(StatisticsController observer) {
        this.observer = observer;
        
    }
    
    @Override
    public void update () {
        Optional<Film> filmOptional = observer.getMostedWatchedFilm();
        if(filmOptional.isPresent() && filmOptional.get().getCoverPath().isPresent()) {
            pic.setIcon(new ImageIcon(filmOptional.get().getCoverPath().get()));
        }
        Optional<LocalDate> dateOptional = observer.getMostAffluentDays();
        Double moneyTotal = observer.getRecessed();
;    }
    
}
