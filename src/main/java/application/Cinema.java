package application;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

import controller.FilmsController;
import controllerImpl.FilmsControllerImpl;
import modelImpl.IdsGeneratorImpl;
import modelImpl.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.FilmFactory;
import utilities.FilmFactoryImpl;
import utilities.GeneralSettings;

public class Cinema {

    public static void main(final String[] args) {
        FilmFactory filmFactory = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
        Film f1 = filmFactory.createBasicFilm("Spiderman", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f2 = filmFactory.createBasicFilm("Batman", "Action", "Nice film", Optional.ofNullable(null),140);
        Film f3 = filmFactory.createBasicFilm("dhdhhd", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f4 = filmFactory.createBasicFilm("djjddj", "Action", "Nice film", Optional.ofNullable(null),140);
        Film f5 = filmFactory.createBasicFilm("akakak", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f6 = filmFactory.createBasicFilm("akakak", "Action", "Nice film", Optional.ofNullable(null),140);
        Film f7 = filmFactory.createBasicFilm("akak", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f8 = filmFactory.createBasicFilm("akakkak", "Action", "Nice film", Optional.ofNullable(null),140);
        Film f9 = filmFactory.createBasicFilm("akakka", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f10 = filmFactory.createBasicFilm("xmmxmxm", "Action", "Nice film", Optional.ofNullable(null),140);
        
        
        Set<Film> set = new HashSet<>();
        set.add(f1);
        set.add(f2);
        set.add(f3);
        set.add(f4);
        set.add(f5);
        set.add(f6);
        set.add(f7);
        set.add(f8);
        set.add(f9);
        set.add(f10);
        
        
        FilmsController filmsController = new FilmsControllerImpl(set);
        
        filmsController.showContainerFilmsView();
       // System.out.println(GeneralSettings.IMAGESDIR);
        /*
        File[] files = new File(GeneralSettings.IMAGESDIR).listFiles();
        for (final File file : files) {
            System.out.println(file.getName());
        }
        */

        
          
    }


}
