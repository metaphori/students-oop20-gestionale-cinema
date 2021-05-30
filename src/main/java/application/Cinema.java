package application;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
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
import utilities.TimeSlot;
import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;
import view.ManageProgrammingFilms.ProgrammingFilmsGUI;
import viewImpl.ManageProgrammingFilms.ProgrammingFilmsGUIimpl;

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
        
       // final FilmsController filmsController = new FilmsControllerImpl(set, managerIdsFilm);
        final FilmsController filmsController = new FilmsControllerImpl();
        filmsController.showContainerFilmsView();
        */
        
        //ProgrammingFilmsController controller = new ProgrammingFilmsControllerImpl();
        
       // ProgrammingFilmsGUI gui = new ProgrammingFilmsGUIimpl();
        
        //controller.addProgrammedFilm(null);
        
    }
    
    


}
