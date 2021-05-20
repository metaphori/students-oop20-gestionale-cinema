package utilities;

import java.io.File;
import java.io.IOException;

public interface ManagerWorkingDIR {

    String generateNewImageFileName(String ext);
    String copyFile(File src, String folder) throws IOException; //return path of destFile
    String copyFileWithSpecificName(File src, String folder, String name) throws IOException;
    void initWorkingDir();
    boolean isValidName(String dirPath, String name);

}
