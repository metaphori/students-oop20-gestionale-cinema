package view.ManageMenu;

import controller.CinemaController;
import controller.CinemaControllerObserver;
import utilities.ManageAccounts.Account;

public interface MenuView {
    void setObserver(CinemaControllerObserver observer);
    void show();
    void updateGUI(Account accountLogged);
}
