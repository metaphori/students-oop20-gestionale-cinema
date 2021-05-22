package controllerImpl.InputOutput;

import java.util.Collection;

public interface RWcollection<X> {
    void writeCollection(Collection<X> coll);
    Collection<X> readCollection(Class<?> cls);

}


