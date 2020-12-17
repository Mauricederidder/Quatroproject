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

//extends Application
public class CreatePersonUi {

    public void startCreatePerson() throws Exception {
        OverzichtPersonUi overzichtUi = new OverzichtPersonUi();

        Label test = new Label("testtt");
        Button addPerson = new Button("Creeër in database");

        BorderPane layout = new BorderPane();
        layout.setTop(test);
        layout.setBottom(addPerson);

        Scene createPersonScene = new Scene(layout, 350, 250);
        Stage createPersonStage = new Stage();
        createPersonStage.setScene(createPersonScene);
        createPersonStage.show();



        addPerson.setOnAction((event) -> {
            // Stage stageOverzicht = new Stage();
            try {
                // Insert add to database code
                Stage overzicht = new Stage();
                overzichtUi.start(overzicht);
                createPersonStage.close();
            } catch (Exception E) {
                System.out.println("Something whent wrong!");
            }
        });

    }

    // public static void main(String[] args) throws Exception {
    // launch(CreatePersonUi.class);
    // // hey ik ben luuk :) <3😎
    // }
}
