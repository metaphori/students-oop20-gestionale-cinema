package utilities.Factory;

import java.util.Optional;

import utilities.Film;
/** 
 *   Factory to create a film.
 * */
public interface FilmFactory {
    /** 
     * Creates a film with generated id.
     *@param name film name
     *@param genre film genre
     *@param description film description
     *@param coverPath image path film
     *@param duration duration of film
     **/
    Film createBasicFilm(String name, String genre, String description, Optional<String> coverPath, int duration);
    /** 
     * Creates a film with specific id.
     *@param name film name
     *@param genre film genre
     *@param description film description
     *@param coverPath image path film
     *@param duration duration of film
     *@param id id of film
     **/
    Film createBasicFilmById(String name, String genre, String description, Optional<String> coverPath, int duration, int id);
    }