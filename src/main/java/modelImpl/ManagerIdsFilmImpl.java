package modelImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public  class ManagerIdsFilmImpl implements ManagerIdsFilms{
    private  Collection <Integer> containerFilmsIds;
    private  IdsGenerator IdsGenerator;
    
    ManagerIdsFilmImpl (IdsGenerator IdsGenerator){ 
        this.IdsGenerator = IdsGenerator;
    }
    
    public Collection<Integer> getUsedIDs(IdsGenerator IdsGenerator) {
        return containerFilmsIds;
    }   
    
    public int getNewFilmID() {
        return IdsGenerator.getNewId();
    }

    @Override
    public int getLastGeneratedId() {
        return 0;
    }
    
    @Override
    public Collection<Integer> getUsedIDs() {
             return null;
    }

    @Override
    public void loadIDs() {
        
    }
}
