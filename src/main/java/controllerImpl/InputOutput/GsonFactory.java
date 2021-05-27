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
import utilitiesImpl.FactoryImpl.FilmBasicImpl;

public final class GsonFactory {
    private GsonFactory() { }
    /** 
     * @return a gson object that was built adding adaptation
     */

    public static Gson getMyGson() {
        final RuntimeTypeAdapterFactory<Film> adapterFilm = RuntimeTypeAdapterFactory.of(Film.class, "type")
                .registerSubtype(FilmBasicImpl.class, FilmBasicImpl.class.getName());
        final RuntimeTypeAdapterFactory<ContainerFilmsModel> adapterModelFilm = RuntimeTypeAdapterFactory.of(ContainerFilmsModel.class, "type")
                .registerSubtype(ContainerFilmsModelImpl.class, ContainerFilmsModelImpl.class.getName());
        final RuntimeTypeAdapterFactory<ManagerIdsFilms> adapterManagerIds = RuntimeTypeAdapterFactory.of(ManagerIdsFilms.class, "type")
                .registerSubtype(ManagerIdsFilmImpl.class, ManagerIdsFilmImpl.class.getName());
        final RuntimeTypeAdapterFactory<IdsGenerator> adapterIdsGenerator = RuntimeTypeAdapterFactory.of(IdsGenerator.class, "type")
                .registerSubtype(IdsGeneratorImpl.class, IdsGeneratorImpl.class.getName()); 
        return new GsonBuilder()
                .registerTypeAdapterFactory(adapterFilm)
                .registerTypeAdapterFactory(adapterModelFilm)
                .registerTypeAdapterFactory(adapterManagerIds)
                .registerTypeAdapterFactory(adapterIdsGenerator)
                .create();
    }
}
