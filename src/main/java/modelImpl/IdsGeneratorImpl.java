package modelImpl;

import java.util.Optional;

import model.IdsGenerator;

public final class IdsGeneratorImpl implements IdsGenerator {
    private Optional<Integer> lastGeneratedId; //last generated id to insert a newFilm. When films container is empty , this value will be null;

    public IdsGeneratorImpl(final Optional<Integer> lastGeneratedId) {
        this.lastGeneratedId = lastGeneratedId;
    }

    public IdsGeneratorImpl() {
        this.lastGeneratedId = Optional.ofNullable(null);
    }

    @Override
    public int getNewId() {
        if (this.lastGeneratedId.isEmpty()) {
            this.lastGeneratedId = Optional.of(1);
            return this.lastGeneratedId.get();
        }
        int val = this.lastGeneratedId.get();
        val++;
        this.lastGeneratedId = Optional.of(val);
        return lastGeneratedId.get();
    }
    @Override
    public Optional<Integer> getLastGeneratedId() {
        return lastGeneratedId;
    }
}
