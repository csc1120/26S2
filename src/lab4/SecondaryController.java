/*
 * Course: CSC-1120 - 111
 * Lab 4 demonstration
 */
package lab4;

import javafx.fxml.FXML;

/**
 * Controller for the secondary window
 */
public class SecondaryController {
    private PrimaryController primaryController;

    /**
     * Sets the controller for the primary window where updates are made.
     * @param controllerPrimary Controller for the main stage
     */
    public void setPrimaryController(PrimaryController controllerPrimary) {
        primaryController = controllerPrimary;
    }

    @FXML
    private void updatePrimaryWindow() {
        primaryController.update();
    }
}
