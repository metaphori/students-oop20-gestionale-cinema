package viewImpl.ManageAccounts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import controller.ManageAccounts.AccountsController;
import utilities.Film;
import view.ManageAccounts.ManagementAccountGUI;

public class ManagementAccountImplGUI implements ManagementAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT ??
    
    private static final String FRAME_NAME = "Management account";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame = new JFrame();
    
    //components
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);
    
    private AccountsController observer;
    
    
    public ManagementAccountImplGUI () {
        
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /*
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(new JLabel("Account list"));
        
        final JPanel pWestInternal = new JPanel ( new GridBagLayout ()); // Griglia flessibile
        final GridBagConstraints cnst = new GridBagConstraints ();
        cnst.gridy = 0;
        cnst.insets = new Insets (5 ,5 ,5 , 5);
        cnst.fill = GridBagConstraints.HORIZONTAL;
        
        
        
        final JScrollPane scrollPane = new JScrollPane (); //visione scorrevole del componente
        //tra le () posso aggiungere una tabella img ecc
        
        
        
        final JScrollPane scroll = new JScrollPane ( ); // Pannello con barra
        scroll . setVerticalScrollBarPolicy ( ScrollPaneConstants .   VERTICAL_SCROLLBAR_AS_NEEDED );
        pWestInternal.add(scroll);
        
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pWestInternal, BorderLayout.CENTER);
        
      */  
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.validate();
     
    }
     
    
    
    
    
    @Override
    public void show () {
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    
    }
    
    @Override
    public void setObserver(final AccountsController observer) {
        this.observer = observer;
    }
    
    
    @Override
    public void update() {//Reset map, take new films and rebuild central panel
       /* map.clear();
        centerPanel.remove(0); //remove first child

        Set<Film> film = new HashSet<>(observer.getFilms());
        
        centerPanel.add(factoryFilmPanel.getFilmPanel(map, film));
        for (final var button: map.keySet()) {
            button.addActionListener(al);
        }
        centerPanel.validate();
        frame.validate();*/
    }    
    
    public static void main(String[] args) {
        ManagementAccountImplGUI view = new ManagementAccountImplGUI();
        view.show();
   
    }
    
}
