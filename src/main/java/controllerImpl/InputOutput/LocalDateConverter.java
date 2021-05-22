package controllerImpl.InputOutput;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateConverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    
    @Override
    public JsonElement serialize(LocalDate localDate, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(DateTimeFormatter.ofPattern("d-MMM-yyyy").format(localDate));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException {
        return LocalDate.parse(json.getAsString(),
            DateTimeFormatter.ofPattern("d-MMM-yyyy"));
    }

}



