package view;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface InfoFilmsGUIfactory {

    JPanel  createPanel(LayoutManager layout);
    JButton createButtonWithText(String text);
    JButton createButtonWithIcon(Icon icon);
    JTextField createTextField(String text);
    JTextArea createTextArea(String text);
    ImageIcon getScaledIcon(ImageIcon icon, int width, int height);

}
