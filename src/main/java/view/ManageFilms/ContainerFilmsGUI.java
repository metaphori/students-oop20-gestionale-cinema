package view.ManageFilms;

import controller.FilmsController;

public interface ContainerFilmsGUI {
    void start();
    void setObserver(FilmsController observer);
}
