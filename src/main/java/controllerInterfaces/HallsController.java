package controllerInterfaces;

import java.util.Collection;

import utilities.Hall;

public interface HallsController {

	public void addHall(Hall newHall);
	public void removeHall(Hall oldHall);
	
	public Collection <Hall> getHalls();
	
	public void showHallsView();
	
	public void showMenu();
	
	
}
