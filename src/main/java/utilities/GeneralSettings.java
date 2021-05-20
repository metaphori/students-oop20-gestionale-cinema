package utilities;

public class GeneralSettings {
    //Directory options
    public static final String FS = System.getProperty("file.separator");
    public static final String ROOTNAME = ".application";
    public static final String IMAGESDIRNAME = "images";
    public static final String IMAGESDEFAULTDIRNAME = "default";
    public static final String IMAGESSELECTEDDIRNAME = "selected";
    public static final String DATADIRNAME = "data";
    public static final String TEMPDIRNAME = "temp";
    
    

    public static final String WORKINGDIR = System.getProperty("user.home") + FS + ROOTNAME; // Working directory where application store dates
    public static final String IMAGESDIR = WORKINGDIR +  FS + IMAGESDIRNAME;
    public static final String IMAGESDEFAULTDIR = WORKINGDIR +  FS + IMAGESDIRNAME + FS + IMAGESDEFAULTDIRNAME;
    public static final String DATADIR = WORKINGDIR +  FS  + DATADIRNAME;
    public static final String TEMPDIR =  WORKINGDIR +  FS  + TEMPDIRNAME;
    public static final String IMAGESSELECTEDDIR =  WORKINGDIR +  FS  + IMAGESDIRNAME + FS + IMAGESSELECTEDDIRNAME + FS;
    
    //File options
    public static final String TEMPIMAGENAME = "tempImg";
    public static final String IMAGEDEFAULTFILMFILENAME = "filmStandardIco.png";
    
    
    public static final String TEMPIMAGEFILE = TEMPDIR + FS + TEMPIMAGENAME;
    public static final String IMAGESDEFAULTFILMFILE = IMAGESDEFAULTDIR + IMAGEDEFAULTFILMFILENAME ;

}
