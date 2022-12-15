package ETipCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class EnhTipCalc extends Application {
    @Override
    public void start(@NotNull Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("EnhancedTip.fxml"));
        Scene scene=new Scene(root);
        stage.setTitle("Enhanced Tip Calculator");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
