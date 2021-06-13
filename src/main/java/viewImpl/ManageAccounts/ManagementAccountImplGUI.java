package viewImpl.ManageAccounts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ManageAccounts.AccountsController;
import utilities.Film;
import utilities.ManageAccounts.Account;
import view.ManageAccounts.ManagementAccountGUI;

public class ManagementAccountImplGUI implements ManagementAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT 
    
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
    public static final int SPACE = 5;

    final ActionListener al;
    private Map<JButton, Account> map = new HashMap<>();
    final JPanel pWestInternal = new JPanel ( new GridBagLayout ()); // Griglia flessibile
    
    public ManagementAccountImplGUI () {
        
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        final GridBagConstraints cnst = new GridBagConstraints ();
        cnst.gridy = 0;
        cnst.insets = new Insets (SPACE, SPACE, SPACE, SPACE); 
        cnst.fill = GridBagConstraints.HORIZONTAL;
        
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(title);
        cnst.gridy ++;
        
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] {}, new Object[] {"Username", "Name", "Surname"});
        JTable table = new JTable (dm);
        
        
        final JScrollPane scroll = new JScrollPane (table); //visione scorrevole del componente

       // getContentPane().add(scroll);
        
        
        //final JScrollPane scroll = new JScrollPane ( ); // Pannello con barra
        scroll . setVerticalScrollBarPolicy ( ScrollPaneConstants .   VERTICAL_SCROLLBAR_AS_NEEDED );
        pWestInternal.add(scroll);
        
        final JPanel pEst = new JPanel();
        pEst.add(home);
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.CENTER));
        pSouth.add(add);
       
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pWestInternal, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.add(pEst, BorderLayout.EAST);
        
        
        
        al = (e) -> { 
            //users click on specific account
            final JButton selected = (JButton) e.getSource(); 
            System.out.println("key" + map.containsKey(selected));
            final Account a = map.get(selected);
            frame.setVisible(false);
            System.out.println("ActionListener:" + map + " ");
            observer.showInfoAccountView(a); //mostro le info del account
        };
        
       //add action listener to every buttons
        for (final var button: map.keySet()) {
            button.addActionListener(al);
        }
        
        
        //method to registration view 
        add.addActionListener(event -> { 
            //frame.dispose();
            observer.showRegistrationAccountView(); 
            frame.setVisible(false);
        });
        
     
        home.addActionListener(event -> {
            observer.showMenu();
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
        if(observer.getAccounts().isEmpty()) {
            this.showDialog();
        }
    }
    
    @Override
    public void setObserver(final AccountsController observer) {
        this.observer = observer;
    }
    
    //update table of list account
    @Override
    public void update() {
        map.clear();
        
        Set<Account> a = new HashSet<>(observer.getAccounts());
        pWestInternal.add((Component) map,a);
        frame.add (pWestInternal, BorderLayout.CENTER);
        
        for (final var button: map.keySet()) {
            button.addActionListener(al);
        }
        frame.validate();
        
    }
    
    private void showDialog() {
        JOptionPane.showMessageDialog(frame, "Please add your personal information so as to avoid using default username and password." );
    }
    
    /*
    public static void main(String[] args) {
        ManagementAccountImplGUI view = new ManagementAccountImplGUI();
        view.show();
   
    }
    */
}
