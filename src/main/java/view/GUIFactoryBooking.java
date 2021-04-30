package view;

import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import utilities.ProgrammedFilm;

public interface GUIFactoryBooking {
    JFrame getBaseFrame(String title);
    JPanel getInfoPanel(String info);
    JButton getButtonImage(String title, String path);
    JTable getTable(Set<ProgrammedFilm> film);
    
}