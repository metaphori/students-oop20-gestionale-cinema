package view.ManageFilms;

import controllerImpl.FilmsControllerImpl;

public interface ContainerFilmsGUI {

    void setObserver(FilmsControllerImpl filmsControllerImpl);

    void start();

}
