package viewImpl.ManageMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CinemaController;
import controller.CinemaControllerObserver;
import view.ManageMenu.MenuView;

public class MenuViewImpl implements MenuView {
    CinemaControllerObserver observer;
    JFrame frame = new JFrame();
    
    private static final String BTN_CONTROLLER_ACCOUNT_TITLE = "MANAGE ACCOUNT";
    private static final String BTN_CONTROLLER_PROGRAMMED_FILM_TITLE = "MANAGE FILM";
    private static final String BTN_CONTROLLER_FILM_TITLE = "MANAGE PROGRAMMED FILM";
    private static final String BTN_CONTROLLER_TICKET_TITLE  = "MANAGE TICKET";
    private static final String BTN_CONTROLLER_STATISTICS_TITLE = "MANAGE STATISTICS";
    
    
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
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
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
