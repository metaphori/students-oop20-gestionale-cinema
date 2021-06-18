package view.ManageProgrammingFilms.Factory;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import controller.ManageFilms.FilmsController;
import viewImpl.ManageProgrammingFilms.factory.DatePanel;
import viewImpl.ManageProgrammingFilms.factory.InfoProgrammationPanel;
import viewImpl.ManageProgrammingFilms.factory.TimePanel;

public interface ScheduleFilmsFactory {
	
	TimePanel getTimePanel();
	DatePanel getDatePanel();
	JPanel getBottomPanel(ActionListener al);
	InfoProgrammationPanel getInfoProgrammationPanel(FilmsController filmsController);

}
