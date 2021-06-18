package viewImpl.ManageFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.ManageFilms.Factory.ContainerFilmsGUIfactory;
/**
 * Basic implementation to create basic components of container films. 
 * */
public final class ContainerFilmsGUIfactoryImpl implements ContainerFilmsGUIfactory {
    /** 
     * {@inheritDoc}
     * */
    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public JButton createButtonWithText(final String text) {
        return new JButton(text);
    }
    /** 
     * {@inheritDoc}
     * */
    @Override
    public JButton createButtonWithIcon(final Icon icon) {
        return new JButton(icon);
    }

}
