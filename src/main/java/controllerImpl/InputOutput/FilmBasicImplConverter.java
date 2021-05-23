package controllerImpl.InputOutput;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Optional;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import utilities.Film;
import utilities.FilmBasicImpl;
import utilities.FilmFactory;
import utilities.FilmFactoryImpl;

public class FilmBasicImplConverter implements JsonSerializer<Film>, JsonDeserializer<Film> {

    @Override
    public Film deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        
        int id = 0;
        String title = null;
        String genre = null;
        int duration = 0;
        String path = null;
        String description = null;
        
        for(var i : obj.entrySet()){
            switch(i.getKey()) {
                case "id":
                    id = i.getValue().getAsInt();
                case "title":
                    title = i.getValue().getAsString();
                case "genre":
                    genre = i.getValue().getAsString();
                case "duration":
                    duration = i.getValue().getAsInt();
                case "path":
                    path = i.getValue().getAsString();
                case "description":
                    description = i.getValue().getAsString();
            }
        };
        
        FilmFactory factoryFilm = new FilmFactoryImpl(null);
        Optional<String> pathOp = path.equals("") ? Optional.empty() : Optional.of(path) ;
        return factoryFilm.createBasicFilmById(title, genre, description, pathOp, duration,id);
    }

    @Override
    public JsonElement serialize(Film src, Type typeOfSrc, JsonSerializationContext context) {
        String path = new String();
        path = src.getCoverPath().isEmpty() ? "" : src.getCoverPath().get();
        
        
        JsonObject obj = new JsonObject();
        obj.addProperty("id",src.getID());
        obj.addProperty("title", src.getName());
        obj.addProperty("genre", src.getGenre());
        obj.addProperty("duration", src.getDuration());
        obj.addProperty("path", path);
        obj.addProperty("description", src.getDescription());
       
        return obj;
    }

}
