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

public class RWfile<X> implements RWcollection<X>, RWobject<X> {
    private String pathname;
    private Gson gson;
    
    public RWfile(String pathname) {
        this.pathname = pathname;
        this.gson = GsonFactory.getMyGson();
    }
    
    @Override
    public void writeCollection(Collection<X> set) {
       
       
        try (FileWriter writer = new FileWriter(pathname)) {
            gson.toJson(set, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    
   
    @Override
    public Collection<X> readCollection(Class<?> cls) {
        Set<X> set = new HashSet<>();
        if(new File(pathname).exists()) {
          
            Type typeSet = TypeToken.getParameterized(Set.class, cls).getType();
            try (Reader reader = new FileReader(pathname)) {
                set = gson.fromJson(reader, typeSet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Optional<X> readObj(Class<X> cls) {
        Optional<X> res = null;
        if(new File(pathname).exists()) {
            Type typeSet = TypeToken.getParameterized(Set.class, cls).getType();
            try (Reader reader = new FileReader(pathname)) {
                res = Optional.ofNullable(gson.fromJson(reader, cls));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public void writeObj(X obj) {
        try (FileWriter writer = new FileWriter(pathname)) {
            gson.toJson(obj, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }
}