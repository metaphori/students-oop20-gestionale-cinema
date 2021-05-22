package controllerImpl.InputOutput;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import utilities.Film;
import utilities.FilmBasicImpl;
import model.ContainerFilmsModel;
import model.IdsGenerator;
import model.ManagerIdsFilms;
import modelImpl.ContainerFilmsModelImpl;
import modelImpl.ManagerIdsFilmImpl;
import modelImpl.IdsGeneratorImpl;

public final class GsonFactory {
    private GsonFactory() { }
    /** 
     * @return a gson object that was built adding adaptation
     */
    
    public static Gson getMyGson() {
        
        
        RuntimeTypeAdapterFactory<Film> factFilm = RuntimeTypeAdapterFactory.of(Film.class, "type");
        factFilm.registerSubtype(FilmBasicImpl.class,FilmBasicImpl.class.getName());
       
        RuntimeTypeAdapterFactory<ContainerFilmsModel> factModel = RuntimeTypeAdapterFactory.of(ContainerFilmsModel.class, "type");
        factModel.registerSubtype(ContainerFilmsModelImpl.class,ContainerFilmsModelImpl.class.getName());
       
     
        
        RuntimeTypeAdapterFactory<ManagerIdsFilms> factManagerIds= RuntimeTypeAdapterFactory.of(ManagerIdsFilms.class, "type");
        factManagerIds.registerSubtype(ManagerIdsFilmImpl.class,ManagerIdsFilmImpl.class.getName());
       
        
        RuntimeTypeAdapterFactory<IdsGenerator> factIdsGenerator= RuntimeTypeAdapterFactory.of(IdsGenerator.class, "type");
        factIdsGenerator.registerSubtype(IdsGeneratorImpl.class,IdsGeneratorImpl.class.getName()); 
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateConverter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeConverter())
                .registerTypeAdapterFactory(factFilm)
                .registerTypeAdapterFactory(factModel)
                .registerTypeAdapterFactory(factManagerIds)
                .registerTypeAdapterFactory(factIdsGenerator)
               // .registerTypeAdapter(Film.class, new InterfaceAdapter<Film>())
               // .registerTypeAdapterFactory(typeFactory)
             //   .registerTypeAdapter(ContainerFilmsModel.class, new InterfaceAdapter<ContainerFilmsModel>())
            //    .registerTypeAdapter(IdsGenerator.class, new InterfaceAdapter<IdsGenerator>())
             // .registerTypeAdapter(ManagerIdsFilms.class, new InterfaceAdapter<ManagerIdsFilms>())
              //  .registerTypeAdapter(ProgrammedFilmsModel.class, new InterfaceAdapter<ProgrammedFilmsModel>())
                .create();
    }
}
