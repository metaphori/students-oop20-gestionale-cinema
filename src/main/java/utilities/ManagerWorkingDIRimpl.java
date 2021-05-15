package utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class ManagerWorkingDIRimpl implements ManagerWorkingDIR {
    private final int lengthName = 15;
    @Override
    public String generateNewImageFileName(final String ext) {
        final String generatedName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(lengthName), ext);
        return generatedName;
    }
    @Override
    public String copyFile(final File src, final String folder) throws IOException {
        final String extSelectedFile = FilenameUtils.getExtension(src.getAbsolutePath());
        String generatedName = this.generateNewImageFileName(extSelectedFile);
        while (!(this.isValidName(GeneralSettings.IMAGESDIR, generatedName))) {
            generatedName = this.generateNewImageFileName(extSelectedFile);
        }
        final File destFile = new File(GeneralSettings.IMAGESDIR + GeneralSettings.FS + generatedName);
        FileUtils.copyFile(src, destFile);
        return destFile.getAbsolutePath();
    }
    
    public boolean isValidName(final String dirPath, final String name) {
        if (dirPath != null && name != null) {
            final File[] files = new File(dirPath).listFiles();
            if (files != null) {
                return !(Arrays.asList(files).stream().anyMatch(f -> f.getName().equals(name))); 
            }
        }
        return false;
    }
    @Override
    public String copyFileWithSpecificName(final File src, final String folder, final String name) throws IOException {
        final String extSelectedFile = FilenameUtils.getExtension(src.getAbsolutePath());
        final File destFile = new File(GeneralSettings.IMAGESDIR + GeneralSettings.FS + name +extSelectedFile );
        FileUtils.copyFile(src, destFile);
        return destFile.getAbsolutePath();
    }

}
