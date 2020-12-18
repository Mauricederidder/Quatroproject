package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import database.CRUD;

//extends Application
public class CreatePersonUi {

    public void startCreatePerson() throws Exception {
        OverzichtPersonUi overzichtUi = new OverzichtPersonUi();
        Button addPerson = new Button("Creeër in database");

        Label labelEmail = new Label("E-mail");
        TextArea textAreaEmail = new TextArea();
        textAreaEmail.setMinHeight(30);
        textAreaEmail.setMinWidth(300);
        textAreaEmail.setMaxHeight(30);
        textAreaEmail.setMaxWidth(300);

        Label labelNaam = new Label("Naam");
        TextArea textAreaNaam = new TextArea();
        textAreaNaam.setMinHeight(30);
        textAreaNaam.setMinWidth(300);
        textAreaNaam.setMaxHeight(30);
        textAreaNaam.setMaxWidth(300);

        Label labelGeboorteDag = new Label("Geboortedag");
        TextArea textAreaGeboorteDag = new TextArea();
        textAreaGeboorteDag.setMinHeight(30);
        textAreaGeboorteDag.setMinWidth(300);
        textAreaGeboorteDag.setMaxHeight(30);
        textAreaGeboorteDag.setMaxWidth(300);

        HBox hboxGenderButton = new HBox();
        Label labelGender = new Label("Gender");
        Button buttonGenderMan = new Button("Man");
        Button buttonGenderVrouw = new Button("Vrouw");
        hboxGenderButton.getChildren().add(buttonGenderMan);
        hboxGenderButton.getChildren().add(buttonGenderVrouw);
        hboxGenderButton.setSpacing(10);

        Label labelAdres = new Label("Adres");
        TextArea textAreaAdres = new TextArea();
        textAreaAdres.setMinHeight(30);
        textAreaAdres.setMinWidth(300);
        textAreaAdres.setMaxHeight(30);
        textAreaAdres.setMaxWidth(300);

        Label labelStad = new Label("Stad");
        TextArea textAreaStad = new TextArea();
        textAreaStad.setMinHeight(30);
        textAreaStad.setMinWidth(300);
        textAreaStad.setMaxHeight(30);
        textAreaStad.setMaxWidth(300);

        Label labelLand = new Label("Land");
        TextArea textAreaLand = new TextArea();
        textAreaLand.setMinHeight(30);
        textAreaLand.setMinWidth(300);
        textAreaLand.setMaxHeight(30);
        textAreaLand.setMaxWidth(300);

        Label labelPostcode = new Label("Postcode");
        TextArea textAreaPostcode = new TextArea();
        textAreaPostcode.setMinHeight(30);
        textAreaPostcode.setMinWidth(300);
        textAreaPostcode.setMaxHeight(30);
        textAreaPostcode.setMaxWidth(300);

        // Saving to a string (for database later ) String text = textArea.getText();

        BorderPane layout = new BorderPane();

        VBox spacing = new VBox();
        spacing.getChildren().add(labelEmail);

        spacing.getChildren().add(textAreaEmail);
        spacing.getChildren().add(labelNaam);
        spacing.getChildren().add(textAreaNaam);
        spacing.getChildren().add(labelGeboorteDag);
        spacing.getChildren().add(textAreaGeboorteDag);
        spacing.getChildren().add(labelGender);
        spacing.getChildren().add(hboxGenderButton);
        spacing.getChildren().add(labelAdres);
        spacing.getChildren().add(textAreaAdres);
        spacing.getChildren().add(labelStad);
        spacing.getChildren().add(textAreaStad);
        spacing.getChildren().add(labelLand);
        spacing.getChildren().add(textAreaLand);
        spacing.getChildren().add(labelPostcode);
        spacing.getChildren().add(textAreaPostcode);

        spacing.setSpacing(10);

        layout.setLeft(spacing);
        layout.setBottom(addPerson);

        Scene createPersonScene = new Scene(layout, 350, 700);
        Stage createPersonStage = new Stage();
        createPersonStage.setTitle("Creër persoon");
        createPersonStage.setScene(createPersonScene);
        createPersonStage.show();

        addPerson.setOnAction((event) -> {
            // Stage stageOverzicht = new Stage();
            try {
                // Insert add to database code
                String email = textAreaEmail.getText();
                new CRUD().create((overzichtUi.countAmountInDatabase()+1), email);

                Stage overzicht = new Stage();
                overzichtUi.start(overzicht);
                createPersonStage.close();
            } catch (Exception E) {
                System.out.println("Something whent wrong!");
            }
        });

        buttonGenderMan.setOnAction((event) -> {
            spacing.getChildren().remove(hboxGenderButton);
            spacing.getChildren().remove(labelGender);
            String gender = "man";

            spacing.getChildren().add(new Label("Gender: Man"));
        });

        buttonGenderVrouw.setOnAction((event) -> {
            spacing.getChildren().remove(hboxGenderButton);
            spacing.getChildren().remove(labelGender);
            String gender = "vrouw";
            
            spacing.getChildren().add(new Label("Gender: Vrouw"));
        });

    }
}
