package view.ManageFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
    Factory to create components for container films GUI.
*/

public interface ContainerFilmsGUIfactory {
    /**
        Creates personalized panel using specific layout manager.
        @param layout layout to used.
     */
    JPanel createPanel(LayoutManager layout);
    /**
        Creates personalized button using with specific text.
        @param text text to used.
     */
    JButton createButtonWithText(String text);
    /**
        Creates personalized button with icon.
        @param icon icon to used.
     */
    JButton createButtonWithIcon(Icon icon);

}
 