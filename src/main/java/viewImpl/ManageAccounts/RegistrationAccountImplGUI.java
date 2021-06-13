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
import java.util.Set;

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
import utilities.ManageAccounts.TypeAccount;
import utilitiesImpl.ManageAccounts.AccountImpl;
import view.ManageAccounts.RegistrationAccountGUI;

import java.awt.event.*;

public class RegistrationAccountImplGUI implements RegistrationAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT
    
    private static final String FRAME_NAME = "Registration";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame;
    
    //components
    final JLabel title = new JLabel("Add, modify or delete account"); 
    final JLabel username = new JLabel ("Username:");
    final TextField textUsername = new TextField ("Username", 12);
    final JLabel name = new JLabel ("Name:");
    final TextField textName = new TextField ("Name", 12);
    final JLabel surname = new JLabel ("Surname:");
    final TextField textSurname = new TextField ("Surname", 12);
    final JLabel password = new JLabel ("Password:");
    final TextField textPassword = new TextField ("Password", 12);
    final JLabel secondPwd = new JLabel ("Repeat Password:");
    final TextField textSecondPwd = new TextField ("Repeat Password", 12);
    final JLabel isAdmin = new JLabel ("Type:");
    
    final String [] stringType = new String [] {"Administrator", "Operator"};
    final JComboBox type = new JComboBox < String >(stringType);
    
    final JButton save = new JButton("Save");
    final JButton close = new JButton("Close"); 
    final JButton reset = new JButton("Reset");
    
    private AccountsController observer;
    private Optional<Account> focusAccount;

    
    public static final int SPACE = 5;
    
    public RegistrationAccountImplGUI () {
        
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
        final JPanel pNorth = new JPanel (new FlowLayout ());
        pNorth.add(title, cnst);
        
        cnst.gridy ++; //next line
        
        pWestInternal.add(username, cnst);
        pWestInternal.add(textUsername, cnst);
        cnst.gridy ++; 
        pWestInternal.add(name, cnst);
        pWestInternal.add(textName, cnst);
        cnst.gridy ++; 
        pWestInternal.add(surname, cnst);
        pWestInternal.add(textSurname, cnst);
        cnst.gridy ++; 
        pWestInternal.add(password, cnst);
        pWestInternal.add(textPassword, cnst);
        cnst.gridy ++; 
        pWestInternal.add(secondPwd, cnst);
        pWestInternal.add(textSecondPwd, cnst);
        cnst.gridy ++;
        
        pWestInternal.add(isAdmin, cnst);
        pWestInternal.add (type, cnst);
        cnst.gridy ++; 
        pWestInternal.add(save, cnst);
        cnst.gridy ++; 
                                  
        final JPanel pWest = new JPanel (new FlowLayout ());
        pWest.add( pWestInternal );
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.CENTER));
        
        pSouth.add(reset);
        
        pSouth.add(close);
        
        
        
        focusAccount = Optional.ofNullable(null); // focusFilm empty
        
        
        frame.add (pWest , BorderLayout . CENTER );
        frame.add (pNorth , BorderLayout . NORTH);
        frame.add (pSouth , BorderLayout . SOUTH);
        
        
       //method to remove descriptive writing
        textUsername.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Username".equals(textUsername.getText())) { 
                        textUsername.setText("");
                }
            }
            public void focusLost(final FocusEvent e) {
            }
        });

       //method to remove descriptive writing
        textPassword.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Password".equals(textPassword.getText())) { 
                    textPassword.setText("");
                }
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
       
       //method to remove descriptive writing
        textName.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Name".equals(textName.getText())) { 
                    textName.setText("");
                }
            }
            public void focusLost(final FocusEvent e) {
            }
        });
        
       //method to remove descriptive writing
        textSurname.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Surname".equals(textSurname.getText())) { 
                    textSurname.setText("");
                }
            }
            public void focusLost(final FocusEvent e) {
            }
        });
        
      //method to remove descriptive writing
        textSecondPwd.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Repeat Password".equals(textSecondPwd.getText())) { 
                    textSecondPwd.setText("");
                }
            }
            public void focusLost(final FocusEvent e) {
            }
        });
        
        //method for returning to the previous page
        close.addActionListener(event -> {
            frame.setVisible(false);
            focusAccount = Optional.ofNullable(null);
            observer.showManagementAccountView();
             
         });
        
        
        //method to remove writing
        reset.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        textUsername.setText("");
                        textName.setText("");
                        textSurname.setText("");
                        textPassword.setText("");
                        textSecondPwd.setText("");   
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
        
        
        
      //method to add new account
        save.addActionListener(event -> {
            if(this.checkAccount()) {
                TypeAccount typeAccount;
                if(type.getSelectedItem().equals("Administrator")) {
                    typeAccount = TypeAccount.ADMINISTRATOR;
                } else {
                    typeAccount = TypeAccount.OPERATOR;   
                }
                Account account = new AccountImpl(textName.getText() , textSurname.getText(), textUsername.getText(), textPassword.getText(), typeAccount);
                this.observer.addAccount(account);
            }
           
        });
        
    }
    
    
    
    @Override
    public void show () {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setSize(500, 400);
        
     }
      
    @Override
    public void setObserver(AccountsController observer) {
        this.observer = observer;
    }
    
    
    
    @Override
    public void loadAccount(Account account) { //carico account
        focusAccount = Optional.of(account); //mette focus su un determinato account
        textName.setText(account.getName());
        textSurname.setText(account.getSurname());
        textUsername.setText(account.getUsername());
        textPassword.setText(account.getPassword());
        
        if(type.getSelectedItem().equals("Administrator")) {
            account.isAdmin().equals(TypeAccount.ADMINISTRATOR);
        } else if(type.getSelectedItem().equals("Operator")) {
            account.isAdmin().equals(TypeAccount.OPERATOR);   
        }

    }
    
    private boolean checkAccount () {
        Set<Account> setAccount = observer.getAccounts();
        if(!(textPassword.getText()).equals(textSecondPwd.getText())) {
            JOptionPane.showMessageDialog(frame, "Password non corrisponde" );
            return false;
        }
        if(setAccount.stream().filter(a -> a.getUsername().equals(textUsername.getText())).findAny().isPresent() ) {
            JOptionPane.showMessageDialog(frame, "Username già presente" );
            return false;
        }
        return true;
    }
    
}