package modelImpl.ManageProgrammedFilms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.ManageProgrammingFilms.Filter;
import model.ManageProgrammingFilms.HandlerList;
import model.ManageProgrammingFilms.Sorter;
import utilities.TimeSlot;
import utilities.Factory.ProgrammedFilm;

public class HandlerListImpl<X> implements HandlerList<X> {
   /* 
    public List<ProgrammedFilm> filterListByDateHall(final List <ProgrammedFilm> listToManage,final LocalDate date , final int hall) { // create 
       
       return  listToManage.stream().filter(pf -> {
               return pf.getHall() == hall && pf.getDate().equals(date);})
               .collect(Collectors.toList());
       
    }
    
    public List<ProgrammedFilm> filterListByDate(final List <ProgrammedFilm> listToManage,final LocalDate date) {
      return listToManage.stream()
              .filter(pf -> pf.getDate().equals(date))
              .collect(Collectors.toList());
    }
    
    public List<ProgrammedFilm> sortListByHall(final List<ProgrammedFilm> toOrder) {
       return toOrder.stream()
              .sorted((fp1, fp2) -> fp1.getHall()-fp2.getHall())
              .collect(Collectors.toList());              
    }
    
    public <X> List<X> filterBy(final List<X> list ,final  Predicate<X> filter){
        return list.stream()
                   .filter(filter)
                   .collect(Collectors.toList());
        
    }
    
    public <X> List<X> sortBy(final List<X> list, final Comparator <X> comparator){
        return list.stream()
                   .sorted(comparator)
                   .collect(Collectors.toList());
        
    }
*/
    @Override
    public List<X> filterBy(final List<X> list, final Filter<X> filter) {
        
        return list.stream()
                .filter(filter.getPredicate())
                .collect(Collectors.toList());
     
    }

    @Override
    public List<X> sortBy(final List<X> list, final Sorter<X> sorter) {
        return list.stream()
                .sorted(sorter.getComparator())
                .collect(Collectors.toList());
    }

}
