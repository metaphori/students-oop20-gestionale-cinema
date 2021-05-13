package view.ManageFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

public interface ContainerFilmsGUIfactory {
    JPanel createPanel(LayoutManager layout);
    JButton createButtonWithText(String text);
    JButton createButtonWithIcon(Icon icon);

}
 