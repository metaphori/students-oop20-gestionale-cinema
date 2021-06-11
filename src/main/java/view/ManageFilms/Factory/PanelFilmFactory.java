package view.ManageFilms.Factory;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.Film;

/** 
      Factory to create a panel with all films
 */
public interface PanelFilmFactory {
    /**
     * Get a film panel, fill the map to associates each film with specific button.
     * @param mapFilm map to fill
     * @param setFilm set used to fill value of map
     * @return JPanel
     */
    JPanel getFilmPanel(Map<JButton, Film> mapFilm, Set<Film> setFilm);
}