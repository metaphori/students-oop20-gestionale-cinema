package view.ManageProgrammingFilms;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;

public interface ScheduleFilmsGUI {
    void start();
    void setObserver(ProgrammingFilmsController observer);
    void update();
    void setFilmsController(FilmsController filmsController);
    void reset();
}
