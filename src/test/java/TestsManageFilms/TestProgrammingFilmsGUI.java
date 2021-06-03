package TestsManageFilms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.InputOutput.RWfile;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageProgrammingFilms.HandlerList;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.FilterByDateHallImpl;
import modelImpl.ManageProgrammedFilms.FilterByDateImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.SorterByHallImpl;
import modelImpl.ManageProgrammedFilms.SorterByTimeImpl;
import utilities.Film;
import utilities.TimeSlot;
import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.TimeSlotFactory;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;

class TestProgrammingFilmsGUI {

    @Test
    void testStart() {
        final ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
    }

        
    @Test
    void test() {
        
    }
}
