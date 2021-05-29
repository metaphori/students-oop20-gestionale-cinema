package utilitiesImpl.FactoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import utilities.Factory.ProgrammedFilm;

public class ProgrammedFilmImpl implements ProgrammedFilm {
    
    final int id;// reference to idFilms
    final int hall;
    final double price;
    final LocalDate date;
    final LocalTime startTime;
    final LocalTime endTime;
    
    
    ProgrammedFilmImpl(final int id, final  int hall, final  double price, final  LocalDate date, final LocalTime startTime, final LocalTime endTime) {
        super();
        this.id = id;
        this.hall = hall;
        this.price = price;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int getIdProgrammation() {
        return this.id;
    }

    @Override
    public int getHall() {
        return this.hall;
    }

    @Override
    public double getProgrammationPrice() {
        return this.price;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public LocalTime getStartTime() {
        return this.startTime;
    }

    @Override
    public LocalTime getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return "ProgrammedFilmImpl [id=" + id + ", hall=" + hall + ", price=" + price + ", date=" + date
                + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + hall;
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProgrammedFilmImpl other = (ProgrammedFilmImpl) obj;
        if (id != other.id && startTime != other.startTime && endTime != other.endTime && hall!=other.hall )
            return false;
        return true;
    }
    
    
    
    

}
