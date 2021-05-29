package view.ManageProgrammingFilms;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mindfusion.scheduling.Calendar;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;

public interface ProgrammingFilmsGUI {
    
    void start();
    void setObserver(ProgrammingFilmsController observer);
    void update();
    
}
