package view.booking;

import java.util.Collection;

import utilities.factory.ProgrammedFilm;

public interface TimeTableView {
    void show();
    void checkEmptyProgrammation(Collection<ProgrammedFilm> collProgrammedFilm);

}
