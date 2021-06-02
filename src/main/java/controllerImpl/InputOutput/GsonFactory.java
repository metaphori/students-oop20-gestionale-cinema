package controllerImpl.InputOutput;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.IdsGenerator;
import model.ManageFilms.ManagerIdsFilms;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import utilities.Film;
import utilities.Ticket;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.TicketImpl;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmImpl;

public final class GsonFactory {
    private GsonFactory() { }
    /** 
     * @return a gson object that was built adding adaptation
     */

    public static Gson getMyGson() {
        final RuntimeTypeAdapterFactory<Film> adapterFilm = RuntimeTypeAdapterFactory
                .of(Film.class, "type")
                .registerSubtype(FilmBasicImpl.class, FilmBasicImpl.class.getName());

        final RuntimeTypeAdapterFactory<ProgrammedFilm> adapterProgrammedFilm = RuntimeTypeAdapterFactory
                .of(ProgrammedFilm.class, "type")
                .registerSubtype(ProgrammedFilmImpl.class, ProgrammedFilmImpl.class.getName());

        final RuntimeTypeAdapterFactory<Ticket> adapterTicket = RuntimeTypeAdapterFactory
                .of(Ticket.class, "Type")
                .registerSubtype(TicketImpl.class, TicketImpl.class.getName());
     
        return new GsonBuilder()
                .registerTypeAdapterFactory(adapterFilm)
                .registerTypeAdapterFactory(adapterProgrammedFilm)
                .registerTypeAdapterFactory(adapterTicket)
                .create();
    }
}
