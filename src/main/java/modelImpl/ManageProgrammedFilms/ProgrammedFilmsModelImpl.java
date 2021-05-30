package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.ManageProgrammingFilms.ManagerProgrammingFilms;
import model.ManageProgrammingFilms.ProgrammedFilmsModel;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;

public class ProgrammedFilmsModelImpl implements ProgrammedFilmsModel{
    
    private final List <ProgrammedFilm> programmedFilms = new ArrayList<>();
    private final ManagerProgrammingFilms manager = new ManagerProgrammingFilmsImpl(programmedFilms);
    

    @Override
    public void addFilmProgrammation(final ProgrammedFilm programmedFilm) {
        programmedFilms.add(programmedFilm);
    }

    @Override
    public void deleteFilmProgrammation(final ProgrammedFilm programmedFilm) {
        
    }
        
    @Override
    public boolean isAvailableProgrammation(final TimeSlot timeSlotToCheck, final LocalDate date, final int hall) {
        return manager.isAvailableProgrammation(timeSlotToCheck, date, hall);
    }

    @Override
    public List<ProgrammedFilm> getAllProgrammedFilm() {
        return this.programmedFilms;
    }
    

}
