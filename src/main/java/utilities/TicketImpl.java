package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Set;

public class TicketImpl implements Ticket {
    
        private final LocalDate data;
        private final LocalTime time;
	private final Set<Seat<Row,Integer>> setSeat;
	private final double price;
	private final int id;
	private final String hall;
	
	public TicketImpl(LocalDate data,LocalTime time, Set<Seat<Row,Integer>> setSeat, double price, int id, String hall) {
		this.data = data;
		this.hall = hall;
		this.setSeat = setSeat;
		this.price = price;
		this.id = id;
		this.time = time;
	}
	public LocalTime getTime() {
	    return time;
	}
	public LocalDate getData() {
		return data;
	}
	public Set<Seat<Row, Integer>> getSetSeat() {
		return setSeat;
	}
	public double getPrice() {
		return price;
	}
	public int getId() {
		return id;
	}	
	public String getHall() {
		return hall;
	}
	

	
	@Override
	public String toString() {
		return "Ticket [data=" + data + ", setSeat=" + setSeat + ", price=" + price + ", id=" + id
				+ ", hall=" + hall + "]";
	}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((hall == null) ? 0 : hall.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        TicketImpl other = (TicketImpl) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (hall == null) {
            if (other.hall != null)
                return false;
        } else if (!hall.equals(other.hall))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

	
	
	
}
