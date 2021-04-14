package utilities;

public class Film {
    
    private String name; //unique name
    private String genre;
    private String description;
    private String coverImagePath;
    private int duration; //minutes
    
        
    public Film(final String name,final String genre, final String description, final String coverImagePath, final int duration) {
        super();
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.coverImagePath = coverImagePath;
        this.duration = duration;
    }
    
    public Film(final Film newFilm) {
       super();
       this.copyFilm(this);
       
    }
    
    
    private void copyFilm(final Film sourceFilm) {
        this.name=sourceFilm.name;
        this.genre=sourceFilm.genre;
        this.description=sourceFilm.description;
        this.coverImagePath=sourceFilm.coverImagePath;
        this.duration=sourceFilm.duration;
    } 
    @Override
    public String toString() {
        return "Film [name=" + name + ", genre=" + genre + ", description=" + description + ", coverImagePath="
                + coverImagePath + ", duration=" + duration + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coverImagePath == null) ? 0 : coverImagePath.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + duration;
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Film other = (Film) obj;
        if (coverImagePath == null) {
            if (other.coverImagePath != null)
                return false;
        } else if (!coverImagePath.equals(other.coverImagePath))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (duration != other.duration)
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(final String genre) {
        this.genre = genre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(final String description) {
        this.description = description;
    }
    public String getCoverImagePath() {
        return coverImagePath;
    }
    public void setCoverImagePath(final String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(final int duration) {
        this.duration = duration;
    }
    
}
