package view.ManageFilms;

import controller.ManageFilms.FilmsController;

public interface ContainerFilmsGUI {
    void start();
    void setObserver(FilmsController observer);
    void update();
}
