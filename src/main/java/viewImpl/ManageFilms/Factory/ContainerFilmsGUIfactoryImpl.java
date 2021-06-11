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
     * Creates basic panel with specific layout.
     * @param layout
     * @return JPanel
     * */
    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }
    /** 
     * Creates basic button with specific text.
     * @param text
     * @return JButton
     * */
    @Override
    public JButton createButtonWithText(final String text) {
        return new JButton(text);
    }
    /** 
     * Creates basic panel with specific icon.
     * @param icon
     * @return JButton
     * */
    @Override
    public JButton createButtonWithIcon(final Icon icon) {
        return new JButton(icon);
    }

}
