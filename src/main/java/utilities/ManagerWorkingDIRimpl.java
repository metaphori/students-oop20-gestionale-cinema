package utilities;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class ManagerWorkingDIRimpl implements ManagerWorkingDIR {
    private final int lengthFileName = 15;
    
    @Override
    public String generateNewImageFileName(final String ext) {
        final String generatedName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(lengthFileName), ext);
        return generatedName;
    }
    @Override
    public String copyFile(final File src, final String folder) throws IOException {
        final String extSelectedFile = FilenameUtils.getExtension(src.getAbsolutePath());
        String generatedName = this.generateNewImageFileName(extSelectedFile);
        while (!(this.isValidName(GeneralSettings.IMAGESDIR, generatedName))) {
            generatedName = this.generateNewImageFileName(extSelectedFile);
        }
        final File destFile = new File(folder + generatedName);
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
        final File destFile = new File(folder + name + extSelectedFile);
        FileUtils.copyFile(src, destFile);
        return destFile.getAbsolutePath();
    }
    
    
    @Override
    public void initWorkingDir() {
        this.createDIR(GeneralSettings.WORKINGDIR);
        this.createDIR(GeneralSettings.DATADIR);
        this.createDIR(GeneralSettings.IMAGESDIR);
        this.createDIR(GeneralSettings.TEMPDIR);
       // this.fillDIR(toCopy, pathDir);
        
    }
    
    private void createDIR(final String pathWithDIRname) {
        final File rootDIR = new File(pathWithDIRname);
        if (!rootDIR.exists()) {
            rootDIR.mkdirs();
        }
    }

    private void fillDIR(final File toCopy, final String pathDir) { // TODO
    }
    /*
    private void createFileImg(ImageIcon icon) {
       
        BufferedImage bi = new BufferedImage(icon.getImage().getWidth(null),icon.getImage().getHeight(null),BufferedImage.TYPE_BYTE_ARGB);

        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        ImageIO.write(bi, "jpg", new File("img.jpg"));
        
        
    }
    */
    @Override
    public void deleteFileWithSpecificName(final File toDelete) {
        
      try {
        FileUtils.forceDelete(toDelete);
    } catch (IOException e) {
        System.out.println("Errore while deleting specified file");
        e.printStackTrace();
    }  
    }

}
