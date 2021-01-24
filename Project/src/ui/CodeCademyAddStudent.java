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
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyAddStudentSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
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
        TextField TextFieldStudentVersion = codeCademyAddStudentTextFieldStudentContactVersion();
        TextField textFieldStudentName = codeCademyAddStudentTextFieldStudentName();
        TextField TextFieldStudentDescription = codeCademyAddStudentTextFieldStudentDescription();
        TextField TextFieldStudentContactName = codeCademyAddStudentTextFieldStudentContactName();
        TextField TextFieldStudentContactEmail = codeCademyAddStudentTextFieldStudentContactEmail();
        TextField TextFieldStudentPostalCode = codeCademyAddStudentTextFieldPostalCode();
        Button addStudentButton = codeCademyAddStudentButton();

        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentVersion());
        vbox.getChildren().add(TextFieldStudentVersion);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentName());
        vbox.getChildren().add(textFieldStudentName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentDescription());
        vbox.getChildren().add(TextFieldStudentDescription);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentContactName());
        vbox.getChildren().add(TextFieldStudentContactName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentContactEmail());
        vbox.getChildren().add(TextFieldStudentContactEmail);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddStudentTextFieldLabelStudentPostalcode());
        vbox.getChildren().add(TextFieldStudentPostalCode);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(addStudentButton);

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

    protected static Label codeCademyAddStudentTextFieldLabelStudentDescription() {
        Label TextFieldLabelOne = new Label("Gender: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentDescription() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Student Gender");
        return TextFieldStudentTag;
    }
    
    protected static Label codeCademyAddStudentTextFieldLabelStudentContactName() {
        Label TextFieldLabelOne = new Label("Address: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentContactName() {
        TextField TextFieldStudentTag = new TextField();
        TextFieldStudentTag.setText("Enter adress");
        return TextFieldStudentTag;
    }

    protected static Label codeCademyAddStudentTextFieldLabelStudentContactEmail() {
        Label TextFieldLabelOne = new Label("City: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddStudentTextFieldStudentContactEmail() {
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

}
