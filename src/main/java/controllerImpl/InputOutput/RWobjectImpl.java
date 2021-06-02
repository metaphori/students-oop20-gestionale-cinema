package controllerImpl.InputOutput;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RWobjectImpl<X> implements RWobject<X> {
    private String pathname;
    private Gson gson;

    public RWobjectImpl(String pathname) {
        this.pathname = pathname;
        gson = GsonFactory.getMyGson();
    }

    @Override
    public void writeObj(final X obj, final Type cls) {
        try (FileWriter writer = new FileWriter(pathname)) {
            //gson.toJson(obj, writer);
            gson.toJson(obj, cls, writer);
            } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public Optional<X> readObj(final Type cls ) {
        Optional<X> res = Optional.empty();
        if (new File(pathname).exists()) {
            //Type typeSet = TypeToken.getParameterized(Set.class, cls).getType();
            try (Reader reader = new FileReader(pathname)) {
                res = Optional.ofNullable(gson.fromJson(reader, cls));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    } 

}



