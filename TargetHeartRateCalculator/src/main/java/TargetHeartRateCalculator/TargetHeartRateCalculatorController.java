package TargetHeartRateCalculator;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import java.math.BigDecimal;

public class TargetHeartRateCalculatorController {

    @FXML
    private TextField MaxRate;

    @FXML
    private TextField Age;

    @FXML
    void Press(ActionEvent event) {
        try {
            double age = new BigDecimal(Age.getText()).doubleValue();
            MaxRate.setText(String.valueOf(220-age));
        }catch (Exception ex){
            Age.setText("Enter Amount");
        }
    }

}
