package viewImpl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GUIFactoryBooking;

public class GUIFactoryBookingImpl implements GUIFactoryBooking {
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.5;
    
    public JFrame getBaseFrame(String title) {
        final JFrame frame = new JFrame();
 
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
  
        frame.setTitle(title);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        return frame;
    }
}
