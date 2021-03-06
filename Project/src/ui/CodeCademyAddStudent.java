package ui;

import domain.Course;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyAddStudent {

    protected static Scene codeCademyAddStudentSceneBuilder() {
        Scene codeCademyAllCoursesScene = new Scene(codeCademyAddStudentLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyAddStudentLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAddStudentGridHeader());
        root.setCenter(codeCademyAddStudentCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAddStudentCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddStudentTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyAddStudentGridHeader() {
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(codeCademyAccountInformationBackButton(), 0, 0);
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyAddStudentSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static Button codeCademyAccountInformationBackButton(){
        Button button = new Button("Back");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAccountInformationLogic.eventHandlerBack());
        button.setAlignment(Pos.TOP_LEFT);
        return button;
    }

    protected static VBox codeCademyAddStudentSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddStudentHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddStudentHeaderTitle() {
        Label title = new Label("Add Student");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 40));
        return title;
    }

    protected static VBox codeCademyAddStudentTextfieldVbox() {
        VBox vbox = new VBox();
        TextField TextFieldStudentEmail = codeCademyAddStudentTextFieldStudentContactVersion();
        TextField textFieldStudentName = codeCademyAddStudentTextFieldStudentName();
        ComboBox TextFieldStudentGender = codeCademyAddStudentTextFieldStudentGender();
        TextField TextFieldStudentAddress = codeCademyAddStudentTextFieldStudentContactAddress();
        TextField TextFieldStudentContactCity = codeCademyAddStudentTextFieldStudentContactCity();
        TextField TextFieldStudentPostalCode = codeCademyAddStudentTextFieldPostalCode();
        Button addStudentButton = codeCademyAddStudentButton();

        Label error = codeCademyAddStudentStudentError();

        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentVersion());
        vbox.getChildren().add(TextFieldStudentEmail);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentName());
        vbox.getChildren().add(textFieldStudentName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentGender());
        vbox.getChildren().add(TextFieldStudentGender);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentAddress());
        vbox.getChildren().add(TextFieldStudentAddress);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentContactCity());
        vbox.getChildren().add(TextFieldStudentContactCity);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentPostalcode());
        vbox.getChildren().add(TextFieldStudentPostalCode);
        vbox.getChildren().add(new Label(""));

        vbox.getChildren().add(addStudentButton);
        vbox.getChildren().add(error);
        addStudentButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAddStudentLogic.EventHandlerMouseClickAddStudent(TextFieldStudentEmail, textFieldStudentName, TextFieldStudentGender, TextFieldStudentAddress,TextFieldStudentContactCity, TextFieldStudentPostalCode,error));


        return vbox;
    }

    private static TextField codeCademyAddStudentTextFieldPostalCode() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Enter postalcode");
        return TextFieldStudentTag;
    }

    private static Label codeCademyAddStudentTextFieldLabelStudentPostalcode() {
        Label TextFieldLabelOne = new Label("Postalcode: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static Label codeCademyAddStudentTextFieldLabelStudentName() {
        Label TextFieldLabelOne = new Label("Student name: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentName() {
        TextField TextFieldStudentname = new TextField();
        TextFieldStudentname.setText("Student name");
        return TextFieldStudentname;
    }

    protected static Label codeCademyAddStudentTextFieldLabelStudentGender() {
        Label TextFieldLabelOne = new Label("Gender: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static ComboBox codeCademyAddStudentTextFieldStudentGender() {
        ComboBox combobox = new ComboBox();
        combobox.getItems().addAll(
            "Male",
            "Female"
        );
       combobox.getSelectionModel().selectFirst();
        return combobox;
    }
    
    protected static Label codeCademyAddStudentTextFieldLabelStudentAddress() {
        Label TextFieldLabelOne = new Label("Address: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentContactAddress() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Enter adress");
        return TextFieldStudentTag;
    }

    protected static Label codeCademyAddStudentTextFieldLabelStudentContactCity() {
        Label TextFieldLabelOne = new Label("City: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentContactCity() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Enter city");
        return TextFieldStudentTag;
    }

    protected static Label codeCademyAddStudentTextFieldLabelStudentVersion() {
        Label TextFieldLabelOne = new Label("Student Email ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentContactVersion() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Enter E-maill");
        return TextFieldStudentTag;
    }

    protected static Button codeCademyAddStudentButton() {
        Button button = new Button("Add Student");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        button.setTextFill(Color.web("#FFFFFF"));
        ;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

    protected static Label codeCademyAddStudentStudentError() {
        Label error = new Label("Please enter valid data ");
        error.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        error.setTextFill(Color.web("#FF0000", 1.0));
        error.setVisible(false);
        return error;
    }


}
