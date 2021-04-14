package controllerImpl.InputOutput;

import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonFactory {
    private GsonFactory() { }
    public static Gson getMyGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateConverter())
                .registerTypeAdapter(LocalTime.class, new LocalTimeConverter())
                .create();
    }
}
