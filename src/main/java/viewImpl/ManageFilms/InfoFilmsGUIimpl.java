package viewImpl.ManageFilms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import utilities.Film;
import view.ManageFilms.ContainerFilmsGUI;
import view.ManageFilms.InfoFilmsGUI;
import view.ManageFilms.Factory.InfoFilmsGUIfactory;
import view.Settings.InfoFilmSettingsDefault;
import viewImpl.ManageFilms.Factory.InfoFilmsGUIfactoryImpl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import org.apache.commons.io.*;

import controller.FilmsController;

public class InfoFilmsGUIimpl implements InfoFilmsGUI {
	
	private static final long serialVersionUID = 7114066347061701832L;
	
	private final InfoFilmsGUIfactory factory = new InfoFilmsGUIfactoryImpl();
	
        private static final String FRAME_NAME = "Info film";
        private static final double PROPORTION = 1.15;
        private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        private final JFrame frame = new JFrame(FRAME_NAME);
        private final Container container = frame.getContentPane();
        private FilmsController observer;
        
        private final JTextField duration = factory.createTextField("Duration (minutes)");
        private final JTextField genre = factory.createTextField("Genre");
        private final JTextArea description = factory.createTextArea("Description");
        private final JButton save = factory.createButtonWithText("Save");
        private final JButton delete = factory.createButtonWithText("Delete");
        private final JButton home = factory.createButtonWithText("Home");
        private final JButton back = factory.createButtonWithText("Back");
        private final JButton pic = factory.createButtonWithText("");
        private final JTextField title = factory.createTextField("Title");
        //real dimension of the screen
        private final int screenWidth = (int) screen.getWidth();
        private final int screenHeight = (int) screen.getHeight();
        //real dimension of my frame
        private final int frameWidth = (int) (screenWidth / PROPORTION);
        private final int frameHeight = (int) (screenHeight / PROPORTION);

        public InfoFilmsGUIimpl() {	
	
        final JPanel mainPanel = factory.createPanel(new BorderLayout());
        final JPanel centralPanel = factory.createPanel(new BorderLayout());
        final JPanel westPanel = factory.createPanel(new BorderLayout());
        final JPanel southPanel = factory.createPanel(new BorderLayout());
        final JPanel northPanel = factory.createPanel(new BorderLayout());

        final URL imgURL = ClassLoader.getSystemResource("images/filmStandardIco.png");
	ImageIcon icon = new ImageIcon(imgURL);
	/*
        final Image image = icon.getImage(); // transform it
        final Image newimg = image.getScaledInstance((int) (frameWidth / InfoFilmSettingsDefault.ImageWidthProportion), (int) (frameHeight / InfoFilmSettingsDefault.ImageHeightProportion), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    	icon = new ImageIcon(newimg); // transform it back
        */
	pic.setIcon(
	        factory.getScaledIcon(icon, (int) (frameWidth / InfoFilmSettingsDefault.ImageWidthProportion), (int) (frameHeight / InfoFilmSettingsDefault.ImageHeightProportion))
	);
	
    	pic.setMargin(new Insets(0, 0, 0, 0));
	pic.setPreferredSize(new Dimension((int) (frameWidth / InfoFilmSettingsDefault.ImageWidthProportion), (int) (frameHeight / InfoFilmSettingsDefault.ImageHeightProportion)));
	
	
	final JPanel firstInfoPanel =  factory.createPanel(new FlowLayout(FlowLayout.LEFT, InfoFilmSettingsDefault.HgapFlowLayout, InfoFilmSettingsDefault.VgapFlowLayout));
	final JPanel secondInfoPanel =  factory.createPanel(new FlowLayout(FlowLayout.LEFT, InfoFilmSettingsDefault.HgapFlowLayout, InfoFilmSettingsDefault.VgapFlowLayout));
	final JPanel actionPanel = factory.createPanel(new FlowLayout(FlowLayout.CENTER));
	
	mainPanel.add(centralPanel, BorderLayout.CENTER);
	mainPanel.add(southPanel, BorderLayout.SOUTH);
	mainPanel.add(northPanel, BorderLayout.NORTH);
	mainPanel.add(westPanel, BorderLayout.WEST); 
	northPanel.add(back, BorderLayout.WEST);
	back.setPreferredSize(new Dimension(frameHeight / InfoFilmSettingsDefault.ButtonHeightProportion, frameWidth / InfoFilmSettingsDefault.ButtonWidthProportion));
	northPanel.add(home, BorderLayout.EAST);
	home.setPreferredSize(new Dimension(frameHeight / InfoFilmSettingsDefault.ButtonHeightProportion, frameWidth / InfoFilmSettingsDefault.ButtonWidthProportion));
	southPanel.add(actionPanel, BorderLayout.SOUTH);
	actionPanel.add(save);
	actionPanel.add(delete);
	
	southPanel.add(description, BorderLayout.NORTH);
	westPanel.add(pic, BorderLayout.NORTH);
	centralPanel.add(firstInfoPanel, BorderLayout.WEST);
	centralPanel.add(secondInfoPanel, BorderLayout.CENTER);
	title.setPreferredSize(new Dimension(frameWidth / InfoFilmSettingsDefault.JTextFieldHeightProportion, frameWidth / InfoFilmSettingsDefault.JTextFieldWidthProportion));
	duration.setPreferredSize(new Dimension(frameWidth / InfoFilmSettingsDefault.JTextFieldHeightProportion, frameWidth / InfoFilmSettingsDefault.JTextFieldWidthProportion));
	genre.setPreferredSize(new Dimension(frameWidth / InfoFilmSettingsDefault.JTextFieldHeightProportion, frameWidth / InfoFilmSettingsDefault.JTextFieldWidthProportion));
	firstInfoPanel.add(title);
	firstInfoPanel.add(duration);
	secondInfoPanel.add(genre);
	description.setPreferredSize(new Dimension(frameWidth, frameHeight / InfoFilmSettingsDefault.JTEXTAREAHEIGHTPROPORTION));
	container.add(mainPanel);
	frame.pack();
	
	
	//this.display();
	frame.setSize(frameWidth, frameHeight);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	description.addFocusListener(new FocusListener() {
	    public void focusGained(final FocusEvent e) {
	        if ("Description".equals(description.getText())) { 
	            description.setText("");
                }
	    }

	    public void focusLost(final FocusEvent e) {
	
	    }
	});
	
	genre.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Genre".equals(genre.getText())) { 
                    genre.setText("");
                }
            }

            public void focusLost(final FocusEvent e) {
            }
        });
	
	title.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
                if ("Title".equals(title.getText())) { 
                    title.setText("");
                }
            }

            public void focusLost(final FocusEvent e) {
            }
        });
	duration.addFocusListener(new FocusListener() {
            public void focusGained(final FocusEvent e) {
               if ("Duration (minutes)".equals(duration.getText())) { 
                   duration.setText("");
               }

            }

            public void focusLost(final FocusEvent e) {
            }
        });
	
	
	pic.addActionListener(e -> {
	    final JFileChooser chooser = new JFileChooser();
	    final FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG  & PNG Images", "jpg", "png", "jpeg");
	    chooser.setFileFilter(filter);
	    final int returnVal = chooser.showOpenDialog(frame);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	       final File selectedFile = chooser.getSelectedFile();
	       final File destFile = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "test");
	       try {
	           FileUtils.copyFile(selectedFile, destFile);
	       } catch (IOException exception) {
	           exception.printStackTrace();
	       }
	    }
	}
	
	
	
	
	
	);
	
	
	
	
	
	
	
	frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
	frame.validate();
	
	}
	
	
    @Override	
    public void loadFilm(final Film film) {
	    title.setText(film.getName());
	    genre.setText(film.getGenre());
	    duration.setText(new Integer(film.getDuration()).toString());
	    description.setText(film.getDescription());
	    if (film.getCoverPath().isPresent()) {
                final ImageIcon icon = new ImageIcon(film.getCoverPath().get());
                pic.setIcon(
                        factory.getScaledIcon(icon, (int) (frameWidth / InfoFilmSettingsDefault.ImageWidthProportion), (int) (frameHeight / InfoFilmSettingsDefault.ImageHeightProportion))
                );
            } else {
                final URL imgURL = ClassLoader.getSystemResource("images/filmStandardIco.png");
                final ImageIcon icon = new ImageIcon(imgURL);
                pic.setIcon(factory.getScaledIcon(icon, (int) (frameWidth / InfoFilmSettingsDefault.ImageWidthProportion), (int) (frameHeight / InfoFilmSettingsDefault.ImageHeightProportion)));
            }
	}	
	
	


    @Override
    public void start() {
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    @Override
    public void setObserver(final FilmsController observer) {
        this.observer = observer;
    }
    
    /*
    public static void main(String[] args) {
        InfoFilmsGUIimpl view = new InfoFilmsGUIimpl();
    }
*/
}




