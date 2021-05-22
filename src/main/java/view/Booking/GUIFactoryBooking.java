package view.Booking;

import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import utilities.ProgrammedFilm;
import utilitiesImpl.SeatState;

public interface GUIFactoryBooking {
    JFrame getBaseFrame(String title);
    JPanel getInfoPanel(String info, ActionListener action);
    JButton getButtonImage(String title, String path);
    JTable getTable(Set<ProgrammedFilm> film);
    JButton getButtonSeat(SeatState state, int i,int j);
}
