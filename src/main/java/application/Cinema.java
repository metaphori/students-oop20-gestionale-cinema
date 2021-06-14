
package application;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

import java.util.Comparator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JLabel;

import org.apache.commons.lang3.RandomStringUtils;


import controller.ManageAccounts.AccountsController;

import controller.CinemaController;
import controller.Booking.BookingController;

import controller.ManageFilms.FilmsController;
import controller.ManageProgrammingFilms.ProgrammingFilmsController;
import controllerImpl.CinemaControllerImpl;
import controllerImpl.Booking.BookingControllerImpl;
import controllerImpl.InputOutput.RWobject;
import controllerImpl.ManageAccounts.AccountsControllerImpl;
import controllerImpl.ManageFilms.FilmsControllerImpl;
import controllerImpl.ManageProgrammingFilms.ProgrammingFilmsControllerImpl;
import exceptions.ProgrammationNotAvailableException;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageFilms.IdsGenerator;
import model.ManageFilms.ManagerIdsFilms;
import model.ManageProgrammingFilms.HandlerList;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageFilms.IdsGeneratorImpl;
import modelImpl.ManageFilms.ManagerIdsFilmImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import utilities.Film;

import utilities.Factory.FilmFactory;

import utilities.ManageAccounts.Account;
import utilities.ManageAccounts.TypeAccount;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.ManageAccounts.AccountImpl;

import utilities.Factory.ProgrammedFilm;
import utilities.Factory.ProgrammedFilmFactory;
import utilitiesImpl.GeneralSettings;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;



public class Cinema {
    public static void main(final String[] args){
        
        CinemaController cinemaController = new CinemaControllerImpl();
        cinemaController.initApplication();
    }
    
}
