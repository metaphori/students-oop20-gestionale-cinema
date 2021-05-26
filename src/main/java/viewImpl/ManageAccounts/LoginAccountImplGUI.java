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
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import controller.ManageAccounts.AccountsController;
import controller.ManageFilms.FilmsController;
import utilities.ManageAccounts.Account;
import view.ManageAccounts.LoginAccountGUI;

import java.awt.event.*
;

public class LoginAccountImplGUI implements LoginAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT
    
    private static final String FRAME_NAME = "Login";
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final JFrame frame;
    
    //components
    final JLabel title = new JLabel("Login utente");
    final JLabel username = new JLabel ("Username:");
    final TextField TextUsername = new TextField ("Username", 12); //written that will be removed when clicked
    final JLabel password = new JLabel ("Password:");
    final JPasswordField TextPassword = new JPasswordField("Password", 12); //password field + written that will be removed when clicked
    final JButton login = new JButton("Login");
    final JButton reset = new JButton("Reset");
    
    private AccountsController observer;
    
    HashMap<String,String> logininfo = new HashMap<String,String>();
   
    public LoginAccountImplGUI() {
        
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
        cnst.gridy ++; // prossima riga
        
        pWestInternal.add(username, cnst); 
        pWestInternal.add(TextUsername, cnst);
        cnst.gridy ++; 
        
        pWestInternal.add(password, cnst);
        pWestInternal.add(TextPassword, cnst);
        cnst.gridy ++; 
                      
        final JPanel pWest = new JPanel (new FlowLayout ());
        pWest.add( pWestInternal );
        
        final JPanel pSouth = new JPanel (new FlowLayout (FlowLayout.CENTER)); 
        pSouth.add(login);
        pSouth.add(reset);
        
        frame.add (pWest, BorderLayout.CENTER );
        frame.add (pNorth, BorderLayout.NORTH);
        frame.add (pSouth, BorderLayout.SOUTH);
        
        
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
       
       //method to remove writing
        reset.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        TextUsername.setText("");
                        TextPassword.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });
        
        
        
        login.addActionListener(event -> { 
                String userID = TextUsername.getText();
                String password = String.valueOf(TextPassword.getPassword());
                if(logininfo.containsKey(userID)) {
                    if(logininfo.get(userID).equals(password)) {
                            JLabel successful = new JLabel("Login successful");
                            successful.setForeground(Color.GREEN);
                            frame.dispose();
                            observer.showMenu();
                            frame.setVisible(false);
                    }
                    else {
                        JLabel wrong = new JLabel("wrong password");
                        wrong.setForeground(Color.RED);     
                    }
            }
            else {
                JLabel notFound = new JLabel("username not found");
                notFound.setForeground(Color.RED);
            }
                
        

       
        });
        
        
    }
    
    /*
     //method to show the pwd or not
    private void showPwdActionPerformed (ActionEvent evt) {
        if (showPwd.isSelected()) {
            TextPassword.setEchoChar((char)0);
        } else {
            TextPassword.setEchoChar((char)'*');
        }
       }
    */
    
   
   // public void setObserver (LoginAccountGUIObserver observer) {
     //   this . observer = observer ;
    //}
    
    @Override
    public void setObserver(final AccountsController observer) {
        this.observer = observer;
    }
    
    @Override
    public void show () {
        //resize the window and make the Frame visible
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
     }
    
    @Override
    public void setDimensions (int x, int y) {
        this.frame.setSize(x,y);
    }
  
    public static void main(String[] args) {
        LoginAccountImplGUI view = new LoginAccountImplGUI();
        view.show();
        view.setDimensions(400,200);
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }
    
}