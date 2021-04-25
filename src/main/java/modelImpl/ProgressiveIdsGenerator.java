package modelImpl;

import java.util.Optional;

public final class ProgressiveIdsGenerator implements IdsGenerator {
    private Optional<Integer> lastGeneratedId; //last generated id to insert a newFilm. When films container is empty , this value will be null;
    
    public ProgressiveIdsGenerator(final Optional<Integer> lastGeneratedId) {
        this.lastGeneratedId = lastGeneratedId;
    }
    @Override
    public int getNewId() {
        if (this.lastGeneratedId.isEmpty()) {
            this.lastGeneratedId = Optional.of(1);
            return this.lastGeneratedId.get();
        }
        int val = this.lastGeneratedId.get();
        val ++;
        this.lastGeneratedId = Optional.of(val);
        return lastGeneratedId.get();
    }
    
    

}
