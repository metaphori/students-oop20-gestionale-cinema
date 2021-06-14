package viewImpl.ManageFilms.Factory;

import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.ManageFilms.Factory.InfoFilmsGUIfactory;


public final class InfoFilmsGUIfactoryImpl implements InfoFilmsGUIfactory {

    /**
     * Creates personalized basic panel.
     * @param layout to use
     * @return personalized panel.
     */
    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }
    /**
     * Creates personalized button.
     * @param text to insert
     * @return personalized button.
     */
    @Override
    public JButton createButtonWithText(final String text) {
        return new JButton(text);
    }
    /**
     * Creates personalized button with icon.
     * @param icon to add
     * @return personalized button.
     */
    @Override
    public JButton createButtonWithIcon(final Icon icon) {
        return new JButton(icon);
    }
    /**
     * Creates personalized text field.
     * @param text to insert
     * @return personalized text field.
     */
    @Override
    public JTextField createTextField(final String text) {
        return new JTextField(text);
    }
    /**
     * Creates personalized text area.
     * @param text to insert
     * @return personalized text area.
     */
    @Override
    public JTextArea createTextArea(final String text) {
        return new JTextArea(text);
    }
    /**
     * Get scaled icon with specific width and height .
     * @param icon 
     * @param width
     * @param height
     * @return personalized ImageIcon.
     */
    @Override
    public ImageIcon getScaledIcon(final ImageIcon icon, final int width, final int height) {
        final Image image = icon.getImage(); // transform it
        final Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        return new ImageIcon(newimg); // transform it back
    }
}
