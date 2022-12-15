package ContactsModifiedApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.Collections;
import java.util.Comparator;

public class ContactsModifiedController {
    @FXML    private ListView<ContactsModifiedDetails> studentsListView;
    @FXML    private ImageView avatarImageView;
    @FXML    private TextField nameTextField;
    @FXML    private TextField secondNameTextField;
    @FXML    private TextField emailTextFiled;
    @FXML    private TextField phoneTextField;
    @FXML    private Button addButton;
    @FXML    private Button deleteButton;
    @FXML    private Button clearButton;
    @FXML    private TextField imagePathTextField;


    private final ObservableList<ContactsModifiedDetails> students = FXCollections.observableArrayList();

    public void initialize(){
        students.add(new ContactsModifiedDetails("Mellisa", "Enrith", "absd1234@gmail.com", "+9960005089012", "ContactsModifiedApp/profile_img/p2.jpg"));
        students.add(new ContactsModifiedDetails("Tom", "Clark", "tom123@gmail.com", "+080443211`", "ContactsModifiedApp/profile_img/p1.jpeg"));
        students.stream().sorted().map((s -> s.getLastName()));
        studentsListView.setItems(students);


        studentsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<ContactsModifiedDetails>() {
                            @Override
                            public void changed(ObservableValue<? extends ContactsModifiedDetails> ov, ContactsModifiedDetails oldValue, ContactsModifiedDetails t1) {
                                avatarImageView.setImage(new Image(t1.getImage()));
                                nameTextField.setText(t1.getName());
                                secondNameTextField.setText(t1.getLastName());
                                emailTextFiled.setText(t1.getEmail());
                                phoneTextField.setText(t1.getPhone());

                            }
                        }
                );
        studentsListView.setCellFactory(
                new Callback<ListView<ContactsModifiedDetails>, ListCell<ContactsModifiedDetails>>() {
                    @Override
                    public ListCell<ContactsModifiedDetails> call(ListView<ContactsModifiedDetails> listView) {
                        return new ContactsImage();
                    }
                }
        );



    }



    @FXML    void onAddPressed(ActionEvent event) {
        students.add(new ContactsModifiedDetails(nameTextField.getText(), secondNameTextField.getText(), emailTextFiled.getText(),phoneTextField.getText(), imagePathTextField.getText()));
        studentsListView.setItems(students);
    }

    @FXML
    void onCLearPressed(ActionEvent event) {
        nameTextField.setText("");
        secondNameTextField.setText("");
        emailTextFiled.setText("");
        phoneTextField.setText("");
        imagePathTextField.setText("");

    }

    @FXML
    void onDeletePressed(ActionEvent event) {
        try {
            ContactsModifiedDetails newContact = new ContactsModifiedDetails(nameTextField.getText(), secondNameTextField.getText(),
                    emailTextFiled.getText(),phoneTextField.getText(),imagePathTextField.getText() );

            students.removeIf(i-> i.getName().equals(newContact.getName()) && i.getLastName().equals(newContact.getLastName()) && i.getEmail().equals(newContact.getEmail()) && i.getPhone().equals(newContact.getPhone()) && i.getImage().equals(newContact.getImage()));
            studentsListView.setItems(students);
            nameTextField.setText("");
            secondNameTextField.setText("");
            emailTextFiled.setText("");
            phoneTextField.setText("");
            imagePathTextField.setText("");


        }
        catch (NumberFormatException ex) {
            nameTextField.setText("Not found!");
            secondNameTextField.setText("Not found!");

        }

    }

}
