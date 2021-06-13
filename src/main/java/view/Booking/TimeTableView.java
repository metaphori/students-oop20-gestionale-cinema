package view.Booking;

import java.util.Collection;

import utilities.Factory.ProgrammedFilm;

public interface TimeTableView {
    void show();
    void checkEmptyProgrammation(Collection<ProgrammedFilm> collProgrammedFilm);

}
