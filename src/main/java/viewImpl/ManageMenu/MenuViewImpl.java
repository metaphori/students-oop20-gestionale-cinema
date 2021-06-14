package viewImpl.ManageMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CinemaController;
import controller.CinemaControllerObserver;
import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.TypeAccount;
import utilitiesImpl.ManageAccounts.LoggedAccount;
import view.ManageMenu.MenuView;

public class MenuViewImpl implements MenuView {
    CinemaControllerObserver observer;
    JFrame frame = new JFrame();
    
    private static final String BTN_CONTROLLER_ACCOUNT_TITLE = "MANAGE ACCOUNT";
    private static final String BTN_CONTROLLER_PROGRAMMED_FILM_TITLE = "MANAGE PROGRAMMED FILM";
    private static final String BTN_CONTROLLER_FILM_TITLE = "MANAGE FILM";
    private static final String BTN_CONTROLLER_TICKET_TITLE  = "MANAGE TICKET";
    private static final String BTN_CONTROLLER_STATISTICS_TITLE = "MANAGE STATISTICS";
    
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGTH_PERC_FRAME = 0.5;
    private static final double WIDTH_MINIMUM_FRAME = WIDTH_PERC_FRAME / 0.7;
    private static final double HEIGTH_MINMUM_FRAME = HEIGTH_PERC_FRAME / 0.7;

    public MenuViewImpl() {
        final JButton btnControllerAccount = new JButton(BTN_CONTROLLER_ACCOUNT_TITLE);
        final JButton btnControllerFilm = new JButton(BTN_CONTROLLER_FILM_TITLE);
        final JButton btnControllerProgrammingFilms = new JButton(BTN_CONTROLLER_PROGRAMMED_FILM_TITLE);
        final JButton btnControllerStatistics = new JButton(BTN_CONTROLLER_STATISTICS_TITLE);
        final JButton btnControllerTicket = new JButton(BTN_CONTROLLER_TICKET_TITLE);
        
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(btnControllerAccount);
        centerPanel.add(btnControllerFilm);
        centerPanel.add(btnControllerProgrammingFilms);
        centerPanel.add(btnControllerStatistics);
        centerPanel.add(btnControllerTicket);
        
        btnControllerAccount.addActionListener( a -> {
            this.observer.showControllerAccount();
            frame.dispose();
        });
        btnControllerProgrammingFilms.addActionListener( a -> {
            this.observer.showControllerProgrammingFilms();
            frame.dispose();
        });
        btnControllerTicket.addActionListener( a -> {
            this.observer.showControllerTicket();
            frame.dispose();
        });
        btnControllerFilm.addActionListener( a -> {
            this.observer.showControllerFilm();
            frame.dispose();
        });
        btnControllerStatistics.addActionListener( a -> {
            this.observer.showControllerStatistics();
            frame.dispose();
        });
        LoggedAccount log = LoggedAccount.getIstance();
        Account accountLogged = log.getAccount();
        if(accountLogged.isAdmin().equals(TypeAccount.OPERATOR)) {
            btnControllerAccount.setEnabled(false);
        }
        if(accountLogged.isAdmin().equals(TypeAccount.OPERATOR)) {
            btnControllerProgrammingFilms.setEnabled(false);
        }
        if(accountLogged.isAdmin().equals(TypeAccount.OPERATOR)) {
            btnControllerFilm.setEnabled(false);
        }
        if(accountLogged.isAdmin().equals(TypeAccount.OPERATOR)) {
            btnControllerStatistics.setEnabled(false);
        }
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_MINIMUM_FRAME), (int) (screenSize.getHeight() * HEIGTH_MINMUM_FRAME)));

       frame.getContentPane().add(mainPanel);
        
    }
    public void setObserver(final 
            CinemaControllerObserver observer) {
        this.observer = observer;
    }
    public void show() {
        frame.setVisible(true);
    }
  
}
