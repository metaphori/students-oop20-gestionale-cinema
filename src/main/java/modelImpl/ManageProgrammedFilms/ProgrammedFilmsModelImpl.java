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
    
    private final List <ProgrammedFilm> programmedFilms;
    private final ManagerProgrammingFilms manager;
    

    public ProgrammedFilmsModelImpl(final List<ProgrammedFilm> programmedFilms) {
        this.programmedFilms = programmedFilms;
        manager = new ManagerProgrammingFilmsImpl(programmedFilms);
    }
    public ProgrammedFilmsModelImpl() {
        this.programmedFilms = new ArrayList<>();
        this.manager = new ManagerProgrammingFilmsImpl(programmedFilms);
    }

    @Override
    public void addFilmProgrammation(final ProgrammedFilm programmedFilm) {
        programmedFilms.add(programmedFilm);
    }

    @Override
    public void deleteFilmProgrammation(final ProgrammedFilm programmedFilm) {
        programmedFilms.remove(programmedFilm);
    }
        
    @Override
    public boolean isAvailableProgrammation(final TimeSlot timeSlotToCheck, final LocalDate date, final int hall) {
        return manager.isAvailableProgrammation(timeSlotToCheck, date, hall);
    }

    @Override
    public List<ProgrammedFilm> getAllProgrammedFilm() {
        return this.programmedFilms;
    }
    @Override
    public ManagerProgrammingFilms getManagerProgrammingFilms() {
        return this.manager;
    }
    

}
