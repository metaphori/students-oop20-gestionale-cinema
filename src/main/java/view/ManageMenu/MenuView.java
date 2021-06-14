package view.ManageMenu;

import controller.CinemaController;
import controller.CinemaControllerObserver;

public interface MenuView {
    void setObserver(CinemaControllerObserver observer);
    void show();
}
