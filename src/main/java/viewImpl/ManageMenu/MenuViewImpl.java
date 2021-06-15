package viewImpl.ManageMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.CinemaController;
import controller.CinemaControllerObserver;
import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.TypeAccount;
import utilitiesImpl.ManageAccounts.LoggedAccount;
import view.ManageMenu.MenuView;

public final class MenuViewImpl implements MenuView {
    private CinemaControllerObserver observer;
    private final JFrame frame = new JFrame();
    private final String TITLE_FRAME = "Menu cinema";
    
    
    private static final String BTN_CONTROLLER_ACCOUNT_TITLE = "MANAGE ACCOUNT";
    private static final String BTN_CONTROLLER_PROGRAMMED_FILM_TITLE = "MANAGE PROGRAMMED FILM";
    private static final String BTN_CONTROLLER_FILM_TITLE = "MANAGE FILM";
    private static final String BTN_CONTROLLER_TICKET_TITLE  = "MANAGE TICKET";
    private static final String BTN_CONTROLLER_STATISTICS_TITLE = "MANAGE STATISTICS";
    private static final String ACCOUNT_LOGGED_STRING = "Username logged: ";
    
    private static final Color COLOR_BORDER_NORTH_PANEL = Color.BLACK;
    private static final String MENU_STRING = "MENU";
    
    
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
        final JPanel northPanel = new JPanel(new BorderLayout());
        
        this.frame.setTitle(TITLE_FRAME);
        
        final LoggedAccount log = LoggedAccount.getIstance();
        final Account accountLogged = log.getAccount();
        final String accountString = ACCOUNT_LOGGED_STRING + accountLogged.getUsername();
        
        final JLabel labelAccount = new JLabel(accountString, SwingConstants.RIGHT);
        labelAccount.setHorizontalAlignment(SwingConstants.CENTER);
        labelAccount.setVerticalAlignment(SwingConstants.CENTER);
        
        
        final JLabel labelMenu = new JLabel(MENU_STRING);
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        labelMenu.setVerticalAlignment(SwingConstants.CENTER);

        northPanel.setBorder(BorderFactory.createLineBorder(COLOR_BORDER_NORTH_PANEL));
        northPanel.add(labelMenu, BorderLayout.CENTER);  
        northPanel.add(labelAccount, BorderLayout.EAST);
        
        
        final JPanel centerPanel = new JPanel(new FlowLayout());
        btnControllerAccount.setPreferredSize(this.increaseSize(btnControllerAccount.getPreferredSize()));
        btnControllerFilm.setPreferredSize(this.increaseSize(btnControllerFilm.getPreferredSize()));
        btnControllerProgrammingFilms.setPreferredSize(this.increaseSize(btnControllerProgrammingFilms.getPreferredSize()));
        btnControllerStatistics.setPreferredSize(this.increaseSize(btnControllerStatistics.getPreferredSize()));
        btnControllerTicket.setPreferredSize(this.increaseSize(btnControllerTicket.getPreferredSize()));
        centerPanel.add(btnControllerAccount);
        centerPanel.add(btnControllerFilm);
        centerPanel.add(btnControllerProgrammingFilms);
        centerPanel.add(btnControllerStatistics);
        centerPanel.add(btnControllerTicket);

        btnControllerAccount.addActionListener(a -> {
            this.observer.showControllerAccount();
            frame.dispose();
        });
        btnControllerProgrammingFilms.addActionListener(a -> {
            this.observer.showControllerProgrammingFilms();
            frame.dispose();
        });
        btnControllerTicket.addActionListener(a -> {
            this.observer.showControllerTicket();
            frame.dispose();
        });
        btnControllerFilm.addActionListener(a -> {
            this.observer.showControllerFilm();
            frame.dispose();
        });
        btnControllerStatistics.addActionListener(a -> {
            this.observer.showControllerStatistics();
            frame.dispose();
        });
        
        if (accountLogged.isAdmin().equals(TypeAccount.OPERATOR)) {
            btnControllerAccount.setEnabled(false);
            btnControllerProgrammingFilms.setEnabled(false);
            btnControllerFilm.setEnabled(false);
            btnControllerStatistics.setEnabled(false);
        }
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(northPanel, BorderLayout.NORTH);
      
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setMinimumSize(new Dimension((int) (screenSize.getWidth() * WIDTH_MINIMUM_FRAME), (int) (screenSize.getHeight() * HEIGTH_MINMUM_FRAME)));

       frame.getContentPane().add(mainPanel);
       frame.setLocationByPlatform(true);
    }
    public void setObserver(final CinemaControllerObserver observer) {
        this.observer = observer;
    }
    public void show() {
        frame.setVisible(true);
    }
    private Dimension increaseSize(Dimension dimension) {
        return new Dimension((int)(dimension.getWidth()*1.5),(int)(dimension.getHeight()*1.5));
    }
}
