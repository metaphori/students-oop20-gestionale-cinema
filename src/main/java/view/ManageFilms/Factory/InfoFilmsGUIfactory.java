package view.ManageFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface InfoFilmsGUIfactory {
    /**
     * Creates personalized panel.
     * @param layout to use
     * @return personalized panel.
     */
    JPanel  createPanel(LayoutManager layout);
    /**
     * Creates personalized button.
     * @param text to insert
     * @return personalized button.
     */
    JButton createButtonWithText(String text);
    /**
     * Creates personalized button with icon.
     * @param icon to add
     * @return personalized button.
     */
    JButton createButtonWithIcon(Icon icon);
    /**
     * Creates personalized text field.
     * @param text to insert
     * @return personalized text field.
     */
    JTextField createTextField(String text);
    /**
     * Creates personalized text area.
     * @param text to insert
     * @return personalized text area.
     */
    JTextArea createTextArea(String text);
    /**
     * Get scaled icon with specific width and height .
     * @param icon
     * @param width
     * @param height
     * @return personalized ImageIcon.
     */
    ImageIcon getScaledIcon(ImageIcon icon, int width, int height);

}
