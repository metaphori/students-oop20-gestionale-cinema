package view.ManageFilms;

import controller.FilmsController;

public interface InfoFilmsGUI {
    void start();
    void setObserver(FilmsController controller);
    //void loadFilm();
}
