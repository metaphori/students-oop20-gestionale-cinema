package model.ManageFilms;

import java.util.Optional;
/** 
 * Ids Generator generates new ids.
 * */
public interface IdsGenerator {
    /** 
     * Get new id.
     * @return id 
     * */
    int getNewId();
    /** 
     * Get last generated id.
     * @return Optional<Integer>
     * */
    Optional<Integer> getLastGeneratedId();

}
