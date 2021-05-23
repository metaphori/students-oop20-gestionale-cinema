package viewImpl.ManageFilms;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.FutureTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;


import controller.FilmsController;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.Factory.FilmFactory;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import view.ManageFilms.ContainerFilmsGUI;
import view.ManageFilms.Factory.ContainerFilmsGUIfactory;
import view.ManageFilms.Factory.InfoFilmsGUIfactory;
import view.ManageFilms.Factory.PanelFilmFactory;
import view.Settings.InfoFilmSettingsDefault;
import viewImpl.ManageFilms.Factory.ContainerFilmsGUIfactoryImpl;
import viewImpl.ManageFilms.Factory.PanelFilmFactoryImpl;

public class ContainerFilmsGUIimpl implements ContainerFilmsGUI {

    private static final long serialVersionUID = 7114066347061701832L;

    private static final String FRAME_NAME = "Container Films";
    private static final double PROPORTION = 1.15;
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFrame frame = new JFrame(FRAME_NAME);
    //Components
    private final PanelFilmFactory factoryFilmPanel = new PanelFilmFactoryImpl();
    private final ContainerFilmsGUIfactory factory = new ContainerFilmsGUIfactoryImpl();
    private final JButton add = new JButton("Add");
    private final JButton home = new JButton("Home");

    private final Container container = frame.getContentPane();
    private FilmsController observer;
    private Map<JButton, Film> map = new HashMap<>();
    
    //real dimension of the screen
    private final int screenWidth = (int) screen.getWidth();
    private final int screenHeight = (int) screen.getHeight();
    //real dimension of my frame
    private final int frameWidth = (int) (screenWidth / PROPORTION);
    private final int frameHeight = (int) (screenHeight / PROPORTION);

    private JPanel centerPanel;
    final ActionListener al;

    public ContainerFilmsGUIimpl(final Set<Film> setFilm) {

    JPanel mainPanel = factory.createPanel(new BorderLayout());
    final JPanel northPanel = factory.createPanel(new FlowLayout(FlowLayout.RIGHT));
    final JPanel southPanel = factory.createPanel(new FlowLayout(FlowLayout.CENTER));
    centerPanel = new JPanel();
    centerPanel.add(factoryFilmPanel.getFilmPanel(map, setFilm));
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

    northPanel.add(home);
    southPanel.add(add);

     al = (e) -> { 
        //this is what must be done when users click on specific film . So specific film gui must be viewed
        final JButton selectedFilm = (JButton) e.getSource(); 
        System.out.println("key" + map.containsKey(selectedFilm));
        final Film film = map.get(selectedFilm);
        frame.setVisible(false);
        System.out.println("ActionListener:" + map + " ");
        observer.showInfoFilmView(film);
    };
    //add action listener to every buttons
    for (final var button: map.keySet()) {
        button.addActionListener(al);
    }

    add.addActionListener(event -> {
        observer.showNewFilmView();
        frame.setVisible(false);
    });

    home.addActionListener(event -> {
        observer.showMenu();
        frame.setVisible(false);
    }
    );


    container.add(mainPanel);
    frame.pack();
    frame.setSize(frameWidth, frameHeight);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
    frame.validate();
    

    }

    @Override
    public void start() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        if(observer.getFilms().isEmpty()) {
            this.showNoFilmsDialog();
        }
    }

    @Override
    public void setObserver(final FilmsController observer) {
        this.observer = observer;
    }
    @Override
    public void update() {//Reset map, take new films and rebuild central panel
        map.clear();
        centerPanel.remove(0); //remove first child

        Set<Film> film = new HashSet<>(observer.getFilms());
        
        centerPanel.add(factoryFilmPanel.getFilmPanel(map, film));
        for (final var button: map.keySet()) {
            button.addActionListener(al);
        }
        centerPanel.validate();
        frame.validate();
    }
    
    private void showNoFilmsDialog() {
        JOptionPane.showMessageDialog(frame,"There aren't films! Please click on Add button down below to insert a new Film");
    }
}
