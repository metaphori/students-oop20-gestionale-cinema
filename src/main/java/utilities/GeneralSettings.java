package utilities;

public class GeneralSettings {
    public static final String FS = System.getProperty("file.separator");
    public static final String ROOTNAME = ".application";
    public static final String IMAGESDIRNAME = "filmImages";
    public static final String DATADIRNAME = "data";

    public static final String WORKINGDIR = System.getProperty("user.home") + FS + ROOTNAME; // Working directory where application store dates
    public static final String IMAGESDIR = WORKINGDIR +  FS + IMAGESDIRNAME ;
    public static final String DATADIR = WORKINGDIR +  FS  + DATADIRNAME;
    
    public static final String TEMPIMAGENAME = "tempImg";

}
