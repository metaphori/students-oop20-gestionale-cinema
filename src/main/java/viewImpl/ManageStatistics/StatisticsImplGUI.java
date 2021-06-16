package viewImpl.ManageStatistics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
import utilitiesImpl.ViewSettings;
import view.ManageStatistics.StatisticsGUI;


public class StatisticsImplGUI implements StatisticsGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT

    private static final String FRAME_NAME = "Statistics";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFrame frame;
    private static final String MONEY_STRING = "Money collection: ";
    private static final String MOVIE_STRING = "Most watched movie: ";
    private static final String PEOPLE_STRING = "Day with the most people: ";
    private static final String TITLE_STRING = "Cinema's Statistics";

    private static final double IMAGE_WIDTH = 0.4;
    private static final double IMAGE_HEIGTH = 0.6;
    JLabel title = new JLabel(TITLE_STRING);
    
    
    
    private final JLabel movie = new JLabel(MOVIE_STRING);
    private final JLabel money = new JLabel(MONEY_STRING);
    private final JLabel people = new JLabel(PEOPLE_STRING);

    //img film
    private final URL imgURL = ClassLoader.getSystemResource("images/filmStandardIco.png");
    private ImageIcon icon = new ImageIcon(imgURL);
    private final JButton pic = new JButton(icon);
    
    
    //img Stat
    private final URL imgURLS = ClassLoader.getSystemResource("images/statistics.png");
    private ImageIcon iconS = new ImageIcon(imgURLS);
    private final JButton picS = new JButton(iconS);
    
    /*
    //img watch
    private final URL imgURLW = ClassLoader.getSystemResource("images/watch.png");
    private ImageIcon iconW = new ImageIcon(imgURLW);
    private final JButton picW = new JButton(iconW);
    */
    
    private final JButton home = new JButton("Home");

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

    public StatisticsImplGUI() {

        //I create the frame and set the title and other properties
        this.frame = new JFrame();
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel pWestInternal = new JPanel(new GridBagLayout());
        final GridBagConstraints cnst = new GridBagConstraints();
        cnst.gridy = 0;
        cnst.insets = new Insets(SPACE, SPACE, SPACE, SPACE);
        cnst.fill = GridBagConstraints.HORIZONTAL;

        //I create the secondary panels for the various parts and add the components
        final JPanel pNorthInternal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNorthInternal.add(home, cnst);
        final JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pNorth.add(title, cnst);
        cnst.gridy++; // next line

        pWestInternal.add(movie, cnst); 
        movie.setFont(new Font("Serif", Font.BOLD, 22));
        cnst.gridy++;

        pic.setMargin(new Insets(SC, SC, SC, SC));
        pWestInternal.add(pic, cnst);
        cnst.gridy++; 

        final JPanel pWest = new JPanel(new FlowLayout());
        pWest.add(pWestInternal, cnst);
        cnst.gridy++; 

        final JPanel pEastInternal = new JPanel(new GridBagLayout());
        final GridBagConstraints cnt = new GridBagConstraints();
        cnt.gridy = 0;
        cnt.insets = new Insets(SP, SP, SP, SP);
        cnt.fill = GridBagConstraints.HORIZONTAL;
        pEastInternal.add(money, cnt);

        money.setFont(new Font("Serif", Font.BOLD, 22));
        
        cnt.gridy++;
        pEastInternal.add(people, cnt);

        people.setFont(new Font("Serif", Font.BOLD, 22));
        //cnst.gridy++;

        final JPanel pEast = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pEast.add(pEastInternal, cnst);
        //cnst.gridy++;

        final JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pEastInternal.add(picS, cnst);
        //pEastInternal.add(picW, cnst);
        
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(pWest, BorderLayout.WEST);
        frame.add(pEast, BorderLayout.CENTER);
        frame.add(pNorthInternal, BorderLayout.EAST);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.validate();

        home.addActionListener(event -> {
            observer.showMenu();
            frame.setVisible(false);
        });

    }

    @Override
    public void show() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }

    @Override
    public void setObserver(final StatisticsController observer) {
        this.observer = observer;
    }

    @Override
    public void update() {
        Optional<Film> filmOptional = observer.getMostedWatchedFilm();
        if (filmOptional.isPresent() && filmOptional.get().getCoverPath().isPresent()) {
            pic.setIcon(new ImageIcon(filmOptional.get().getCoverPath().get()));

            ImageIcon imageIcon = new ImageIcon(filmOptional.get().getCoverPath().get());
            final Image image = imageIcon.getImage(); // transform it 
            final Image newimg = image.getScaledInstance((int) (ViewSettings.DIMENSION_WIDTH_SCREEN * IMAGE_WIDTH), (int) (ViewSettings.DIMENSION_HEIGTH_SCREEN  * IMAGE_HEIGTH),  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);  // transform it back
            pic.setIcon(imageIcon);
            movie.setText(MOVIE_STRING + filmOptional.get().getName());
        }

        Optional<LocalDate> dateOptional = observer.getMostAffluentDays();
        if (dateOptional.isPresent()) {
            people.setText(PEOPLE_STRING + dateOptional.get().toString());
        }
        //picW.setIcon(iconW);
        
        Double moneyTotal = observer.getRecessed();
        money.setText(MONEY_STRING + moneyTotal.toString() +" euro");
        picS.setIcon(iconS);
        

    }
}
