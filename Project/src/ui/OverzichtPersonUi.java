package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.CreatePersonUi;

public class OverzichtPersonUi extends Application {

    @Override
    public void start(Stage window) {
        CreatePersonUi createPerson = new CreatePersonUi();

        BorderPane layout = new BorderPane();
        VBox vertical = new VBox();
        vertical.getChildren().add(new Label("Overzicht personen"));

        Button overzicht = new Button("Overzicht");
        overzicht.setOnAction((event) -> {
           // Stage stageOverzicht = new Stage();
            try {
                createPerson.startCreatePerson();
            } catch (Exception E) {
                System.out.println("Something whent wrong!");
            }
        });

        HBox texts = new HBox();
        texts.setSpacing(30);
        texts.getChildren().add(overzicht);
        texts.getChildren().add(new Button("Aanmaken"));
        texts.getChildren().add(new Button("Updaten"));
        texts.getChildren().add(new Button("Verwijderen"));

        layout.setCenter(vertical);
        layout.setBottom(texts);

        StackPane root = new StackPane(layout);

        window.setScene(new Scene(root, 400, 250));
        window.show();
    }

    public static void main(String[] args) throws Exception {
        launch(OverzichtPersonUi.class);
        // hey ik ben luuk :) <3😎
    }

}
