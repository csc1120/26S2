/*
 * Course: CSC-1120 - 111
 * Lab 4 demonstration
 */
package lab4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Controller for the Primary Window
 */
public class PrimaryController {
    @FXML
    private HBox pane;
    @FXML
    private Button showHide;

    private Stage stage;

    /**
     * Sets the stage whose visibility is to be toggled
     * @param secondaryStage window to control
     */
    public void setSecondaryStage(Stage secondaryStage) {
        stage = secondaryStage;
    }

    @FXML
    private void toggleWindowVisibility() {
        if (showHide.getText().equals("Hide Window")) {
            stage.hide();
            showHide.setText("Show Window");
        } else {
            stage.show();
            showHide.setText("Hide Window");
        }
    }

    /**
     * Update background colors
     */
    public void update() {
        double level = Math.random();
        pane.setBackground(new Background(
                new BackgroundFill(Color.gray(level), null, null)));
        showHide.setBackground(new Background(
                new BackgroundFill(Color.gray(1 - level), null, null)));
    }

    /**
     * Updates the text on the {@code showHide} button when
     * the secondary window is closed manually.
     */
    public void secondaryClosed() {
        showHide.setText("Show Window");
    }
}
