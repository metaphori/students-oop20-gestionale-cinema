package utilities;
import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;

public class ManagerWorkingDIRimpl implements ManagerWorkingDIR {
    private final int lengthName = 15;
    @Override
    public String generateNewImageFileName(final String ext) {
        final String generatedName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(lengthName), ext);
        final File[] files = new File(GeneralSettings.IMAGESDIR).listFiles();
        if (files != null) {
            for (final File file : files) { // TODO
                if (file.getName().equals(generatedName)) {
                    
                }
            }
        }
        return generatedName;
    }

}
