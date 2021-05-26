package viewImpl.ManageAccounts;

// DA SISTEMARE

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
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import controller.ManageAccounts.AccountsController;
import view.ManageAccounts.ManagementAccountGUI;

public class ManagementAccountImplGUI implements ManagementAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT ??
    
    private static final String FRAME_NAME = "Management account";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame = new JFrame();
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);
    
    
    public ManagementAccountImplGUI () {
        
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(new JLabel("Account list"));
        
        //final JScrollPane scroll = new JScrollPane ( ); // Pannello con barra
        //scroll . setVerticalScrollBarPolicy ( ScrollPaneConstants . VERTICAL_SCROLLBAR_ALWAYS );
        
        
        frame.add (pNorth, BorderLayout.NORTH);
        
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.validate();
     
    }
     
    
    
    
    
    @Override
    public void show () {
  //ridimensiona la finestra e rendo visibile il Frame 
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    
    }
    
    public static void main(String[] args) {
        ManagementAccountImplGUI view = new ManagementAccountImplGUI();
        view.show();
   
    }





    @Override
    public void setObserver(AccountsController observer) {
        // TODO Auto-generated method stub
        
    }





    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }
}
