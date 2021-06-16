package viewImpl.ManageAccounts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;


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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

import org.apache.commons.io.FileUtils;

import controller.ManageAccounts.AccountsController;
import utilities.ManageAccounts.Account;
import utilitiesImpl.ManageAccounts.LoggedAccount;
import view.ManageAccounts.LoginAccountGUI;

import java.awt.event.*
;

public class LoginAccountImplGUI implements LoginAccountGUI{
    //GRID BAG LAYOUT + FLOW LAYOUT

    private static final String FRAME_NAME = "Login";
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFrame frame;

    //components
    private final JLabel title = new JLabel("Login Account");
    private final JLabel username = new JLabel("Username:");
    private final TextField textUsername = new TextField("Username", 12); //written that will be removed when clicked
    private final JLabel password = new JLabel("Password:");
    private final JPasswordField textPassword = new JPasswordField("Password", 12); //password field + written that will be removed when clicked
    private final JButton login = new JButton("Login");
    private final JButton reset = new JButton("Reset");

    private AccountsController observer;

    private Map<String, String> logininfo = new HashMap<String,String>();
    private Set<Account> setAccount = new HashSet<>();

    public static final int SPACE = 5;

    /**
     * Construttor for the view Login.
     */
    public LoginAccountImplGUI() {

        //I create the frame and set the title and other properties
        this.frame = new JFrame();
        frame.setTitle(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel pWestInternal = new JPanel(new GridBagLayout()); //flexible grid
        final GridBagConstraints cnst = new GridBagConstraints();
        cnst.gridy = 0;
        cnst.insets = new Insets(SPACE, SPACE, SPACE, SPACE);
        cnst.fill = GridBagConstraints.HORIZONTAL;

        //I create the secondary panels for the various parts and add the components
        final JPanel pNorth = new JPanel(new FlowLayout());
        pNorth.add(title, cnst);
        cnst.gridy++;   //next line

        pWestInternal.add(username, cnst); 
        pWestInternal.add(textUsername, cnst);
        cnst.gridy++;

        pWestInternal.add(password, cnst);
        pWestInternal.add(textPassword, cnst);
        cnst.gridy++;

        final JPanel pWest = new JPanel(new FlowLayout());
        pWest.add(pWestInternal);

        final JPanel pSouth = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        pSouth.add(login);
        pSouth.add(reset);

        frame.add(pWest, BorderLayout.CENTER);
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(pSouth, BorderLayout.SOUTH);


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

       //method to remove writing
        reset.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) { 
                        textUsername.setText("");
                        textPassword.setText("");
            }

            public void focusLost(final FocusEvent e) {
            }
        });


        login.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                String userID = textUsername.getText();
                String password = String.valueOf(textPassword.getPassword());
                if (logininfo.containsKey(userID)) {
                    if (logininfo.get(userID).equals(password)) {
                        LoggedAccount log = LoggedAccount.getIstance();
                        Account acc = setAccount.stream().filter(a -> a.getUsername().equals(userID)).findFirst().get();
                        log.setAccount(acc);
                        frame.dispose();
                        observer.showMenu();
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(pWestInternal, "Wrong password", "", JOptionPane.ERROR_MESSAGE);
                    }
            } else {
                JOptionPane.showMessageDialog(pWestInternal, "Username not found", "", JOptionPane.ERROR_MESSAGE);
            }

            }
        });
    }

    @Override
    public void setObserver(final AccountsController observer) {
        this.observer = observer;
    }

    @Override
    public void show() {
        //resize the window and make the Frame visible
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(350, 200);
        frame.setMinimumSize(new Dimension(350, 200));
     }

    @Override
    public void updateSetAccount(final Set<Account> setAccount) {
        this.setAccount =  setAccount;
        for (var account : setAccount) {
            logininfo.put(account.getUsername(), account.getPassword());
        }
        System.out.print("Account: " + logininfo);
    }
    
}