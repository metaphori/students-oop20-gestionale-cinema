package viewImpl.ManageAccounts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManageAccounts.AccountsController;
import view.ManageAccounts.ManagementAccountGUI;

public class ManagementAccountImplGUI implements ManagementAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT ??
    
    private static final String FRAME_NAME = "Management account";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame = new JFrame();
    
    //components
    final JLabel title = new JLabel("List account"); 
    final JButton add = new JButton("Add");
    final JButton home = new JButton("Home");
    
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
    
        final JPanel pWestInternal = new JPanel ( new GridBagLayout ()); // Griglia flessibile
        final GridBagConstraints cnst = new GridBagConstraints ();
        cnst.gridy = 0;
        cnst.insets = new Insets (5 ,5 ,5 , 5);
        cnst.fill = GridBagConstraints.HORIZONTAL;
        
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(title);
        cnst.gridy ++;
        
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] {}, new Object[] {"Username", "Name", "Surname","Option"});
        JTable table = new JTable (dm);
        
        
        final JScrollPane scroll = new JScrollPane (table); //visione scorrevole del componente

       // getContentPane().add(scroll);
        
        
        //final JScrollPane scroll = new JScrollPane ( ); // Pannello con barra
        scroll . setVerticalScrollBarPolicy ( ScrollPaneConstants .   VERTICAL_SCROLLBAR_AS_NEEDED );
        pWestInternal.add(scroll);
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.CENTER));
        pSouth.add(add);
        
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pWestInternal, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        
        
        //method to registration view 
        add.addActionListener(event -> { 
            frame.dispose();
            observer.showRegistrationAccountView(null);
            frame.setVisible(false);
        });
        
     
       
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
    
    //update table of list account
    @Override
    public void update() {
        
    }    
    
    public static void main(String[] args) {
        ManagementAccountImplGUI view = new ManagementAccountImplGUI();
        view.show();
   
    }
    
}
