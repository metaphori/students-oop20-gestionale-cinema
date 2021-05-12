package viewImpl;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.Film;
import view.PanelFilmFactory;


public class PanelFilmFactoryImpl implements PanelFilmFactory {
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGHT_PERC_FRAME = 0.5;
    
    private static final double WIDTH_IMAGE = WIDTH_PERC_FRAME / 5;
    private static final double HEIGHT_IMAGE = HEIGHT_PERC_FRAME / 2;
    
    @Override
    public JPanel getFilmPanel(Map<JButton,Film> mapFilm, Set<Film> setFilm) {
        JPanel centralPanel = new JPanel(new WrapLayout());
        for (var film : setFilm) {
           
       //     mapFilm.put(this.getButtonImage(film.getTitle(), film.getCoverPath()), film);
        }
        for (var bt : mapFilm.keySet()) {
            centralPanel.add(bt);
            
        }
        return centralPanel;
    }
    
    
    
    
    private JButton getButtonImage(String title, String path) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance((int) (screenSize.getWidth() * WIDTH_IMAGE), (int) (screenSize.getHeight() * HEIGHT_IMAGE),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
      
        JButton button = new JButton("Title:" + title, imageIcon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.TOP);
        button.setMargin(new Insets(0, 0, 0, 0));
        return button;
    }




}
