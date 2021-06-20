package controllerImpl.inputoutput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import model.managefilms.IdsGenerator;
import model.managefilms.ManagerIdsFilms;
import modelImpl.managefilms.IdsGeneratorImpl;
import modelImpl.managefilms.ManagerIdsFilmImpl;
import utilities.Account;
import utilities.Seat;
import utilities.Ticket;
import utilities.TimeSlot;
import utilities.factory.Film;
import utilities.factory.ProgrammedFilm;
import utilitiesImpl.AccountImpl;
import utilitiesImpl.SeatImpl;
import utilitiesImpl.TicketImpl;
import utilitiesImpl.factoryimpl.FilmBasicImpl;
import utilitiesImpl.factoryimpl.ProgrammedFilmImpl;
import utilitiesImpl.factoryimpl.TimeSlotImpl;


public final class GsonFactory {

    private GsonFactory() { }
    /** 
     * Return a gson object with specific adpater.
     * @return a gson object 
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

        final RuntimeTypeAdapterFactory<Seat> adapterSeat = RuntimeTypeAdapterFactory
                .of(Seat.class, "Type")
                .registerSubtype(SeatImpl.class, SeatImpl.class.getName());

        final RuntimeTypeAdapterFactory<ManagerIdsFilms> adapterManagerIdsFilms = RuntimeTypeAdapterFactory
                .of(ManagerIdsFilms.class, "Type")
                .registerSubtype(ManagerIdsFilmImpl.class, ManagerIdsFilmImpl.class.getName());

        final RuntimeTypeAdapterFactory<IdsGenerator> adapterIdsGenerator = RuntimeTypeAdapterFactory
                .of(IdsGenerator.class, "Type")
                .registerSubtype(IdsGeneratorImpl.class, IdsGeneratorImpl.class.getName());

        final RuntimeTypeAdapterFactory<TimeSlot> adapterTimeSlot = RuntimeTypeAdapterFactory
                .of(TimeSlot.class, "Type")
                .registerSubtype(TimeSlotImpl.class, TimeSlotImpl.class.getName());

        final RuntimeTypeAdapterFactory<Account> adapterAccount = RuntimeTypeAdapterFactory
                .of(Account.class, "Type")
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