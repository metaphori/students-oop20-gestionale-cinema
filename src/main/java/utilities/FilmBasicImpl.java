package utilities;

import java.util.Optional;

public final class FilmBasicImpl implements Film {
    private final String name; //unique name
    private final String genre;
    private final String description;
    private final Optional<String> coverImagePath;
    private final int duration; //minutes
    private final int id;
    FilmBasicImpl(final String name, final String genre, final String description, final Optional<String> coverImagePath, final int duration, final int id) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.coverImagePath = coverImagePath;
        this.duration = duration;
        this.id = id;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getGenre() {
        return this.genre;
    }
    @Override
    public int getDuration() {
        return this.duration;
    }
    @Override
    public Optional<String> getCoverPath() {
        return this.coverImagePath;
    }
    @Override
    public String getDescription() {
        return this.description;
    }
    public int getID() {
        return this.id;
    }
}
