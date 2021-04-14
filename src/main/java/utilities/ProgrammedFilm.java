package utilities;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProgrammedFilm {
    private final String filmName;
    private final LocalDate date;
    private final int hallNumber;
    private final LocalTime startTime;
    private final double ticketPrice;
    
    
    public ProgrammedFilm(final String filmName, final LocalDate date, final  int hallNumber, final LocalTime startTime, final double ticketPrice) {
        super();
        this.filmName = filmName;
        this.date = date;
        this.hallNumber = hallNumber;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
    }
    
    public ProgrammedFilm(ProgrammedFilm source) {
        super();
        this.filmName = source.filmName;
        this.date = source.date;
        this.hallNumber = source.hallNumber;
        this.startTime = source.startTime;
        this.ticketPrice = source.ticketPrice; 
    }
    
    public String getFilmName() {
        return filmName;
    }
    public LocalDate getDate() {
        return date;
    }
    public int getHallNumber() {
        return hallNumber;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "ProgrammedFilm [filmName=" + filmName + ", date=" + date + ", hallNumber=" + hallNumber + ", startTime="
                + startTime + ", ticketPrice=" + ticketPrice + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((filmName == null) ? 0 : filmName.hashCode());
        result = prime * result + hallNumber;
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        long temp;
        temp = Double.doubleToLongBits(ticketPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ProgrammedFilm other = (ProgrammedFilm) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (filmName == null) {
            if (other.filmName != null)
                return false;
        } else if (!filmName.equals(other.filmName))
            return false;
        if (hallNumber != other.hallNumber)
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (Double.doubleToLongBits(ticketPrice) != Double.doubleToLongBits(other.ticketPrice))
            return false;
        return true;
    }    
}
