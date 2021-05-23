package viewImpl.ManageFilms.Factory;

import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.ManageFilms.Factory.ContainerFilmsGUIfactory;

public class ContainerFilmsGUIfactoryImpl implements ContainerFilmsGUIfactory{

    @Override
    public JPanel createPanel(final LayoutManager layout) {
        return new JPanel(layout);
    }

    @Override
    public JButton createButtonWithText(final String text) {
        return new JButton(text);
    }

    @Override
    public JButton createButtonWithIcon(final Icon icon) {
        return new JButton(icon);
    }

}
