package controllerImpl.ManageStatistics;

import java.time.LocalDate;

import controller.ManageStatistics.StatisticsController;
import model.Booking.BookingModel;
import utilities.Film;

public class StatisticsControllerImpl implements StatisticsController{
    private BookingModel model;
    
    @Override
    public Film getMostedWatchedFilm() {
        return null;
    }

    @Override
    public LocalDate getMostAffluentDays() {
        return null;
    }

    @Override
    public Double getRecessed() {
        return null;
    }

}
