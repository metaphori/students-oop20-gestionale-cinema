package TestsManageFilms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import controllerImpl.InputOutput.RWfile;
import controllerImpl.InputOutput.RWobject;
import model.ContainerFilmsModel;
import modelImpl.ContainerFilmsModelImpl;
import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.FilmFactory;
import utilities.FilmFactoryImpl;

class TestContainerFilms {
    @Test
    void testScrittura() {
       /* ContainerFilmsModel container = new ContainerFilmsModelImpl();
        FilmFactory filmFactory = new FilmFactoryImpl(container) ;
        Film film1 = filmFactory.createBasicFilm("Spiderman", "Action", "Nice film! ", null, 130);
        Film film2 = filmFactory.createBasicFilm("Batma", "Action", "Nice film! ", null, 110);
        
        container.addFilm(film1);
        container.addFilm(film2);
        RWobject rw = new RWfile("/home/ziro/Desktop/containerFilm");
        rw.writeObj(container);
        
        
        Optional<ContainerFilmsModel> containerNew = rw.readObj(container.getClass());
        */
        
    }
 
   

}
