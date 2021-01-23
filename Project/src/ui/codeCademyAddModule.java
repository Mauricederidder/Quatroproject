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

public class codeCademyAddModule {
    
    private static Course linkedCourse;

    protected static Scene CodeCademyAddModuleSceneBuilder(Course course) {
        linkedCourse = course;
        Scene codeCademyAllCoursesScene = new Scene(codeCademyAddModuleLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyAddModuleLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAddModuleGridHeader());
        root.setCenter(codeCademyAddModuleCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAddModuleCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddModuleTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyAddModuleGridHeader() {
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyAddModuleSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static VBox codeCademyAddModuleSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddModuleHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddModuleHeaderTitle() {
        Label title = new Label("Add Module");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 40));
        return title;
    }

    protected static VBox codeCademyAddModuleTextfieldVbox(){
        VBox vbox = new VBox();
        TextField TextFieldModuleVersion = codeCademyAddModuleTextFieldModuleContactVersion();
        TextField textFieldModuleName = codeCademyAddModuleTextFieldModuleName(); 
        TextField TextFieldModuleDescription = codeCademyAddModuleTextFieldModuleDescription();
        TextField TextFieldModuleContactName = codeCademyAddModuleTextFieldModuleContactName();
        TextField TextFieldModuleContactEmail = codeCademyAddModuleTextFieldModuleContactEmail();
        Button addModuleButton = codeCademyAddModuleButton();

        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleVersion());
        vbox.getChildren().add(TextFieldModuleVersion);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleName());
        vbox.getChildren().add(textFieldModuleName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleDescription());
        vbox.getChildren().add(TextFieldModuleDescription);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleContactName());
        vbox.getChildren().add(TextFieldModuleContactName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleContactEmail());
        vbox.getChildren().add(TextFieldModuleContactEmail);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(addModuleButton);

        addModuleButton.addEventHandler(MouseEvent.MOUSE_CLICKED, codeCademyAddModuleLogic.eventHandlerMouseClickedAddModule(TextFieldModuleVersion,textFieldModuleName, TextFieldModuleDescription,TextFieldModuleContactName,TextFieldModuleContactEmail, linkedCourse));
        return vbox;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleName() {
        Label TextFieldLabelOne = new Label("Module name: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleName() {
        TextField TextFieldModulename = new TextField();
        TextFieldModulename.setText("Module name");
        return TextFieldModulename;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleDescription() {
        Label TextFieldLabelOne = new Label("Module Descriptions: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleDescription() {
        TextField TextFieldModuleTag = new TextField();
        TextFieldModuleTag.setText("Module Description");
        return TextFieldModuleTag;
    }
    
    protected static Label codeCademyAddModuleTextFieldLabelModuleContactName() {
        Label TextFieldLabelOne = new Label("Contact Name: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleContactName() {
        TextField TextFieldModuleTag = new TextField();
        TextFieldModuleTag.setText("Enter contact name");
        return TextFieldModuleTag;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleContactEmail() {
        Label TextFieldLabelOne = new Label("Contact Email: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleContactEmail() {
        TextField TextFieldModuleTag = new TextField();
        TextFieldModuleTag.setText("Enter contact Email");
        return TextFieldModuleTag;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleVersion() {
        Label TextFieldLabelOne = new Label("Module Version ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleContactVersion() {
        TextField TextFieldModuleTag = new TextField();
        TextFieldModuleTag.setText("1.0");
        return TextFieldModuleTag;
    }

    protected static Button codeCademyAddModuleButton() {
        Button button = new Button("Add Module");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        button.setTextFill(Color.web("#FFFFFF"));
        ;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

}
