package TestsManageFilms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import model.ContainerFilmsModel;
import modelImpl.ContainerFilmsModelImpl;
import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.FilmFactory;
import utilities.FilmFactoryImpl;

class TestContainerFilms {

    @Test
    void test() {
        final ContainerFilmsModel container = new ContainerFilmsModelImpl();
        final FilmFactory filmFactory = new FilmFactoryImpl(container);
        Film f1 = filmFactory.createBasicFilm("Spiderman","Action","Spiderman was born on ....",Optional.ofNullable(""), 125);
        Film f2 = filmFactory.createBasicFilm("Batman","Action","Batman was born on ....",Optional.ofNullable(""), 200);
        container.addFilm(f1);
        container.addFilm(f2);
        assertNotEquals(f1, f2);
        assertEquals(container.getManagerIdsFilms().getLastGeneratedId().get(), 2);
        /*container.removeFilm(f2);
        for (final Film f : container.getFilms()) {
            System.out.println(f.getID());
        }*/
        Film f3 = f1 ;
        container.addFilm(f3);
        for (final Film f : container.getFilms()) {
            System.out.println(f.getID());
        }
    }

}
