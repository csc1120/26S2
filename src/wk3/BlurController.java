package wk3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;

public class BlurController {
    @FXML
    private TextField tfield;
    @FXML
    private Label displayText;

    @FXML
    private void toggleBlur(ActionEvent actionEvent) {
        if (displayText.getEffect() == null) {
            displayText.setEffect(new BoxBlur());
        } else {
            displayText.setEffect(null);
        }
    }

    @FXML
    private void toggleButtBlur(ActionEvent actionEvent) {

    }

    public void grabText(ActionEvent actionEvent) {
        System.out.println(tfield.getText());
    }
}
