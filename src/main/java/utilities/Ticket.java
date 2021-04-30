package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Set;

public class Ticket {
    
        private final LocalDate data;
        private final LocalTime time;
	private final Set<Seat<Row,Integer>> setSeat;
	private final Double price;
	private final String titleFilm;
	private final String hall;
	
	public Ticket(LocalDate data,LocalTime time, Set<Seat<Row,Integer>> setSeat, Double price, String titleFilm, String hall) {
		this.data = data;
		this.hall = hall;
		this.setSeat = setSeat;
		this.price = price;
		this.titleFilm = titleFilm;
		this.time = time;
	}
	public LocalDate getData() {
		return data;
	}
	public Set<Seat<Row, Integer>> getSetSeat() {
		return setSeat;
	}
	public Double getPrice() {
		return price;
	}
	public String getTitleFilm() {
		return titleFilm;
	}	
	public String getHall() {
		return hall;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((setSeat == null) ? 0 : setSeat.hashCode());
		result = prime * result + ((titleFilm == null) ? 0 : titleFilm.hashCode());
		return result;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Ticket other = (Ticket) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (hall == null) {
			if (other.hall != null) {
				return false;
			}
		} else if (!hall.equals(other.hall)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		if (setSeat == null) {
			if (other.setSeat != null) {
				return false;
			}
		} else if (!setSeat.equals(other.setSeat)) {
			return false;
		}
		if (titleFilm == null) {
			if (other.titleFilm != null) {
				return false;
			}
		} else if (!titleFilm.equals(other.titleFilm)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Ticket [data=" + data + ", setSeat=" + setSeat + ", price=" + price + ", titleFilm=" + titleFilm
				+ ", hall=" + hall + "]";
	}

	
	
	
}
