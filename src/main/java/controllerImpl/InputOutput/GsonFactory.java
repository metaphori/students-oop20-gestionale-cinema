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
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.TicketImpl;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmImpl;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;

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
        
        final RuntimeTypeAdapterFactory<ManagerIdsFilms> adapterManagerIdsFilms= RuntimeTypeAdapterFactory
                .of(ManagerIdsFilms.class, "Type")
                .registerSubtype(ManagerIdsFilmImpl.class, ManagerIdsFilmImpl.class.getName());
     
        final RuntimeTypeAdapterFactory<IdsGenerator> adapterIdsGenerator= RuntimeTypeAdapterFactory
                .of(IdsGenerator.class, "Type")
                .registerSubtype(IdsGeneratorImpl.class, IdsGeneratorImpl.class.getName());
        
        final RuntimeTypeAdapterFactory<TimeSlot> adapterTimeSlot= RuntimeTypeAdapterFactory
                .of(TimeSlot.class, "Type")
                .registerSubtype(TimeSlotImpl.class, TimeSlotImpl.class.getName());
        

    /*    final RuntimeTypeAdapterFactory<LocalTime> adapterLocalTime = RuntimeTypeAdapterFactory
                .of(LocalTime.class, "Type");
                
        final RuntimeTypeAdapterFactory<LocalDate> adapterLocalDate = RuntimeTypeAdapterFactory
                .of(LocalDate.class, "Type");
        */        

        
        return new GsonBuilder()
             
                .registerTypeAdapterFactory(adapterTimeSlot)
                .registerTypeAdapterFactory(adapterIdsGenerator)
                .registerTypeAdapterFactory(adapterManagerIdsFilms)
                .registerTypeAdapterFactory(adapterFilm)
                .registerTypeAdapterFactory(adapterProgrammedFilm)
                .registerTypeAdapterFactory(adapterTicket)
                .create();
    }
}