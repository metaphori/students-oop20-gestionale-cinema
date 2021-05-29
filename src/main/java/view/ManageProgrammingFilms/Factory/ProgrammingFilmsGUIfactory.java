package view.ManageProgrammingFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.mindfusion.scheduling.Calendar;

public interface ProgrammingFilmsGUIfactory {
    JPanel createPanel(LayoutManager layout);
    JButton createButton(String text);
    Calendar createCalendar();
    JScrollPane createScrollableTable(String [] columnNames,Object[][] data);
}
