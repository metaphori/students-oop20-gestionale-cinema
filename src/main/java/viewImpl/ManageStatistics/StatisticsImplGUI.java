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

import view.ManageStatistics.StatisticsGUI;


public class StatisticsImplGUI implements StatisticsGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT
    
    private static final String FRAME_NAME = "Statistics";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame;
    
    final JLabel title = new JLabel("Statistiche settimanali"); 
    final JLabel movie = new JLabel ("Most watched movie :");
    final JLabel money = new JLabel ("Weekly money collection : ");
    final JLabel people = new JLabel ("Day with the most people of the week : ");
    
    final JButton back = new JButton("Back");
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);
        
    
    public StatisticsImplGUI () {
        
        //I create the frame and set the title and other properties
        this.frame = new JFrame();
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel pWestInternal = new JPanel ( new GridBagLayout ()); // Griglia flessibile
        final GridBagConstraints cnst = new GridBagConstraints ();
        cnst.gridy = 0;
        cnst.insets = new Insets (5 ,5 ,5 , 5);
        cnst.fill = GridBagConstraints.HORIZONTAL;

        //I create the secondary panels for the various parts and add the components
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(title, cnst);
        pNorth.add(back, FlowLayout.LEFT);
        cnst.gridy ++; // next line
        
        pWestInternal.add(movie, cnst); 
        cnst.gridy ++; 
        
        //img
        final URL imgURL = ClassLoader.getSystemResource("images/filmStandardIco.png");
        ImageIcon icon = new ImageIcon(imgURL);
        final JButton pic = new JButton(icon);
        pic.setMargin(new Insets(3, 3, 3, 3));
        
        pWestInternal.add(pic, cnst);
        cnst.gridy ++; 
        
        final JPanel pWest = new JPanel (new FlowLayout ());
        pWest.add( pWestInternal, cnst );
        cnst.gridy ++; 
        
        final JPanel pEastInternal = new JPanel ( new GridBagLayout ());
        final GridBagConstraints cnt = new GridBagConstraints ();
        cnt.gridy = 0;
        cnt.insets = new Insets (90 ,90 ,90 ,90);
        cnt.fill = GridBagConstraints.HORIZONTAL;
        pEastInternal.add(money, cnt);
        cnt.gridy ++;
        
        pEastInternal.add(people, cnt);
        cnst.gridy ++;
        
        final JPanel pEast = new JPanel (new FlowLayout (FlowLayout.LEFT));
        pEast.add( pEastInternal, cnst );
        cnst.gridy ++; 
      
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.LEFT)); 
        pSouth.add(back, cnst);
        cnst.gridy ++; 
        
        
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pSouth, BorderLayout.SOUTH);
        frame.add (pWest, BorderLayout.WEST);
        frame.add (pEast, BorderLayout.CENTER);
        
        pic.addActionListener(e -> {
            final JFileChooser chooser = new JFileChooser();
            final FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG  & PNG Images", "jpg", "png", "jpeg");
            chooser.setFileFilter(filter);
            final int returnVal = chooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               final File selectedFile = chooser.getSelectedFile();
               final File destFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "test");
               try {
                   FileUtils.copyFile(selectedFile, destFile);
               } catch (IOException exception) {
                   exception.printStackTrace();
               }
            }
        }
        );
        
        
        
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.validate();
     
        
    }
        @Override
        public void show () {
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        
     }
       
    public static void main(String[] args) {
        StatisticsImplGUI view = new StatisticsImplGUI();
        view.show();
    }
    
}
