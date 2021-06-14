package viewImpl.ManageProgrammingFilms.factory;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ManageFilms.FilmsController;
import view.ManageProgrammingFilms.Factory.ScheduleFilmsFactory;


public class ScheduleFilmsFactoryImpl implements ScheduleFilmsFactory {
    
    @Override
    public JPanel getBottomPanel(final ActionListener al) {
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        final JButton scheduleButton = new JButton("Schedule");
        scheduleButton.addActionListener(al);
        buttonPanel.add(scheduleButton);
        panel.add(buttonPanel, scheduleButton);
        return panel;
    }

    @Override
    public TimePanel getTimePanel() {
        return new TimePanel();
    }

    @Override
    public DatePanel getDatePanel() {
        return new DatePanel();
    }

    @Override
    public InfoProgrammationPanel getInfoProgrammationPanel(FilmsController filmsController) {
        return new InfoProgrammationPanel(filmsController);
    }

    


    
    

}
