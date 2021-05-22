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


public interface PanelFilmFactory {
    JPanel getFilmPanel(Map<JButton, Film> mapFilm, Set<Film> setFilm);
}