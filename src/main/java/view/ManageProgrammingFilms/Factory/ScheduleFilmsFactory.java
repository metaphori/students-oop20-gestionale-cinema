package view.ManageProgrammingFilms.Factory;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import viewImpl.ManageProgrammingFilms.DatePanel;
import viewImpl.ManageProgrammingFilms.TimePanel;
import viewImpl.ManageProgrammingFilms.factory.InfoProgrammationPanel;

public interface ScheduleFilmsFactory {
	
	TimePanel getTimePanel();
	DatePanel getDatePanel();
	JPanel getBottomPanel(ActionListener al);
	InfoProgrammationPanel getInfoProgrammationPanel(List<Integer> halls);

}
