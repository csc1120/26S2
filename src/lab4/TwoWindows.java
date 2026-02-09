/*
 * Course: CSC-1120 - 111
 * Lab 4 demonstration
 */
package lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Simple example of two window GUI application
 * <a href="https://github.com/csc1120/26S2/tree/main/src/lab4">code</a>
 */
public class TwoWindows extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //region Load primary window
        FXMLLoader loaderPrimary = new FXMLLoader(getClass().getResource("Primary.fxml"));
        Parent primaryScene = loaderPrimary.load();
        stage.setScene(new Scene(primaryScene));
        stage.setTitle("Primary Window");
        stage.show();
        //endregion
        //region Load secondary window
        FXMLLoader loaderSecondary = new FXMLLoader(getClass().getResource("Secondary.fxml"));
        Parent secondaryScene = loaderSecondary.load();
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(new Scene(secondaryScene));
        secondaryStage.setTitle("Secondary Window");
        //endregion
        //region Give primary controller access to secondary stage
        PrimaryController controllerPrimary = loaderPrimary.getController();
        controllerPrimary.setSecondaryStage(secondaryStage);
        secondaryStage.setOnCloseRequest(_ -> controllerPrimary.secondaryClosed());
        //endregion
        //region Give secondary controller access to primary controller
        SecondaryController controllerSecondary = loaderSecondary.getController();
        controllerSecondary.setPrimaryController(controllerPrimary);
        //endregion
        //region Position secondary window below primary
        secondaryStage.setX(stage.getX());
        secondaryStage.setY(stage.getY() + stage.getHeight());
        //endregion
    }
}
