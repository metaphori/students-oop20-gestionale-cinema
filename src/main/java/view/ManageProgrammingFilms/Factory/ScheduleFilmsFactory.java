package view.ManageProgrammingFilms.Factory;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

import controller.ManageFilms.FilmsController;
import viewImpl.ManageProgrammingFilms.factory.DatePanel;
import viewImpl.ManageProgrammingFilms.factory.InfoProgrammationPanel;
import viewImpl.ManageProgrammingFilms.factory.TimePanel;
/** 
 * 
 * Factory to create components for schedule films view.*/
public interface ScheduleFilmsFactory {
    /** 
     * Get time panel.
     * */
    TimePanel getTimePanel();
    /** 
     * Get date panel.
     * */
    DatePanel getDatePanel();
    /** 
     * Get bottom panel.
     * @param al action listener to add for button
     * */
    JPanel getBottomPanel(ActionListener al);
    /** 
     * Get info programmation panel.
     * @param filmsController films controller
     * */
    InfoProgrammationPanel getInfoProgrammationPanel(FilmsController filmsController);

}
