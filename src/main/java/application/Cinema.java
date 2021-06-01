package application;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

import controller.Booking.BookingController;
import controller.ManageFilms.FilmsController;

import controllerImpl.Booking.BookingControllerImpl;

import controllerImpl.InputOutput.RWcollection;
import controllerImpl.InputOutput.RWfile;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Film;

import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;


public class Cinema {
    
    

    public static void main(final String[] args) {
/*
        final Set<Film> set = new HashSet<>();
        final ManagerIdsFilms managerIdsFilm = new ManagerIdsFilmImpl(new IdsGeneratorImpl());
        //ContainerFilmsModel model = new ContainerFilmsModelImpl();

        final FilmFactory filmFactory = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
        final Film f1 = filmFactory.createBasicFilm("Spiderman", "Action", "Nice film", Optional.ofNullable(null),120);
        final Film f2 = filmFactory.createBasicFilm("Batman", "Action", "Nice film", Optional.ofNullable(null),140);
        final Film f3 = filmFactory.createBasicFilm("Thor", "Action", "Good film", Optional.ofNullable(null),120);
        
        Film f5 = filmFactory.createBasicFilmById("ccc", "aaa", "aaa", Optional.ofNullable(null), 12, 7);
        Film f6 = filmFactory.createBasicFilmById("ccc", "aaa", "aaa", Optional.ofNullable(null), 13, 8);
        
        System.out.println(f5.equals(f6));
        set.add(f1);
        set.add(f2);
        set.add(f3);

        managerIdsFilm.getNewFilmID();
        managerIdsFilm.getNewFilmID();
        managerIdsFilm.getNewFilmID();
        
        System.out.println(managerIdsFilm.getUsedIDs());
        

       // final FilmsController filmsController = new FilmsControllerImpl(set, managerIdsFilm);*/
     //   final FilmsController filmsController = new FilmsControllerImpl();
      //  filmsController.showContainerFilmsView();
        Set<Film> set = new HashSet<>();
        final FilmFactory filmFactory = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
        final Film f1 = filmFactory.createBasicFilm("Spiderman", "Action", "Nice film", Optional.ofNullable(null),120);
        final Film f2 = filmFactory.createBasicFilm("Batman", "Action", "Nice film", Optional.ofNullable(null),140);
        final Film f3 = filmFactory.createBasicFilm("Thor", "Action", "Good film", Optional.ofNullable(null), 120);
        
        set.add(f1);
        set.add(f2);
        set.add(f3);
        LocalDate date = LocalDate.of(2000, 5, 1);
        
        Set<ProgrammedFilm> setP = new HashSet<>();
        ProgrammedFilmFactory fP = new ProgrammedFilmFactoryImpl();
        ProgrammedFilm p1 = fP.creteProgrammedFilm(f1.getID(), 12, 5.5, date, LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p2 = fP.creteProgrammedFilm(f2.getID(), 22, 5.5, date, LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p3 = fP.creteProgrammedFilm(f3.getID(), 32, 5.5, date, LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p4 = fP.creteProgrammedFilm(f1.getID(), 42, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p5 = fP.creteProgrammedFilm(f2.getID(), 252, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p6 = fP.creteProgrammedFilm(f3.getID(), 162, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p7 = fP.creteProgrammedFilm(f1.getID(), 123, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p8 = fP.creteProgrammedFilm(f2.getID(), 13, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        ProgrammedFilm p9 = fP.creteProgrammedFilm(f3.getID(), 13, 5.5, LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)) ;
        
        setP.add(p1);
        setP.add(p2);
        setP.add(p3);
        setP.add(p4);
        setP.add(p5);
        setP.add(p6);
        setP.add(p7);
        setP.add(p8);
        setP.add(p9);
        System.out.println(setP);
        BookingController b = new BookingControllerImpl(set,setP);
        b.start();

    }
    
    


}
