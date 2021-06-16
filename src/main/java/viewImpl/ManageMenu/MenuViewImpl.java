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
import view.ManageMenu.MenuView;

public final class MenuViewImpl implements MenuView {
    private CinemaControllerObserver observer;
    private final JFrame frame = new JFrame();

    private static final String BTN_CONTROLLER_ACCOUNT_TITLE = "MANAGE ACCOUNT";
    private static final String BTN_CONTROLLER_PROGRAMMED_FILM_TITLE = "MANAGE PROGRAMMED FILM";
    private static final String BTN_CONTROLLER_FILM_TITLE = "MANAGE FILM";
    private static final String BTN_CONTROLLER_TICKET_TITLE  = "MANAGE TICKET";
    private static final String BTN_CONTROLLER_STATISTICS_TITLE = "MANAGE STATISTICS";

    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGTH_PERC_FRAME = 0.5;
    private static final double WIDTH_MINIMUM_FRAME = WIDTH_PERC_FRAME / 0.7;
    private static final double HEIGTH_MINMUM_FRAME = HEIGTH_PERC_FRAME / 0.7;
    
    final JButton btnControllerAccount = new JButton(BTN_CONTROLLER_ACCOUNT_TITLE);
    final JButton btnControllerFilm = new JButton(BTN_CONTROLLER_FILM_TITLE);
    final JButton btnControllerProgrammingFilms = new JButton(BTN_CONTROLLER_PROGRAMMED_FILM_TITLE);
    final JButton btnControllerStatistics = new JButton(BTN_CONTROLLER_STATISTICS_TITLE);
    final JButton btnControllerTicket = new JButton(BTN_CONTROLLER_TICKET_TITLE);

    public MenuViewImpl() {
        
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(btnControllerAccount);
        centerPanel.add(btnControllerFilm);
        centerPanel.add(btnControllerProgrammingFilms);
        centerPanel.add(btnControllerStatistics);
        centerPanel.add(btnControllerTicket);

        btnControllerAccount.addActionListener(a -> {
            this.observer.showControllerAccount();
            frame.setVisible(false);
        });
        btnControllerProgrammingFilms.addActionListener(a -> {
            this.observer.showControllerProgrammingFilms();
            frame.setVisible(false);
        });
        btnControllerTicket.addActionListener(a -> {
            this.observer.showControllerTicket();
            frame.setVisible(false);
        });
        btnControllerFilm.addActionListener(a -> {
            this.observer.showControllerFilm();
            frame.setVisible(false);
        });
        btnControllerStatistics.addActionListener(a -> {
            this.observer.showControllerStatistics();
            frame.setVisible(false);
        });
      
       
        mainPanel.add(centerPanel, BorderLayout.CENTER);
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
    public void updateGUI(Account accountLogged) {
        if (accountLogged.type().equals(TypeAccount.OPERATOR)) {
            btnControllerAccount.setEnabled(false);
            btnControllerProgrammingFilms.setEnabled(false);
            btnControllerFilm.setEnabled(false);
            btnControllerStatistics.setEnabled(false);
        }
    }
    
}
