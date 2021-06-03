package view.ManageProgrammingFilms;

import controller.ManageProgrammingFilms.ProgrammingFilmsController;

public interface ScheduleFilmsGUI {
    void start();
    void setObserver(ProgrammingFilmsController observer);
    void update();
}
