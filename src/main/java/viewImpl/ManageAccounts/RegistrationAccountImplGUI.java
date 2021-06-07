package viewImpl.ManageAccounts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.SeatTypeAccount;
import view.ManageAccounts.RegistrationAccountGUI;

import java.awt.event.*;

public class RegistrationAccountImplGUI implements RegistrationAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT
    
    private static final String FRAME_NAME = "Registrazione";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame;
    
    //components
    final JLabel title = new JLabel("Add account"); 
    final JLabel username = new JLabel ("Username:");
    final TextField TextUsername = new TextField ("Username", 12);
    final JLabel name = new JLabel ("Name:");
    final TextField TextName = new TextField ("Name", 12);
    final JLabel surname = new JLabel ("Surname:");
    final TextField TextSurname = new TextField ("Surname", 12);
    final JLabel password = new JLabel ("Password:");
    final TextField TextPassword = new TextField ("Password", 12);
    final JLabel secondPwd = new JLabel ("Repeat Password:");
    final TextField TextSecondPwd = new TextField ("Repeat Password", 12);
    final JLabel isAdmin = new JLabel ("Type:");
    
    final String [] s = new String [] {"Administrator", "Operator"};
    final JComboBox type = new JComboBox < String >(s);
    
    final JButton add = new JButton("Add");
    final JButton close = new JButton("Close");

    final JButton reset = new JButton("Reset");
    
    private AccountsController observer;
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);
       
    
    public RegistrationAccountImplGUI () {
        
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
        cnst.gridy ++; //next line
        
        pWestInternal.add(username, cnst);
        pWestInternal.add(TextUsername, cnst);
        cnst.gridy ++; 
        pWestInternal.add(name, cnst);
        pWestInternal.add(TextName, cnst);
        cnst.gridy ++; 
        pWestInternal.add(surname, cnst);
        pWestInternal.add(TextSurname, cnst);
        cnst.gridy ++; 
        pWestInternal.add(password, cnst);
        pWestInternal.add(TextPassword, cnst);
        cnst.gridy ++; 
        pWestInternal.add(secondPwd, cnst);
        pWestInternal.add(TextSecondPwd, cnst);
        cnst.gridy ++;
        
        pWestInternal.add(isAdmin, cnst);
        pWestInternal.add (type, cnst);
        cnst.gridy ++; 
                                  
        final JPanel pWest = new JPanel (new FlowLayout ());
        pWest.add( pWestInternal );
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.CENTER));
        pSouth.add(add);
        pSouth.add(close);
        pSouth.add(reset);
        
        frame.add (pWest , BorderLayout . CENTER );
        frame.add (pNorth , BorderLayout . NORTH);
        frame.add (pSouth , BorderLayout . SOUTH);
        
        
        
        //method to remove descriptive writing
        TextUsername.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        TextUsername.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });

        //method to remove descriptive writing
        TextPassword.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        TextPassword.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });
       
        //method to remove descriptive writing
        TextName.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                TextName.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
        //method to remove descriptive writing
        TextSurname.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                TextSurname.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
        //method to remove descriptive writing
        TextSecondPwd.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                TextSecondPwd.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
        //method for returning to the previous page
        close.addActionListener(event -> {
            frame.setVisible(false); 
            observer.showManagementAccountView();
         }
         );
        
        
        //method to remove writing
        reset.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        TextUsername.setText("");
                        TextName.setText("");
                        TextSurname.setText("");
                        TextPassword.setText("");
                        TextSecondPwd.setText("");   
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
      //method to add new account
        add.addActionListener(event -> {
            
            Account account;

            if(!(TextPassword.getText()).equals(TextSecondPwd)) {
                JLabel wrong = new JLabel("wrong password");
                wrong.setForeground(Color.RED);      
            }

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
       

    public static void main(String[] args) {
        RegistrationAccountImplGUI view = new RegistrationAccountImplGUI();
        view.show();
        
    }
    @Override
    public void setObserver(AccountsController observer) {
        this.observer = observer;
        
    }
    
    @Override
    public void loadAccount(Account account) {
        TextName.setText(account.getName());
        TextSurname.setText(account.getSurname());
        TextUsername.setText(account.getUsername());
        TextPassword.setText(account.getPassword());
        
        if(type.getSelectedItem().equals("Administrator")) {
            account.isAdmin().equals(SeatTypeAccount.ADMINISTRATOR);
        } else if(type.getSelectedItem().equals("operator")) {
            account.isAdmin().equals(SeatTypeAccount.OPERATOR);   
        }
        
    }
    
    
}