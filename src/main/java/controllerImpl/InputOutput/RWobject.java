package controllerImpl.InputOutput;

import java.util.Optional;

public interface RWobject<X> {
    Optional<X> readObj(Class<X> cls);
    void writeObj(X obj);
   
}
