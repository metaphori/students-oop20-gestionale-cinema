
package application;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;


import controller.ManageAccounts.AccountsController;

import controller.CinemaController;
import controller.Booking.BookingController;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.CinemaControllerImpl;
import controllerImpl.Booking.BookingControllerImpl;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.ManageAccounts.AccountsControllerImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import exceptions.ProgrammationNotAvailableException;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.IdsGenerator;
import model.ManageFilms.ManagerIdsFilms;
import model.ManageProgrammingFilms.HandlerList;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Film;

import utilities.Factory.FilmFactory;

import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.SeatTypeAccount;
import utilities.ManageAccounts.TypeAccount;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.ManageAccounts.AccountImpl;

import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;



public class Cinema {
    
    

    public static void main(final String[] args){


        
        
        //ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        
       // ProgrammingFilmsGUI gui = new ProgrammingFilmsGUIimpl();
        
        //controller.addProgrammedFilm(null);
        
       /*
        final ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        final ProgrammedFilmFactory factory = new ProgrammedFilmFactoryImpl();
        
       
        final LocalDate ld1 = LocalDate.of(2021, 6, 3);    
        final LocalDate ld2 = LocalDate.of(2021, 6, 3); 
        final LocalDate ld3 = LocalDate.of(2021, 6, 4); 
        
        final LocalTime st1 = LocalTime.of(8, 30);
        final LocalTime st2 = LocalTime.of(6, 50);
        final LocalTime st3 = LocalTime.of(8, 27);
        
        final LocalTime et1 = LocalTime.of(8, 45);
        final LocalTime et2 = LocalTime.of(7, 22);
        final LocalTime et3 = LocalTime.of(8, 29);
        final ProgrammedFilm pf1 = factory.createProgrammedFilm(12, 8, 56, ld1, st1, et1);
        final ProgrammedFilm pf2 = factory.createProgrammedFilm(13, 9, 56, ld2, st2, et2);
        final ProgrammedFilm pf3 = factory.createProgrammedFilm(14, 1, 56, ld3, st3, et3);
        final ProgrammedFilm pf4 = factory.createProgrammedFilm(15, 9, 56, ld2, st3, et3);
       
       controller.addProgrammedFilm(pf1);
       controller.addProgrammedFilm(pf2);
       controller.addProgrammedFilm(pf3);
       controller.addProgrammedFilm(pf4);
       
       System.out.println(controller.getAllProgrammedFilms());
       controller.showProgrammedFilmView();*/
       
       
        /*
        Film f1 = filmFactory.createBasicFilm("Spiderman", "", "", Optional.ofNullable(null), 50);
        Film f2 = filmFactory.createBasicFilm("Batman", "", "", Optional.ofNullable(null), 200);
        Film f3 = filmFactory.createBasicFilm("Thor", "", "", Optional.ofNullable(null), 180);
        
        
        final LocalDate ld1 = LocalDate.of(2021, 6, 4);    
        final LocalDate ld2 = LocalDate.of(2021, 6, 4); 
        final LocalDate ld3 = LocalDate.of(2021, 6, 4); 
        
        final LocalTime st1 = LocalTime.of(8, 30);
        final LocalTime st2 = LocalTime.of(6, 50);
        final LocalTime st3 = LocalTime.of(8, 27);
        
        final LocalTime et1 = LocalTime.of(8, 45);
        final LocalTime et2 = LocalTime.of(7, 22);
        final LocalTime et3 = LocalTime.of(8, 29);
        final ProgrammedFilm pf1 = programmedFilmFactory.createProgrammedFilm(2, 8, 56, ld1, st1, et1);
        final ProgrammedFilm pf2 = programmedFilmFactory.createProgrammedFilm(1, 9, 56, ld2, st2, et2);
        final ProgrammedFilm pf3 = programmedFilmFactory.createProgrammedFilm(3, 1, 56, ld3, st3, et3);
        
        
        filmsController.addFilm(f1);
        filmsController.addFilm(f2);
        filmsController.addFilm(f3);
        
        try {
            programmingFilmsController.addProgrammedFilm(pf1);
            programmingFilmsController.addProgrammedFilm(pf2);
            programmingFilmsController.addProgrammedFilm(pf3);
  
        }catch(Exception e) {
            System.out.println("eccezione");
        };
        
        
        
        
        System.out.println(filmsController.getFilms());
        */
        /*
        final ProgrammingFilmsController programmingFilmsController = new ProgrammingFilmsControllerImpl();
        final FilmsController filmsController = programmingFilmsController.getFilmsController();
        
        FilmFactory filmFactory = new FilmFactoryImpl(filmsController.getManagerIdsFilms());
        
        ProgrammedFilmFactory programmedFilmFactory = new ProgrammedFilmFactoryImpl();
        Film f1 = filmFactory.createBasicFilm("Spiderman", "", "", Optional.ofNullable(null), 50);
        filmsController.addFilm(f1);
        programmingFilmsController.showProgrammedFilmView();
        
        */
        
        
        
        
        
        //programmingFilmsController.showScheduleFilmView();
        /*
       
        
       /*
        ProgrammingFilmsController programmingFilmsController = new ProgrammingFilmsControllerImpl();
        programmingFilmsController.showProgrammedFilmView();*/


      //  CinemaController cinemaController = new CinemaControllerImpl();
       //  FilmsController filmsController = new FilmsControllerImpl();
     //   filmsController.showContainerFilmsView();
        ProgrammingFilmsController programmingFilmsController = new ProgrammingFilmsControllerImpl();
        programmingFilmsController.showProgrammedFilmView();


        Set<Account> setAccount = new HashSet<>();
        Account a1 = new AccountImpl("Rossi","Gianni","Ross","qwerty",TypeAccount.OPERATOR);
        Account a2 = new AccountImpl("Giacomo","Pippo","Giac","qwerty1",TypeAccount.ADMINISTRATOR);
        Account a3 = new AccountImpl("Piero","Suli","Pier","qwerty123",TypeAccount.OPERATOR);
        setAccount.add(a3);
        setAccount.add(a1);
        setAccount.add(a2);
        
      //  AccountsController controller = new AccountsControllerImpl();
      //  controller.showLoginAccounView();
        
    }
    
}
