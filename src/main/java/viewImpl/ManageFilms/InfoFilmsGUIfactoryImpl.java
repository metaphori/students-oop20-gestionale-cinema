package viewImpl.ManageFilms;

import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.ManageFilms.InfoFilmsGUIfactory;
import view.Settings.InfoFilmSettingsDefault;

public class InfoFilmsGUIfactoryImpl implements InfoFilmsGUIfactory {

    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }

    @Override
    public JButton createButtonWithText(final String text) {
        return new JButton(text);
    }

    @Override
    public JButton createButtonWithIcon(final Icon icon) {
        return new JButton(icon);
    }

    @Override
    public JTextField createTextField(final String text) {
        return new JTextField(text);
    }

    @Override
    public JTextArea createTextArea(final String text) {
        return new JTextArea(text);
    }

    @Override
    public ImageIcon getScaledIcon(final ImageIcon icon, final int width, final int height) {
        final Image image = icon.getImage(); // transform it
        final Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg); // transform it back
       
    }

 

   

   
}
