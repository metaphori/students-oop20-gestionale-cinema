package TestsManageFilms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import controllerImpl.InputOutput.*;
import controllerImpl.InputOutput.RWobject;
import model.ManageFilms.ContainerFilmsModel;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
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

class TestProgrammationFilms {
    @Test
    void testAvailability() {
        LocalDate ld1 = LocalDate.of(1999, 3, 6);    
        LocalDate ld2 = LocalDate.of(1999, 3, 7); 
        LocalDate ld3 = LocalDate.of(1999, 3, 6); 
        
        LocalTime st1 = LocalTime.of(8, 30);
        LocalTime st2 = LocalTime.of(6, 50);
        LocalTime st3 = LocalTime.of(8, 27);
        
        LocalTime et1 = LocalTime.of(8, 45);
        LocalTime et2 = LocalTime.of(7, 22);
        LocalTime et3 = LocalTime.of(8, 29);
        
        ProgrammedFilmFactoryImpl factory = new ProgrammedFilmFactoryImpl();
        ProgrammedFilm pf1 = factory.createProgrammedFilm(12, 8, 56, ld1, st1, et1);
        ProgrammedFilm pf2 = factory.createProgrammedFilm(13, 9, 56, ld2, st2, et2);
        ProgrammedFilm pf3 = factory.createProgrammedFilm(14, 1, 56, ld3, st3, et3);
        
        ProgrammedFilmsModelImpl model = new ProgrammedFilmsModelImpl() ;
   /*     
        model.addFilmProgrammation(pf1);
        model.addFilmProgrammation(pf2);
        model.addFilmProgrammation(pf3);
        */
        /*TimeSlotFactory factoryTimeSlot = new TimeSlotFactoryImpl();
        TimeSlot timeSlotToTest = factoryTimeSlot.createTimeSlot(LocalTime.of(8,31),LocalTime.of(8, 44));
        LocalDate localDateToTest = LocalDate.of(1999, 3, 7);
        
        System.out.println(model.isAvailableProgrammation(timeSlotToTest, localDateToTest, 8));*/
        //System.out.println(model.getManagerProgrammingFilms().sortListByHall(model.getAllProgrammedFilm()));
        
    }
    
    
    
    
    


}
