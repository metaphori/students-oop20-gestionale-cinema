package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface GUIFactoryBooking {
    JFrame getBaseFrame(String title);
    JPanel getInfoPanel(String info);
    JButton getButtonImage(String title, String path);
    
}
