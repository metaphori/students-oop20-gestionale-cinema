package utilitiesImpl;

import java.awt.Toolkit;

public final class ViewSettings {
    public static final double DIMENSION_HEIGTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final double DIMENSION_WIDTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    public static final double PROPORTION = 1.15;
    public static final double DIMENSION_HEIGTH_VIEW = DIMENSION_HEIGTH_SCREEN / PROPORTION ;
    public static final double DIMENSION_WIDTH_VIEW = DIMENSION_WIDTH_SCREEN / PROPORTION;
    private ViewSettings() {};

}
