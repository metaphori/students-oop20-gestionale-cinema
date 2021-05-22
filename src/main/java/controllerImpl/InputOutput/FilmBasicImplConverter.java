package RW2;

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

public class FilmBasicImplConverter implements JsonSerializer<Film>, JsonDeserializer<Film> {

    @Override
    public Film deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        
        int id = 0;
        String title = null;
        String genere = null;
        int duration = 0;
        String path = null;
        String description = null;
        
        for(var i : obj.entrySet()){
            switch(i.getKey()) {
                case "id":
                    id = i.getValue().getAsInt();
                case "title":
                    title = i.getValue().getAsString();
                case "genere":
                    genere = i.getValue().getAsString();
                case "duration":
                    duration = i.getValue().getAsInt();
                case "path":
                    path = i.getValue().getAsString();
                case "description":
                    description = i.getValue().getAsString();
            }
        };
        
       // FactoryFilm ff = new FactoryFilmImpl();
        
       // return new FactoryFilmImpl().;
    }

    @Override
    public JsonElement serialize(Film src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("id",src.getID());
        obj.addProperty("title", src.getName());
        obj.addProperty("genere", src.getGenre());
        obj.addProperty("duration", src.getDuration());
        obj.addProperty("path", src.getCoverPath());
        obj.addProperty("description", src.getDescription());
        
        return obj;
    }

}
