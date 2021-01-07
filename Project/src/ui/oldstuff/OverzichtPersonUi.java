package ui.oldstuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import database.CRUD;
import domain.Student;

public class OverzichtPersonUi extends Application {

    @Override
    public void start(Stage window) {
        CreatePersonUi createPerson = new CreatePersonUi();
        BorderPane layout = new BorderPane();
        VBox vertical = new VBox();
        vertical.getChildren().add(new Label("Overzicht personen"));

        for (Student student : new CRUD().readTest()) {
            Label label = new Label();
            label.setText(student.getEmail());
            vertical.getChildren().add(label);
        }
        // Use import checklist in combination with for loop

        Button Aanmaken = new Button("Aanmaken");
        Aanmaken.setOnAction((event) -> {
            // Stage stageOverzicht = new Stage();
            try {
                createPerson.startCreatePerson();
                window.close();
            } catch (Exception E) {
                System.out.println("Something whent wrong!");
            }
        });

        HBox texts = new HBox();
        texts.setSpacing(30);
        texts.getChildren().add(Aanmaken);

        layout.setCenter(vertical);
        layout.setBottom(texts);

        StackPane root = new StackPane(layout);
        window.setTitle("Overzicht mensen");
        window.setScene(new Scene(root, 400, 250));
        window.show();
    }

    public static void main(String[] args) throws Exception {
        launch(OverzichtPersonUi.class);
        // hey ik ben luuk :) <3😎
    }

    public int countAmountInDatabase() {
        int i = 0;

        for (Student student : new CRUD().readTest()) {
           i++;
        }
        return i;
    }

}
