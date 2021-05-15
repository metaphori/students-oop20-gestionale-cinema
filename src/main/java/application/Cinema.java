package application;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

import controller.FilmsController;
import controllerImpl.FilmsControllerImpl;
import controllerImpl.InputOutput.RWcollection;
import controllerImpl.InputOutput.RWfile;
import controllerImpl.InputOutput.RWobject;
import model.ContainerFilmsModel;
import modelImpl.IdsGeneratorImpl;
import modelImpl.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.FilmFactory;
import utilities.FilmFactoryImpl;
import utilities.GeneralSettings;
import modelImpl.ContainerFilmsModelImpl;

public class Cinema {

    public static void main(final String[] args) {
      
        
        
        Set<Film> set = new HashSet<>();
     
               
        //ContainerFilmsModel model = new ContainerFilmsModelImpl();
        
        FilmFactory filmFactory = new FilmFactoryImpl(new ManagerIdsFilmImpl(new IdsGeneratorImpl()));
        Film f1 = filmFactory.createBasicFilm("Spiderman", "Action", "Nice film", Optional.ofNullable(null),120);
        Film f2 = filmFactory.createBasicFilm("Batman", "Action", "Nice film", Optional.ofNullable(null),140);
        Film f3 = filmFactory.createBasicFilm("Thor", "Action", "Good film", Optional.ofNullable(null),120);
 
        set.add(f1);
        set.add(f2);
        set.add(f3);
        
        FilmsController filmsController = new FilmsControllerImpl(set);
        filmsController.showContainerFilmsView();
      
        //System.out.println(exist);

        
          
    }


}
