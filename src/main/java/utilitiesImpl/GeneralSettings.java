package utilitiesImpl;

public class GeneralSettings {
    //Directory options
    public static final String FS = System.getProperty("file.separator");
    public static final String ROOTNAME = ".application";
    public static final String IMAGESDIRNAME = "images";
    public static final String IMAGESSELECTEDDIRNAME = "selected";
    public static final String DATADIRNAME = "data";
    public static final String TEMPDIRNAME = "temp";
    
    

    public static final String WORKINGDIR = System.getProperty("user.home") + FS + ROOTNAME; // Working directory where application store dates
    public static final String IMAGESDIR = WORKINGDIR +  FS + IMAGESDIRNAME;
    public static final String DATADIR = WORKINGDIR +  FS  + DATADIRNAME;
    public static final String IMAGESSELECTEDDIR =  WORKINGDIR +  FS  + IMAGESDIRNAME + FS + IMAGESSELECTEDDIRNAME + FS;
    
  //File options
    public static final String FILMSFILE = "FILMS.json";
    public static final String FILMSPATH = DATADIR + FS + FILMSFILE;
    public static final String MANAGERIDSFILMSFILE = "MANAGERIDSFILMS.json";
    public static final String MANAGERIDSFILMSPATH = DATADIR + FS + MANAGERIDSFILMSFILE;
    
    public static final String PROGRAMMEDFILMSFILE = "PROGRAMMEDFILMS.json";
    public static final String PROGRAMMEDFILMSPATH = DATADIR + FS + PROGRAMMEDFILMSFILE;

    public static final String TICKET_FILE = "Ticket.json";
    public static final String TICKET_FILE_PATH = DATADIR + FS + TICKET_FILE;
    
  
    //Res options
    public static final String IMAGEFILMSTANDARD = "images/filmStandardIco.png";
    public static final String IMAGE_SEAT_FREE = "images/imageSeatFree.png";
    public static final String IMAGE_SEAT_SELECTED = "images/imageSeatSelected.png";
    public static final String IMAGE_SEAT_TAKEN = "images/imageSeatTaken.png";
    public static final String IMAGE_LEGEND = "images/legend.png";
}
