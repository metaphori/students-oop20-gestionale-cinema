package controller;


public interface BookingController {

	//public void addBooking(int numSala,String nomeFilm,Calendar cal,POSTI);
		
	//public Collection<BigliettiVendutiProgrammazione> getAllBooking();
	public void getSpecifiedBooking(); // get film booking in a certain date, time and hall 
	
	//public Collection<Booking> loadAddBooking();
	
	public void showBookingView();
	
	public void showMenu();
	
}
