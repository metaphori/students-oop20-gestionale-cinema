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

public final class RW {
    private RW() { };
    
    /**
     * 
     * 
     * @param <X>      is type of elements that will be written
     * @param set      is the set with elemnts that will be written on file 
     * @param pathname is the path of file that will be written
     */
    public static <X> void write(Set<X> set, String pathname) {
        Gson gson = GsonFactory.getMyGson();
        try (FileWriter writer = new FileWriter(pathname)) {
            gson.toJson(set, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * 
     * @param <X>      is the type of elements that will be read
     * @param cls      is used to pass class
     * @param pathname is path of file that will be read
     * @return         set of elements that are read by file
     */
    public static <X> Set<X> read(Class<?> cls, String pathname) {
        Gson gson = GsonFactory.getMyGson();
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
