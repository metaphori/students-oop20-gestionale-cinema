package controllerImpl.InputOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RWimpl<X> implements RW<X> {
    private Gson gson;
    
    public RWimpl() {
        super();
        gson = GsonFactory.getMyGson();
    }
    
    @Override
    public void write(Set<X> set, String pathname) {
        try (FileWriter writer = new FileWriter(pathname)) {
            gson.toJson(set, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public Set<X> read(Class<?> cls, String pathname) {
        Set<X> set = new HashSet<>();
        Type typeSet = TypeToken.getParameterized(Set.class, cls).getType();
        try (Reader reader = new FileReader(pathname)) {
            set = gson.fromJson(reader, typeSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}
