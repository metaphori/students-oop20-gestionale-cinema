package utilitiesImpl;

public final class GeneralSettings {

    //Directory options
    /**Describes file separator depends on operative system where application will be run.*/
    public static final String FS = System.getProperty("file.separator"); 

    /**Describes root name directory where application will be run.*/
    public static final String ROOTNAME = ".application";

    /**Describes images directory where application will save images.*/
    public static final String IMAGESDIRNAME = "images";

    /**Describes images directory where application will save images choosed by the users.*/
    public static final String IMAGESSELECTEDDIRNAME = "selected";

    /**Describes data directory where application will save file for storing data.*/
    public static final String DATADIRNAME = "data";

    /**Describes temp directory for temporary operations.*/
    public static final String TEMPDIRNAME = "temp";

    /**Describes working directory path  where application will run.*/
    public static final String WORKINGDIR = System.getProperty("user.home") + FS + ROOTNAME; // Working directory where application store dates

    /**Describes images directory path.*/
    public static final String IMAGESDIR = WORKINGDIR +  FS + IMAGESDIRNAME;

    /**Describes data directory path.*/
    public static final String DATADIR = WORKINGDIR +  FS  + DATADIRNAME;

    /**Describes images choosed path by users directory path.*/
    public static final String IMAGESSELECTEDDIR =  WORKINGDIR +  FS  + IMAGESDIRNAME + FS + IMAGESSELECTEDDIRNAME + FS;

    //File options

    /**Describes film file name where films data will be stored.*/
    public static final String FILMSFILE = "FILMS.json";

    /**Describes film file path.*/
    public static final String FILMSPATH = DATADIR + FS + FILMSFILE;

    /**Describes manager ids films file name where managerFilmIds data will be stored.*/
    public static final String MANAGERIDSFILMSFILE = "MANAGERIDSFILMS.json";

    /**Describes manager ids films path where managerFilmIds data will be stored.*/
    public static final String MANAGERIDSFILMSPATH = DATADIR + FS + MANAGERIDSFILMSFILE;

    /**Describes programmed films file name where programmed films data will be stored.*/
    public static final String PROGRAMMEDFILMSFILE = "PROGRAMMEDFILMS.json";

    /**Describes programmed films file path where programmed films data will be stored.*/
    public static final String PROGRAMMEDFILMSPATH = DATADIR + FS + PROGRAMMEDFILMSFILE;

    /**Describes standard cover image name for film if user doesn't choose any images. */
    //Res options
    public static final String IMAGEFILMSTANDARD = "images/filmStandardIco.png";

    /**Private constructor. This class can't be instantiated. It's used to access paths where application will work.*/
    private GeneralSettings() { }; 
}
