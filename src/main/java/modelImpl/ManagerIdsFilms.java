package modelImpl;

import java.util.Collection;

public interface ManagerIdsFilms {
    int getNewFilmID();
    Collection<Integer> getUsedIDs();
    int getLastGeneratedId();
    void loadIDs();
}


