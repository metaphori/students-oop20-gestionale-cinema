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
import utilities.Seat;
import utilities.Ticket;
import utilities.TimeSlot;

import utilities.Factory.ProgrammedFilm;
import utilities.ManageAccounts.Account;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.TicketImpl;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmImpl;

import utilitiesImpl.FactoryImpl.TimeSlotImpl;
import utilitiesImpl.ManageAccounts.AccountImpl;


public final class GsonFactory {
    private static final String STRING_TYPE = "type";
    
    private GsonFactory() { }
    /** 
     * @return a gson object that was built adding adaptation
     */
    
    public static Gson getMyGson() {
        final RuntimeTypeAdapterFactory<Film> adapterFilm = RuntimeTypeAdapterFactory
                .of(Film.class, STRING_TYPE)
                .registerSubtype(FilmBasicImpl.class, FilmBasicImpl.class.getName());

        final RuntimeTypeAdapterFactory<ProgrammedFilm> adapterProgrammedFilm = RuntimeTypeAdapterFactory
                .of(ProgrammedFilm.class, STRING_TYPE)
                .registerSubtype(ProgrammedFilmImpl.class, ProgrammedFilmImpl.class.getName());

        final RuntimeTypeAdapterFactory<Ticket> adapterTicket = RuntimeTypeAdapterFactory
                .of(Ticket.class, STRING_TYPE)
                .registerSubtype(TicketImpl.class, TicketImpl.class.getName());

        final RuntimeTypeAdapterFactory<Seat> adapterSeat = RuntimeTypeAdapterFactory
                .of(Seat.class, STRING_TYPE)
                .registerSubtype(SeatImpl.class, SeatImpl.class.getName());

        final RuntimeTypeAdapterFactory<ManagerIdsFilms> adapterManagerIdsFilms = RuntimeTypeAdapterFactory
                .of(ManagerIdsFilms.class, STRING_TYPE)
                .registerSubtype(ManagerIdsFilmImpl.class, ManagerIdsFilmImpl.class.getName());

        final RuntimeTypeAdapterFactory<IdsGenerator> adapterIdsGenerator = RuntimeTypeAdapterFactory
                .of(IdsGenerator.class, STRING_TYPE)
                .registerSubtype(IdsGeneratorImpl.class, IdsGeneratorImpl.class.getName());

        final RuntimeTypeAdapterFactory<TimeSlot> adapterTimeSlot = RuntimeTypeAdapterFactory
                .of(TimeSlot.class, STRING_TYPE)
                .registerSubtype(TimeSlotImpl.class, TimeSlotImpl.class.getName());

        final RuntimeTypeAdapterFactory<Account> adapterAccount = RuntimeTypeAdapterFactory
                .of(Account.class, STRING_TYPE)
                .registerSubtype(AccountImpl.class, AccountImpl.class.getName());

        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(adapterSeat)
                .registerTypeAdapterFactory(adapterTimeSlot)
                .registerTypeAdapterFactory(adapterIdsGenerator)
                .registerTypeAdapterFactory(adapterManagerIdsFilms)
                .registerTypeAdapterFactory(adapterFilm)
                .registerTypeAdapterFactory(adapterProgrammedFilm)
                .registerTypeAdapterFactory(adapterTicket)
                .registerTypeAdapterFactory(adapterAccount)
                .create();
    }
}