package view.booking;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.SeatState;

public interface GUIFactoryBooking {
    JFrame getBaseFrame(String title);
    JPanel getInfoPanel(String info, ActionListener action);
    JButton getButtonImage(ImageIcon icon);
    JTable getTable(Set<ProgrammedFilm> film);
    JButton getButtonSeat(SeatState state, int i, int j);
    DefaultTableModel getModel(Collection<ProgrammedFilm> film);
    JLabel getLabelImage(ImageIcon icon, int width, int height);

}
