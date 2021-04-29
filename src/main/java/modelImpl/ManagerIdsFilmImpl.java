package modelImpl;

import java.util.Collection;
import java.util.Optional;

import model.IdsGenerator;
import model.ManagerIdsFilms;

public final class ManagerIdsFilmImpl implements ManagerIdsFilms {
    private  final Collection<Integer> containerFilmsIds;
    private  final IdsGenerator idsGenerator;
    ManagerIdsFilmImpl(final IdsGenerator idsGenerator, final Collection<Integer> containerFilmsIds) { 
        this.containerFilmsIds = containerFilmsIds;
        this.idsGenerator = idsGenerator;
    }
    public Collection<Integer> getUsedIDs(final IdsGenerator idsGenerator) {
        return containerFilmsIds;
    }
    public int getNewFilmID() {
        return idsGenerator.getNewId();
    }

    @Override
    public Optional<Integer> getLastGeneratedId() {
        return idsGenerator.getLastGeneratedId();
    }
    @Override
    public Collection<Integer> getUsedIDs() {
             return containerFilmsIds;
    }
}
