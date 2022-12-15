package BMICalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.math.BigDecimal;

public class BMICalcController {

    @FXML    private Button CalculateButton;
    @FXML    private Label Result;
    @FXML    private TextField EWeight;
    @FXML    private TextField EHeight;
    @FXML    private TextField MHeight;
    @FXML    private TextField MWeight;

    @FXML
    void calculateButtonPress(ActionEvent event) {
        String output = "";
        try {
            try {
                double kgs = new BigDecimal(MWeight.getText()).doubleValue();
                double ml = new BigDecimal(MHeight.getText()).doubleValue();

                double result = kgs/ml/ml;
                System.out.println(result);

                if(result < 18.5){
                    output = "Underweight";
                }
                else if(result<=24.9){
                    output = "Normal";
                }
                else if(result <=29.9){
                    output = "Overweight";
                }
                else{
                    output = "Obese";
                }
                Result.setText(output);
            }catch (NumberFormatException ex){
                double lbs = new BigDecimal(EWeight.getText()).doubleValue();
                double in = new BigDecimal(EHeight.getText()).doubleValue();

                double result = 703*lbs/in/in;
                System.out.println(result);

                if(result < 18.5){
                    output = "Underweight";
                }
                else if(result<=24.9){
                    output = "Normal";
                }
                else if(result <=29.9){
                    output = "Overweight";
                }
                else{
                    output = "Obese";
                }
                Result.setText(output);

            }


        }
        catch(NumberFormatException ex){
            Result.setText("enter amount");
    }

    }
}
