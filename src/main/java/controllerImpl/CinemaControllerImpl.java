package controllerImpl;

import controller.CinemaController;
import utilities.ManagerWorkingDIR;
import utilitiesImpl.ManagerWorkingDIRimpl;


public final class CinemaControllerImpl implements CinemaController {

    private final ManagerWorkingDIR manager = new ManagerWorkingDIRimpl();

    @Override
    public void showMenu() {

    }

    @Override
    public void initApplication(final String path) {
        manager.initWorkingDir(path);

    }

}
