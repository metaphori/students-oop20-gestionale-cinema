package modelImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import model.IdsGenerator;
import model.ManagerIdsFilms;

public final class ManagerIdsFilmImpl implements ManagerIdsFilms {
    private  final Collection<Integer> containerFilmsIds;
    private  final IdsGenerator idsGenerator;
    protected String type = getClass().getName();

    //Passo al manager Ids films l' idsGenerator e il containerFilmsIds
    public ManagerIdsFilmImpl(final IdsGenerator idsGenerator, final Collection<Integer> containerFilmsIds) { 
        this.containerFilmsIds = containerFilmsIds;
        this.idsGenerator = idsGenerator;
    }
    
    public ManagerIdsFilmImpl(final IdsGenerator idsGenerator) { 
        this.containerFilmsIds = new HashSet<>();
        this.idsGenerator = idsGenerator;
    }
    
    public Collection<Integer> getUsedIDs(final IdsGenerator idsGenerator) {
        return containerFilmsIds;
    }
    public int getNewFilmID() {
        int id = idsGenerator.getNewId();
        containerFilmsIds.add(id);
        return id;
    }

    @Override
    public Optional<Integer> getLastGeneratedId() {
        return idsGenerator.getLastGeneratedId();
    }
    @Override
    public Collection<Integer> getUsedIDs() {
             return containerFilmsIds;
    }
    @Override
    public String toString() {
        return containerFilmsIds +"" + idsGenerator;
        
        
    }
}
