package TestsManageFilms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import controllerImpl.InputOutput.RWobject;
import model.ManageFilms.ContainerFilmsModel;
import model.ManageProgrammingFilms.HandlerList;
import modelImpl.ManageFilms.ContainerFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.FilterByDateHallImpl;
import modelImpl.ManageProgrammedFilms.FilterByDateImpl;
import modelImpl.ManageProgrammedFilms.HandlerListImpl;
import modelImpl.ManageProgrammedFilms.ProgrammedFilmsModelImpl;
import modelImpl.ManageProgrammedFilms.SorterByHallImpl;
import modelImpl.ManageProgrammedFilms.SorterByTimeImpl;
import utilities.Film;
import utilities.TimeSlot;
import utilities.Factory.FilmFactory;
import utilities.Factory.ProgrammedFilm;
import utilities.Factory.TimeSlotFactory;
import utilitiesImpl.FactoryImpl.FilmBasicImpl;
import utilitiesImpl.FactoryImpl.FilmFactoryImpl;
import utilitiesImpl.FactoryImpl.ProgrammedFilmFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotFactoryImpl;
import utilitiesImpl.FactoryImpl.TimeSlotImpl;

class TestFilters {
    
        
    private List<ProgrammedFilm> createList() {
        
        final LocalDate ld1 = LocalDate.of(1999, 3, 6);    
        final LocalDate ld2 = LocalDate.of(1999, 3, 7); 
        final LocalDate ld3 = LocalDate.of(1999, 3, 6); 
        
        final LocalTime st1 = LocalTime.of(8, 30);
        final LocalTime st2 = LocalTime.of(6, 50);
        final LocalTime st3 = LocalTime.of(8, 27);
        
        final LocalTime et1 = LocalTime.of(8, 45);
        final LocalTime et2 = LocalTime.of(7, 22);
        final LocalTime et3 = LocalTime.of(8, 29);
        
        final ProgrammedFilmFactoryImpl factory = new ProgrammedFilmFactoryImpl();
        final ProgrammedFilm pf1 = factory.createProgrammedFilm(12, 8, 56, ld1, st1, et1);
        final ProgrammedFilm pf2 = factory.createProgrammedFilm(13, 9, 56, ld2, st2, et2);
        final ProgrammedFilm pf3 = factory.createProgrammedFilm(14, 1, 56, ld3, st3, et3);
        final ProgrammedFilm pf4 = factory.createProgrammedFilm(15, 9, 56, ld2, st3, et3);
        
        final List<ProgrammedFilm> list = new ArrayList<>();
        list.add(pf1);
        list.add(pf2);
        list.add(pf3);
        list.add(pf4);
        
        return list;
        
    }
    
    @Test
    void testFilterByDate() {
        final LocalDate dateForFilter = LocalDate.of(1999, 3, 6);
        final List<ProgrammedFilm> list = this.createList();
        final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>() ;
        final List<ProgrammedFilm> filteredList = handler.filterBy(list, new FilterByDateImpl(dateForFilter));
        
        this.checkDate(filteredList, dateForFilter);
    }
 
   @Test
    void testFilterByDateHall() {
        final LocalDate date = LocalDate.of(1999, 3, 7);
        final int hall = 9;
        final List<ProgrammedFilm> list = this.createList();
        final  HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>() ;
        final List<ProgrammedFilm> filteredList = handler.filterBy(list, new FilterByDateHallImpl(date, hall));
            
        this.checkDate(filteredList, date);
        this.checkHall(filteredList, hall);
    }
    @Test //TODO must be added checkTimeOrder
    
    void testSorterByTime() {
       final List<ProgrammedFilm> list = this.createList();
       final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>() ;
       final List<ProgrammedFilm> filteredList = handler.sortBy(list, new SorterByTimeImpl());
  
   }
   
   @Test 
    void testSorterByHall() {
       final List<ProgrammedFilm> list = this.createList();
       final HandlerList<ProgrammedFilm> handler = new HandlerListImpl<>() ;
       final List<ProgrammedFilm> filteredList = handler.sortBy(list, new SorterByHallImpl());
       System.out.println(list);
       System.out.println(filteredList);
   }
    
    private void checkDate(final List<ProgrammedFilm> list, final LocalDate date) {
        assertFalse(list.stream().anyMatch(pf -> !pf.getDate().equals(date)));
    }
    
    private void checkHall(final List<ProgrammedFilm> list, final int hall) {
        assertFalse(list.stream().anyMatch(pf -> pf.getHall()!= hall));
    }
    
    
    //TODO
    private void checkHallOrder(final List<ProgrammedFilm> list ) {
      
      /* list.stream()
           .mapToInt(pf -> pf.getHall())
           .anyMatch(pf);*/
        
    }
    //TODO 
    private void checkTimeStartOrder(final List<ProgrammedFilm> list) {}
    


}
