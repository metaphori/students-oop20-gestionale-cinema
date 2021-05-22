package model.ManageFilms;

import java.util.Collection;
import java.util.Optional;

public interface ManagerIdsFilms {
    int getNewFilmID();
    Collection<Integer> getUsedIDs();
    Optional<Integer> getLastGeneratedId();
    void removeFilmId(int idToDelete);
}


