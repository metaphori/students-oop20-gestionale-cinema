package viewImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.GUIFactoryBooking;

public class GUIFactoryBookingImpl implements GUIFactoryBooking {
    private static final double WIDTH_PERC_FRAME = 0.5;
    private static final double HEIGHT_PERC_FRAME = 0.5;
    
    private static final double WIDTH_IMAGE = WIDTH_PERC_FRAME / 5;
    private static final double HEIGHT_IMAGE = HEIGHT_PERC_FRAME / 2;
    
    private static final Color COLOR_BORDER_INFOPANEL = Color.black;
   
    public JFrame getBaseFrame(String title) {
        final JFrame frame = new JFrame();
 
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) (screenSize.getWidth() * WIDTH_PERC_FRAME), (int) (screenSize.getHeight() * HEIGHT_PERC_FRAME));
  
        frame.setTitle(title);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        return frame;
    }
    
    public JPanel getInfoPanel(String info) {
        JPanel infoPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(info);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        infoPanel.add(label,BorderLayout.CENTER);
        infoPanel.setBorder(BorderFactory.createLineBorder(COLOR_BORDER_INFOPANEL));
        return infoPanel;
    }
    
    public JButton getButtonImage(String title, String path) {
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
