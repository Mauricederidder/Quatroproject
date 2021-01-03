package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import database.CRUD;

public class CreatePersonUi {

    public void startCreatePerson() throws Exception {
        OverzichtPersonUi overzichtUi = new OverzichtPersonUi();

        // Label&TextArea code duplication in getSpacingVbox method, discuss with team
        // how to fix this
        // All labels
        Label labelEmail = new Label("E-mail");
        Label labelNaam = new Label("Naam");
        Label labelGeboorteDag = new Label("Geboortedag");
        Label labelGender = new Label("Gender");
        Label labelAdres = new Label("Adres");
        Label labelStad = new Label("Stad");
        Label labelLand = new Label("Land");
        Label labelPostcode = new Label("Postcode");

        // All text areas
        TextArea textAreaEmail = getTextAreaEmail();
        TextArea textAreaNaam = getTextAreaNaam();
        TextArea textAreaGeboorteDag = getTextAreaGeboorteDag();
        TextArea textAreaAdres = getTextAreaAdres();
        TextArea textAreaStad = getTextAreaStad();
        TextArea textAreaLand = getTextAreaLand();
        TextArea textAreaPostcode = getTextAreaPostcode();

        // Creates the button to add the person in the database
        Button addPerson = new Button("Creeër in database");

        //Creates the button to add choose between a man or a woman, discuss with team if we need an gender neutral option
        Button buttonGenderMan = new Button("Man");
        Button buttonGenderVrouw = new Button("Vrouw");

        // Create the layout of the scene
        VBox spacing = getSpacingVbox(buttonGenderMan, buttonGenderVrouw );
        BorderPane layout = new BorderPane();
        layout.setLeft(spacing);
        layout.setBottom(addPerson);

        //Creates the scene and the stage of the scene, Discuss with team if we can clean this up any further.
        Scene createPersonScene = new Scene(layout, 350, 700);
        Stage createPersonStage = new Stage();
        createPersonStage.setTitle("Creër persoon");
        createPersonStage.setScene(createPersonScene);
        createPersonStage.show();


        addPerson.setOnAction((event) -> {
            try {
                // Insert add to database code
                String email = textAreaEmail.getText();
                new CRUD().create((overzichtUi.countAmountInDatabase() + 1), email);

                Stage overzicht = new Stage();
                overzichtUi.start(overzicht);
                createPersonStage.close();
            } catch (Exception E) {
                System.out.println("Something whent wrong!");
            }
        });

        buttonGenderMan.setOnAction((event) -> {
            spacing.getChildren().remove(7);
            spacing.getChildren().remove(6);
            String gender = "man";

            spacing.getChildren().add(new Label("Gender: Man"));
        });

        buttonGenderVrouw.setOnAction((event) -> {
            spacing.getChildren().remove(7);
            spacing.getChildren().remove(6);
            String gender = "vrouw";

            spacing.getChildren().add(new Label("Gender: Vrouw"));
        });

    }

    // Returns the textArea for the create email
    public TextArea getTextAreaEmail() {
        TextArea textAreaEmail = new TextArea();
        textAreaEmail.setMinHeight(30);
        textAreaEmail.setMinWidth(300);
        textAreaEmail.setMaxHeight(30);
        textAreaEmail.setMaxWidth(300);
        return textAreaEmail;
    }

    // Returns the textArea for the create naam
    public TextArea getTextAreaNaam() {
        TextArea textAreaNaam = new TextArea();
        textAreaNaam.setMinHeight(30);
        textAreaNaam.setMinWidth(300);
        textAreaNaam.setMaxHeight(30);
        textAreaNaam.setMaxWidth(300);
        return textAreaNaam;
    }

    // Returns the textArea for the create GeboorteDag
    public TextArea getTextAreaGeboorteDag() {
        TextArea textAreaGeboorteDag = new TextArea();
        textAreaGeboorteDag.setMinHeight(30);
        textAreaGeboorteDag.setMinWidth(300);
        textAreaGeboorteDag.setMaxHeight(30);
        textAreaGeboorteDag.setMaxWidth(300);
        return textAreaGeboorteDag;
    }

    // Returns the textArea for the create Adres
    public TextArea getTextAreaAdres() {
        TextArea textAreaAdres = new TextArea();
        textAreaAdres.setMinHeight(30);
        textAreaAdres.setMinWidth(300);
        textAreaAdres.setMaxHeight(30);
        textAreaAdres.setMaxWidth(300);
        return textAreaAdres;
    }

    // Returns the textArea for the create Stad
    public TextArea getTextAreaStad() {
        TextArea textAreaStad = new TextArea();
        textAreaStad.setMinHeight(30);
        textAreaStad.setMinWidth(300);
        textAreaStad.setMaxHeight(30);
        textAreaStad.setMaxWidth(300);
        return textAreaStad;
    }

    // Returns the textArea for the create Land
    public TextArea getTextAreaLand() {
        TextArea textAreaLand = new TextArea();
        textAreaLand.setMinHeight(30);
        textAreaLand.setMinWidth(300);
        textAreaLand.setMaxHeight(30);
        textAreaLand.setMaxWidth(300);
        return textAreaLand;
    }

    // Returns the textArea for the create Postcode
    public TextArea getTextAreaPostcode() {
        TextArea textAreaPostcode = new TextArea();
        textAreaPostcode.setMinHeight(30);
        textAreaPostcode.setMinWidth(300);
        textAreaPostcode.setMaxHeight(30);
        textAreaPostcode.setMaxWidth(300);
        return textAreaPostcode;
    }

    public VBox getSpacingVbox(Button buttonGenderMan, Button buttonGenderVrouw ) {

        // Label&TextArea code duplication in startCreatePerson method, discuss with
        // team how to fix this
        Label labelEmail = new Label("E-mail");
        Label labelNaam = new Label("Naam");
        Label labelGeboorteDag = new Label("Geboortedag");
        Label labelGender = new Label("Gender");
        Label labelAdres = new Label("Adres");
        Label labelStad = new Label("Stad");
        Label labelLand = new Label("Land");
        Label labelPostcode = new Label("Postcode");
        TextArea textAreaEmail = getTextAreaEmail();
        TextArea textAreaNaam = getTextAreaNaam();
        TextArea textAreaGeboorteDag = getTextAreaGeboorteDag();
        TextArea textAreaAdres = getTextAreaAdres();
        TextArea textAreaStad = getTextAreaStad();
        TextArea textAreaLand = getTextAreaLand();
        TextArea textAreaPostcode = getTextAreaPostcode();

        HBox hboxGenderButton = getGenderButtonHBox(buttonGenderMan,buttonGenderVrouw);

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

        return spacing;
    }

    public HBox getGenderButtonHBox(Button buttonGenderMan, Button buttonGenderVrouw) {
        HBox hboxGenderButton = new HBox();

        hboxGenderButton.getChildren().add(buttonGenderMan);
        hboxGenderButton.getChildren().add(buttonGenderVrouw);
        hboxGenderButton.setSpacing(10);
        return hboxGenderButton;
    }

}
