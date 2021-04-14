package controllerImpl.InputOutput;

import java.util.Set;

public interface RW<X> {
    /**
     * 
     * @param set is the set that will be written in the file
     * @param pathname is the path of file that will be used for writing
     */
    void write(Set<X> set, String pathname);
    
    /**
     * 
     * @param cls is the type of elements that will be read in the file
     * @param pathname is the path of file that will be read
     * @return set of elements of type X
     */
    Set<X> read(Class<?> cls, String pathname);
}
