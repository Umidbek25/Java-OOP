package ContactsModifiedApp;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ContactsImage extends ListCell<ContactsModifiedDetails> {
    private VBox vbox = new VBox(8.0); // 8 points of gap between controls
    private ImageView imageView = new ImageView(); // initially empty
    private Label label = new Label();


    public ContactsImage() {
        vbox.setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100.0);
        vbox.getChildren().add(imageView);

        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        vbox.getChildren().add(label);

        setPrefWidth(USE_PREF_SIZE);
    }


    @Override
    protected void updateItem(ContactsModifiedDetails item, boolean empty) {

        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        }
        else {
            imageView.setImage(new Image(item.getImage()));
            label.setText(item.getLastName());
            setGraphic(vbox);
        }
    }

}
