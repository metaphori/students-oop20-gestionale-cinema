package utilitiesImpl;

import java.awt.Toolkit;

public final class ViewSettings {
    public static final double DIMENSION_HEIGTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static final double DIMENSION_WIDTH_SCREEN = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    
    public static final double DIMENSION_HEIGTH_VIEW = DIMENSION_HEIGTH_SCREEN * 0.5;
    public static final double DIMENSION_WIDTH_VIEW = DIMENSION_WIDTH_SCREEN * 0.5;
    private ViewSettings() {};
    
    
    
    
}
