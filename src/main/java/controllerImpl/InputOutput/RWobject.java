package controllerImpl.InputOutput;

import java.lang.reflect.Type;
import java.util.Optional;

public interface RWobject<X> {
    Optional<X> readObj(Type type);
    void writeObj(X obj ,Type type);
  
}